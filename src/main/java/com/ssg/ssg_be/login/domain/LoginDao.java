package com.ssg.ssg_be.login.domain;

import com.ssg.ssg_be.signup.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class LoginDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

//    public User getPwd(PostLoginReq postLoginReq) {
//        String getPwdQuery = "select * from user where email = ?";
//        String getPwdParams = postLoginReq.getEmail();
//
//        return this.jdbcTemplate.queryForObject(getPwdQuery,
//                (rs.rowNum)-> new User(
//                        rs.getInt("id"),
//                        rs.getString("email"),
//                        rs.getString("password"),
//                        rs.getString("phone_number"),
//                        rs.getString("nickname")),
//                getPwdParams
//                );
//    }

//    public int checkEmail(String email) {
//        String checkEmailQuery = "select exists(select id from user where id = ?");
//        String checkEmailParams = email;
//        return this.jdbcTemplate.queryForObject(checkEmailQuery, int.class, checkEmailParams);
//    }

//    public KakaoToken getKakaoToken(int userId) {
//        String getRefreshTokenQuery = "select access_token, refresh_token from user where id = ?";
//        int getRefreshTokenParams = userId;
//        return this.jdbcTemplate.queryForObject(getRefreshTokenQuery,
//                (rs, rowNum) -> new KakaoToken(
//                        rs.getString("access_token"),
//                        rs.getString("refresh_token")
//                ),
//                getRefreshTokenParams);
//    }
//
//    public int updateKakaoToken(int userId, KakaoToken kakaoToken) {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        String updateKakaoTokenQuery = "update user set update_at = ?, access_token = ?, refresh_token = ? where id = ?";
//        Object[] updateKakaoTokenParams = new Object[]{localDateTime, kakaoToken.getAccess_token(), kakaoToken.getRefresh_token(), userId};
//        return this.jdbcTemplate.update(updateKakaoTokenQuery,updateKakaoTokenParams);
//    }
//
//    public int getUserInfo(String email) {
//        String getUserInfoQuery = "select id from user where email = ?";
//        String getUserInfoParams = email;
//        return this.jdbcTemplate.queryForObject(getUserInfoQuery, int.class, getUserInfoParams);
//    }


}
