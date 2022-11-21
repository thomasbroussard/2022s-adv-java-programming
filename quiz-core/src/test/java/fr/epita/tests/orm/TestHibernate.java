package fr.epita.tests.orm;

import fr.epita.datamodel.Question;
import fr.epita.services.QuestionJPADAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import javax.sql.DataSource;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ORMTestContextConfiguration.class)
public class TestHibernate {

    @Inject
    DataSource ds;

    @Inject
    SessionFactory factory;



    @Test
    public void test(){
        Session session = factory.openSession();

        Question question = new Question("What is Jakarta?");

        session.saveOrUpdate(question);

//        Question question1 = new Question();
//        question1.setId(1);
//        question1.setTitle("newValue");
//        session.update(question1);

    }


}
