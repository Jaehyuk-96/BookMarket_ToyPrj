package com.springmvc.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class BookIdException extends RuntimeException{

    private String bookId;


}
