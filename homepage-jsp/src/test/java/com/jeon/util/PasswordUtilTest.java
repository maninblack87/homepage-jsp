package com.jeon.util;

import org.junit.Test;

public class PasswordUtilTest {
    
    @Test
    public void getAdminPassword(){
        String rawPassword = "1234";        // ☆★☆ <== 총관리자(혹은 관리자)가 직접 ""안에 사용할 비밀번호를 입력 해야한다 ☆★☆
        String hashed = PasswordUtil.encodePassword(rawPassword);
        
        System.out.println("\n==============================");
        System.out.println("총관리자 해시값: " + hashed);
        System.out.println("==============================\n");
    }

}
