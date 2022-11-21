package fr.epita.tests.orm;

import fr.epita.datamodel.Question;
import fr.epita.services.QuestionJPADAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ORMTestContextConfiguration.class)
public class TestJPADAO {

    @Inject
    QuestionJPADAO jpadao;

    @Test
    public void testJPADAO(){
        jpadao.create(new Question("test"));
        jpadao.create(new Question("test2"));
    }

}
