package com.springmvc.validator;

import com.springmvc.domain.Book;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UnitsInStockValidator implements Validator {
    public boolean supports(Class<?> clazz){ //Book 클래스의 유효성 검사 여부를 위한 메서드

        return Book.class.isAssignableFrom(clazz);//객체가 나타내는 클래스 또는 인터페이스가 지정된
        //Class 매개변수로 표시된 클래스 또는 인터페이스와 동일하거나, 상위 클래스 또는 상위 인터페이스 인지 체크
    }

    public void validate(Object target, Errors errors) { // Book 클래스의 유효성 검사 메서드
        Book book = (Book) target;
        if (book.getUnitPrice() >= 10000 && book.getUnitsInStock() > 99) {//도서가격이 10000원이상이고 재고가 99보다 클때 오류발생
            //오류 객체의 속성과 메시지 저장
            errors.rejectValue("unitsInStock", "UnitsInStockValidator.message");
        }

    }
}
