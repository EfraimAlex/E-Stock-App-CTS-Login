package com.login.jwt;

import com.login.jwt.entity.JwtRequest;
import com.login.jwt.service.JwtService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class loginjwtApplicationTests {
    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost";
    @Autowired
    private JwtService jwtService;
    @Autowired
    private static RestTemplate restTemplate;


//    @Test
//    void contextLoads() {
//    }
@BeforeAll
public static void init() {
    restTemplate = new RestTemplate();
}

    @BeforeEach
    public void setUp() {
        baseUrl = baseUrl.concat(":").concat(port + "").concat("/authenticate");
    }

    @Test
    void testcreatetoken() throws Exception {
        JwtRequest jwt=new JwtRequest("admin123","admin@pass");
       String token= String.valueOf(jwtService.createJwtToken(jwt));
        String tocken="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjEyMyIsImV4cCI6MTY2NzIxMjk3NCwiaWF0IjoxNjY3MTk0OTc0fQ.iTbnLQGK_VHDZbbI6IjC1K37sr5AbN2FtzO6-R6DKPMIphCr_sT5oNqAbhQRKTGvClu8RVbnVDmHnaAyTeR_8Q";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+tocken);
        HttpEntity<JwtRequest> request = new HttpEntity<>(jwt, headers);
        JwtRequest responce=restTemplate.postForObject(baseUrl,request, JwtRequest.class);
       assertNotNull(token);
    }
//    @Test
//    void testuserdetails(){
//        com.login.jwt.entity.User user=new com.login.jwt.entity.User("admin123","vijay","vijay","admin@pass","admin");
//        UserDetails user=new User()
//    String username= String.valueOf(jwtService.loadUserByUsername("admin123"));
//    assertEquals(userName,username);
//    }
}
