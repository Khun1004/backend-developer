package me.khunsan;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @GetMapping("/hi")
    public String hi() {
        return  "안녕하세요? 'http://localhost:8080/hi'에 대한 응답입니다";
    }

    @GetMapping("/test")
    public String test() {
        return  "안녕하세요? 'test' 요청에 대한 응답입니다";
    }

    @PostMapping("/test")
    public String postTest() {
        return  "안녕하세요? '/test POST' 요청에 대한 응답입니다";
    }

    @PutMapping("/test")
    public String putTest() {
        return  "안녕하세요? '/test PUT' 요청에 대한 응답입니다";
    }

    @DeleteMapping("/test")
    public String deleteTest() {
        return  "안녕하세요? '/test DELETE' 요청에 대한 응답입니다";
    }

}
