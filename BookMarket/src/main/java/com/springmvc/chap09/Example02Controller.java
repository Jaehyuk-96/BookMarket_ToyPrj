//package com.springmvc.chap09;
//
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import java.io.File;
//import java.io.IOException;
//
//@Controller
//@RequestMapping("/exam02")
//public class Example02Controller {
//
//    @GetMapping("/form")
//    public String requestForm() {
//        return "webpage09_01";
//    }
//
//    @PostMapping("/form")
//    public String submitForm(MultipartHttpServletRequest request) {
//        String name = request.getParameter("name");
//        MultipartFile file = request.getFile("fileImage");
//        String filename = file.getOriginalFilename();
//        File f = new File("D:\\upload\\"+name+"_"+filename);
//        try{
//            file.transferTo(f);
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//        return "webpage09_submit";
//    }

//}
