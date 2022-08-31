package com.ssg.utils.s3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class S3UploadDtoReq {

    private String saveName;
    private String imgUrl;

}
