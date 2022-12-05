package fr.epita.quiz.web.data.services;

import fr.epita.datamodel.Question;
import fr.epita.quiz.web.messages.QuestionDTO;
import fr.epita.services.QuestionJPADAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class QuizDataService {

    private final QuestionJPADAO dao;

    private final SessionFactory sf;

    public QuizDataService(QuestionJPADAO dao, SessionFactory sf) {
        this.dao = dao;
        this.sf = sf;
    }

    public void createQuestion(QuestionDTO questionDTO){
        Question question = new Question(questionDTO.getTitle());
        dao.create(question);
        questionDTO.setId(question.getId());
    }

    public QuestionDTO getQuestionById(int id){
        Session session = this.sf.openSession();
        Question question = session.get(Question.class, id);
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setTitle(question.getTitle());
        return questionDTO;
    }

}
