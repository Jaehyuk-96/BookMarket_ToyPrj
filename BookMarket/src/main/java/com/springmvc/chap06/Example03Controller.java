//package com.springmvc.chap06;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.MatrixVariable;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller("chap063")
//@RequestMapping("/home")
//public class Example03Controller {
//
//    @GetMapping("/exam03/{bookId}")
//    public String requestMethod(@PathVariable String bookId, @MatrixVariable String category, Model model){
//        System.out.println("도서 Id:"+bookId);
//        System.out.println("도서분야:"+category);
//
//        model.addAttribute("data", "도서 분야 " + category + "<br>" + "도서ID:" + bookId);
//        return "webpage06";
//    }
//}
