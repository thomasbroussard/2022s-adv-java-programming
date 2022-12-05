package fr.epita.services;

import fr.epita.datamodel.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class QuestionJPADAO {
    private final SessionFactory factory;

    public QuestionJPADAO(SessionFactory factory) {
        this.factory = factory;
    }


    public void create(Question question) {
        Session session = this.factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(question);
        tx.commit();
    }


    public void update(Question question) {
        Session session = this.factory.openSession();
        session.update(question);
    }

    public void delete(Question question) {
        Session session = this.factory.openSession();
        session.delete(question);
    }

    public List<Question> search(Question question) {
        Session session = this.factory.openSession();
        Query<Question> from_question = session.createQuery("from Question q where q.title = :title", Question.class);
        from_question.setParameter("title", question.getTitle());
        return from_question.list();
    }


    public List<Question> getAll() {
        Session session = this.factory.openSession();
        Query<Question> from_question = session.createQuery("from Question q", Question.class);
        return from_question.list();
    }
}
