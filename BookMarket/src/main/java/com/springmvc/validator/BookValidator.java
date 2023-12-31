package com.springmvc.validator;

import com.springmvc.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Set;

@Component
public class BookValidator implements Validator {

    @Autowired
    private javax.validation.Validator beanValidator;//JSR-303 메서드 선언

    private Set<Validator> springValidators;//spring validation(Validator 인터페이스)의 인스턴스 선언

    public BookValidator() {//BookValidator 생성자

        springValidators = new HashSet<Validator>();//객체 생성시 springValidators에 validator형으로 HashSet에 생성
    }

    public void setSpringValidators(Set<Validator> springValidators)
    {
        this.springValidators=springValidators;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {//유효성 검사 target = 주어진객체 유효성검사 실행후 error시 errors에 저장
        //Bean Validation 설정
        Set<ConstraintViolation<Object>> violations = beanValidator.validate(target);
        for(ConstraintViolation<Object> violation : violations) {
            //오류 발생 필드 저장
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage(); //오류 발생 메시지 저장
            //오류가 발생된 필드와 메시지를 Errors 객체에 저장
            errors.rejectValue(propertyPath, "", message);

        }
        for(Validator validator: springValidators) {//spring validation 오류저장
            validator.validate(target, errors);//발생된 오류 정보를 전달
        }
    }
}
