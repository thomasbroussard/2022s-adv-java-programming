package fr.epita.quiz;

import fr.epita.datamodel.Question;
import fr.epita.quiz.web.data.services.QuizDataService;
import fr.epita.quiz.web.messages.QuestionDTO;
import fr.epita.services.QuestionDAO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
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


    @GetMapping(path="/")
    public void get(){
        System.out.println("hello from get!");
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> post(QuestionDTO question){
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
