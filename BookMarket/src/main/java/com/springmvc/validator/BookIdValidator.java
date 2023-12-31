package com.springmvc.validator;

import com.springmvc.domain.Book;
import com.springmvc.exception.BookIdException;
import com.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//사용자 정의 애너테이션 BookId
public class BookIdValidator implements ConstraintValidator <BookId, String>{

    @Autowired
    private BookService bookService;

    public void initialize(BookId constraintAnnotation) {//BookId 초기화

    }

    public boolean isValid(String value, ConstraintValidatorContext context){//유효성 검사
        Book book;
        try{
            book = bookService.getBookById(value);
        }catch (BookIdException e) {
            return true;
        }
        if (book != null){
            return false;
        }
        return true;
    }
}
