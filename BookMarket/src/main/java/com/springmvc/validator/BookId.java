package com.springmvc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = BookIdValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BookId {
    String message() default "{BookId.NewBook.bookId}";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
