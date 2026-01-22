package com.jeon.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
    
    // ☆★☆ 해싱을 수행하는 도구 ☆★☆
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // [함수1] 회원가입 할 때, 사용할 비밀번호를 해싱시키는 함수
    public static String encodePassword(String rawPassword){
        return encoder.encode(rawPassword);
    }

    // [함수2] 로그인 할 때, 사용할 비밀번호와 해싱된 비밀번호가 일치하는지 확인하는 함수
    public static boolean matchesPasswords(String rawPassword, String encodedPassword){
        return encoder.matches(rawPassword, encodedPassword);
    }

}