package fr.epita.quiz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {

    @GetMapping(path="/test")
    public void test(){
        System.out.println("hello!");
    }
}
