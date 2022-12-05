package fr.epita.quiz;

import fr.epita.quiz.web.data.services.QuizDataService;
import fr.epita.quiz.web.messages.QuestionDTO;
import fr.epita.quiz.web.messages.QuestionListDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URI;

@RestController
@RequestMapping(path = "/questions")
public class QuizController {



    @Inject
    QuizDataService service;

    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuestionDTO> get(@PathVariable("id") String id){

        try {
            QuestionDTO questionDTO = service.getQuestionById(Integer.parseInt(id));
            return ResponseEntity.ok(questionDTO);
        }catch (Exception e){
           return ResponseEntity.internalServerError().build();
        }


    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuestionListDTO> get(){
        QuestionListDTO all = this.service.getAll(0);
        return ResponseEntity.ok(all);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> post(@RequestBody QuestionDTO question){
        try {
            service.createQuestion(question);
            int id = question.getId();
            return ResponseEntity.created(new URI(String.valueOf(id))).build();
        }catch(Exception e){
            return ResponseEntity
                    .internalServerError()
                    .body("error while performing operation:" +e.getMessage());
        }
    }
}
