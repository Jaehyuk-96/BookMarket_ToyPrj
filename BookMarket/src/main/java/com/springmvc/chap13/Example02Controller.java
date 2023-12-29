package com.springmvc.chap13;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/exam02")
public class Example02Controller {

    @GetMapping
    public String showFrom(Model model){
        model.addAttribute("member", new Member());
        return "webpage13_02";
    }

    @PostMapping
    public String submit(@Valid @ModelAttribute Member member, Errors errors){
        if(errors.hasErrors()) {
            return "webpage13_02";
        }
        return "webpage13_result";
    }
}
