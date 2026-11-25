package me.khunsan.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExampleController {

    @GetMapping("/thymeleaf/example")
    public String thymeleaf(Model model) {
        Person person = new Person();
        person.setName("Haru");
        person.setAge(25);

        person.setHobbies(List.of("운동", "독서", "혼잣말"));
        model.addAttribute("student", person);

        return "example";
    }

    @GetMapping("thymeleaf/test")
    public String test(Model model) {
        model.addAttribute("name", "채하루");
        model.addAttribute("age", "26");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("해외 여행 가기");
        hobbies.add("외국어 공부");
        hobbies.add("웹, 앱 개발하기");
        model.addAttribute("hobbies", hobbies);
        return "test";
    }

    @GetMapping("thymeleaf/test2")
    public String test2(Model model) {
        Person person = new Person();
        person.setName("채하루");
        person.setAge(26);
        List<String> hobbies = new ArrayList<>();
        hobbies.add("해외 여행 가기");
        hobbies.add("외국어 공부");
        hobbies.add("웹, 앱 개발하기");
        person.setHobbies(hobbies);
        model.addAttribute("person", person);
        return "test2";
    }

}

@Getter
@Setter
class Person {
    private String name;
    private int age;
    private List<String> hobbies;
}

