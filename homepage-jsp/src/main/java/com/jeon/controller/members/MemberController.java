package com.jeon.controller.members;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;      // 스프링 자동 연결 도구
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeon.vo.MemberVO;

@Controller
@RequestMapping("/members")
public class MemberController {

    // [스프링 자동 연결 도구] - 몽고DB 작업 처리자를 자동으로 가져온다
    @Autowired
    private MongoTemplate mongoTemplate;

    // [로그인 페이지 접속]
    @GetMapping("/accessLoginPage")
    public String accessLoginPage(){
        return "members/login";
    }

    // [로그인 처리]
    @PostMapping("/processLogin")
    public String processLogin(
        @RequestParam("id") String id,
        @RequestParam("password") String password,
        HttpSession session
    ) {
        // 필터
        Query query = new Query(Criteria.where("id").is(id));

        // 1. 해당 회원 조회 : 일치하는 "아이디"를 "우선" 찾는다
        // 2. 로그인 정보 저장 : (1)이 성공하면 데이터베이스의 정보가 저장된다
        MemberVO loginMember = mongoTemplate.findOne(query, MemberVO.class, "members");

        // 로그인 판별
        // 1. 해당 회원 존재 여부 판별
        // 2. 해당 회원의 비밀번호 대조 : {입력값:DB정보}의 회원 비밀번호
        if (loginMember != null && loginMember.getPassword().equals(password)){
            // 로그인 판별 성공시
            // 세션에 해당 회원의 정보를 저장(DB에서 가져온 정보를 저장한다)
            session.setAttribute("loginUser", loginMember);
            return "redirect:/";
        } else {
            // 로그인 판별 실패시
            // 1. 에러 표시, 로그인 페이지로 다시 이동
            return "redirect:/members/accessLoginPage?error=true";
        }
    }

    // [회원가입 페이지 접속]
    @GetMapping("/accessRegisterPage")
    public String accessRegisterPage(){
        return "members/register";
    }

    // [회원가입 처리]
    @PostMapping("/processRegister")
    public String processRegister(
        @Valid MemberVO registerMember,   // [검증 스위치] - VO에 정의된 규칙(제약조건 따위) 검사를 수행한다
        BindingResult result          // [검증 결과 리포트] - 합격/불합격 판정을 기록한다
    ) {
        if (result.hasErrors()){
            return "members/join";
        }

        try{
            // 데이터베이스(몽고DB)에 저장한다
            mongoTemplate.insert(registerMember, "members");
        } catch (Exception e) {
            return "redirect:/members/accessRegisterPage?dbError=true";
        }

        // 회원가입이 (정상적으로) 처리되면, 바로 로그인 페이지로 이동한다
        return "redirect:/members/accessLoginPage";
    }

    // [로그아웃 처리]
    @GetMapping("/processLogout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

}