package fr.epita.quiz;

import fr.epita.datamodel.Question;
import fr.epita.services.QuestionDAO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.websocket.server.PathParam;

@RestController
public class QuizController {

//    @Inject
//    QuestionDAO dao;

    @GetMapping(path="/questions/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Question> get(@PathParam("id") String id){
        System.out.println("hello from get!");
        return ResponseEntity.ok(new Question("test"));
    }


    @GetMapping(path="/questions")
    public void get(){
        System.out.println("hello from get!");
    }
    @PostMapping(path="/test")
    public void post(){
        System.out.println("hello from post!");
    }
}
