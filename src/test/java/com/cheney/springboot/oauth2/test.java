package com.cheney.springboot.oauth2;

import com.cheney.springboot.oauth2.utils.MD5Encoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test{

    @Test
    public void MD5Encode(){
        MD5Encoder encoder=new MD5Encoder();
        String en=encoder.MD5Encode("qwe123","");
        System.out.println(en);

        Md5PasswordEncoder encoder1=new Md5PasswordEncoder();
        String en2=encoder1.encodePassword("qwe123","");
        System.out.println(en2);
    }
}