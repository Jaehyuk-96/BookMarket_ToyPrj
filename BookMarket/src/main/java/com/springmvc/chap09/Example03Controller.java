package com.springmvc.chap09;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/exam03")
public class Example03Controller {

    @GetMapping("/form")
    public String requestForm(Member member) {
        return "webpage09_02";

    }

    @PostMapping("/form")
    public String submitForm(@ModelAttribute("member") Member member, HttpServletRequest request, HttpSession session){
        String name = member.getName();
        String filename = member.getImageFile().getOriginalFilename();
        try{
            member.getImageFile().transferTo(new File("d:\\upload\\" + name + "_" + filename));
        }catch(IOException e){
            e.printStackTrace();
        }
        return "webpage09_submit";
    }
}
