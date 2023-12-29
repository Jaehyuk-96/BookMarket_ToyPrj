package com.springmvc.chap07;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Example04Controller {
    @GetMapping("/exam04")
    public String showForm(Model model){
        model.addAttribute("member", new Member());
        return "webpage07";
    }

    @PostMapping("/exam04")
    public String submit(@ModelAttribute Member member, Model model){
        model.addAttribute("member", member);
        return "webpage07_02";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setAllowedFields("id", "password", "city", "sex");
    }
}
