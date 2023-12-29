//package com.springmvc.chap06;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller("chap062")
//@RequestMapping("/home")
//public class Example02Controller {
//
//    @GetMapping("/exam02/{category}/publisher/{publisher}")
//    public String requestMethod(@PathVariable String category, @PathVariable String publisher, Model model){
//        System.out.println("도서분야:"+category);
//        System.out.println("출판사:"+publisher);
//        model.addAttribute("data", "도서 분야 " + category + "<br>" + "출판사:" + publisher);
//        return "webpage06";
//    }
//}
