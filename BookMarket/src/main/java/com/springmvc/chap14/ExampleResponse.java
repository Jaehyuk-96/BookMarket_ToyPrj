package com.springmvc.chap14;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam04")
public class ExampleResponse {
    //ResponseEntity는 Http 요청에 대한 응답 데이터를 포함하는 클래스로, 상태코드(HttpStatus),
    // 헤더(HttpHeaders), 몸체(HttpBody)를 포함합니다.

    //@RestController는 별도의 뷰 페이지를 제공하지 않는 형태로 실행하기 때문에 결과 데이터가 예외적인 오류를
    // 발생할 수 있습니다. 이에 사용자가 직접 결과 데이터와 Http 상태코드를 제어 할수 있습니다.

    @GetMapping
    public ResponseEntity<Person> submit() {
        Person person = new Person();
        person.setName("HongGilDong");
        person.setAge(20);
        person.setEmail("hong@naver.com");
        System.out.println(person);
        return new ResponseEntity("person", HttpStatus.BAD_REQUEST);

    }


}
