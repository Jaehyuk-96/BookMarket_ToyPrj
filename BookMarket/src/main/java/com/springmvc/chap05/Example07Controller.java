//package com.springmvc.chap05;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@RequestMapping("/home")
//public class Example07Controller {
//
//    @GetMapping("/exam07")
//    public ModelAndView requestMethod(ModelMap model){
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("data", "ModelAndView 예제입니다.");
//        mav.addObject("data2", "웹 요청 url은 /home/exam07입니다.");
//        mav.setViewName("webpage05");
//        return mav;
//
//    }
//}
