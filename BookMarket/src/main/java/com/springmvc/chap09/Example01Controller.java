package com.springmvc.chap09;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/exam01")
public class Example01Controller {

    @GetMapping("/form")
    public String reqeustForm() {
        return "webpage09_01";
    }

    @PostMapping("/form")
    public String submitForm(@RequestParam("name") String name, @RequestParam("fileImage")MultipartFile file){
        String filename = file.getOriginalFilename();
        File f = new File("C:\\upload\\" + name + "_" + filename);

        try{
            file.transferTo(f);
        }catch (IOException e){
            e.printStackTrace();
        }
        return "webpage09_submit";
    }
}
