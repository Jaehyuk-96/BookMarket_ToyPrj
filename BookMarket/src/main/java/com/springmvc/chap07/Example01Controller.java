//package com.springmvc.chap07;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class Example01Controller {
//
//    @GetMapping("/member")
//    public String showForm(Model model) {
//        Member member = new Member();
//        System.out.println("@GetMapping---------------");
//        System.out.println("아이디:"+member.getId());
//        System.out.println("비밀번호:"+member.getPassword());
//        System.out.println("거주지:"+member.getCity());
//        System.out.println("성별:"+member.getSex());
//        System.out.println("취미:"+member.getHobby());
//        model.addAttribute("member", member);
//        return "webpage07";
//
//    }
//}
