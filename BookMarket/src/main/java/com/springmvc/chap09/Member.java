package com.springmvc.chap09;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class Member {
    private String name;
    private MultipartFile imageFile;
}
