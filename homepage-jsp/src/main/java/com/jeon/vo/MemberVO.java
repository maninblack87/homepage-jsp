package com.jeon.vo;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

/**
 * 회원 정보를 담는 객체
 */
public class MemberVO {

    @NotBlank(message="아이디는 필수입니다.")
    @Size(min=5, max=20, message="아이디는 5~20자입니다.")
    private String id;

    @NotBlank(message="비밀번호는 필수입니다.")
    @Pattern(regexp="^[A-Za-z0-9]+$", message="비밀번호는 영문(대소문자)과 숫자만 가능합니다.")
    @Size(min=2, max=20, message="비밀번호는 2~20자입니다.")
    private String password;

    @NotBlank(message="사용자명은 필수입니다")
    private String name;

    @Pattern(regexp = "^(admin|manager|user)$", message="권한은 admin|manager|user 중 하나여야 합니다.")
    private String role = "user";
    private LocalDateTime createAt;

    // 기본 생성자
    public MemberVO(){
        this.createAt = LocalDateTime.now();
    }

    // Getter 함수
    public String getId() { return id; }
    public String getPassword(){ return password; }
    public String getName(){ return name; }
    public String getRole(){ return role; }
    public LocalDateTime getCreateAt(){ return createAt; }

    // Setter 함수
    public void setId(String id){ this.id = id; }
    public void setPassword(String password){ this.password = password; }
    public void setName(String name){ this.name = name; }
    public void setRole(String role){ this.role = role; }
    public void setCreateAt(LocalDateTime createAt){ this.createAt = createAt; }

}