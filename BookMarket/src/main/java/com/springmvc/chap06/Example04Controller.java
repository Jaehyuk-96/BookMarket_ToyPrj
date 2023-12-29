//package com.springmvc.chap06;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.MatrixVariable;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller("chap064")
//@RequestMapping("/home")
//public class Example04Controller {
//
//    @GetMapping("/exam04/{bookId}/category/{category}")
//    public String requestMethod(@MatrixVariable(value = "publisher", pathVar = "bookId") String q1,
//                                @MatrixVariable(value = "publisher", pathVar = "category") String q2, Model model){
//        System.out.println("출판사:"+q1);
//        System.out.println("출판사:"+q2);
//
//        model.addAttribute("data", "출판사1:" + q1 + "<br>" + "출판사2:" + q2);
//        return "webpage06";
//    }
//}
