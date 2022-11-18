package com.login.jwt.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class JwtRequest {

    private String userName;
    private String userPassword;

//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getUserPassword() {
//        return userPassword;
//    }
//
//    public void setUserPassword(String userPassword) {
//        this.userPassword = userPassword;
//    }
}
