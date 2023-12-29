package com.springmvc.chap13;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

@Getter
@Setter
public class Member {

    @NotNull
    @Size(min=4, max=10)
    private String memberName;

    @Min(value=10)
    @Max(value=120)
    private int age;

    @Email
    private String email;

    @NumberFormat
    private int number;


}
