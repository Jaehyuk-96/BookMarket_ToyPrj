package com.springmvc.controller;

import com.springmvc.domain.DataBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {

    @GetMapping("/test1")
    public String test1(DataBean bean , Model model) {

        String[] data_list2 = {"radio1", "radio2", "radio3", "radio4", "radio5"};
        model.addAttribute("data_list2", data_list2);
        bean.setA2("radio3");
        return "test1";
    }
}
