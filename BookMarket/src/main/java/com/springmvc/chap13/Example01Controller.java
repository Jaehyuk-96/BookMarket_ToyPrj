//package com.springmvc.chap13;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.ModelAttribute;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestMapping;
////
////import javax.validation.Valid;
////
////@Controller
////@RequestMapping("/exam01")
////public class Example01Controller {
////    @GetMapping
////    public String showForm(Model model) {
////        model.addAttribute("product", new Product());
////        return "webpage13_01";
////    }
////
////    @PostMapping
////    public String submit(@Valid @ModelAttribute Product product, Errors errors){
////
////        if(errors.hasErrors())
////            return "webpage13_01";
////
////        return "webpage13_result";
////    }
////}
