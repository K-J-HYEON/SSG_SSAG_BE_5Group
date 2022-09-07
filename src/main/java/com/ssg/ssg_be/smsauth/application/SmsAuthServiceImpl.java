package com.ssg.ssg_be.smsauth.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssg.config.BaseException;
import com.ssg.ssg_be.smsauth.dto.MessagesDto;
import com.ssg.ssg_be.smsauth.dto.MessagesDtoReq;
import com.ssg.ssg_be.smsauth.dto.SmsAuthDtoReq;
import com.ssg.ssg_be.smsauth.dto.SmsAuthDtoRes;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import static com.ssg.config.BaseResponseStatus.*;

@Service
public class SmsAuthServiceImpl implements SmsAuthService {

    @Value("${sms.serviceId}")
    private String serviceId;

    @Value("${sms.accessKey}")
    private String accessKey;

    @Value("${sms.secretKey}")
    private String secretKey;

    @Value("${sms.phone}")
    private String phone;

    @Override
    public SmsAuthDtoRes sendMsg(SmsAuthDtoReq smsAuthDtoReq) throws BaseException {
        String time = Long.toString(System.currentTimeMillis());
        List<MessagesDto> messagesDtos = new ArrayList<>();
        messagesDtos.add(new MessagesDto(smsAuthDtoReq.getRecipientPhoneNumber(), "[" + smsAuthDtoReq.getContent() + "]를 입력해 주세요."));

        MessagesDtoReq messagesDtoReq = new MessagesDtoReq("SMS", "COMM", "82", phone, "SMS 문자 인증", messagesDtos);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody = null;

        try {
            jsonBody = objectMapper.writeValueAsString(messagesDtoReq);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BaseException(OBJECT_TO_JSON_FAILED);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-ncp-apigw-timestamp", time);
        headers.set("x-ncp-iam-access-key", this.accessKey);
        String sig = makeSignature(time);
        headers.set("x-ncp-apigw-signature-v2", sig);

        HttpEntity<String> body = new HttpEntity<>(jsonBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        SmsAuthDtoRes smsAuthDtoRes = null;
        try {
            smsAuthDtoRes = restTemplate.postForObject(new URI("https://sens.apigw.ntruss.com/sms/v2/services/" + this.serviceId + "/messages"), body, SmsAuthDtoRes.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new BaseException(CREATE_URI_FAILED);
        }

        return smsAuthDtoRes;
    }

    public String makeSignature(String time) throws BaseException {

        String space = " ";
        String newLine = "\n";
        String method = "POST";
        String url = "/sms/v2/services/" + this.serviceId + "/messages";
        String accessKey = this.accessKey;
        String secretKey = this.secretKey;

        String message = new StringBuilder()
                .append(method)
                .append(space)
                .append(url)
                .append(newLine)
                .append(time)
                .append(newLine)
                .append(accessKey)
                .toString();

        SecretKeySpec signingKey = null;
        Mac mac = null;
        String encodeBase64String = null;

        try {
            signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
            mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);

            byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
            encodeBase64String = Base64.encodeBase64String(rawHmac);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            throw new BaseException(CREATE_SIGNATURE_FAILED);
        }

        return encodeBase64String;
    }
}
