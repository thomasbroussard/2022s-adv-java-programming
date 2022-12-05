package fr.epita.quiz.web.messages;

public class QuestionDTO {
    int id;
    String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public QuestionDTO(){

    }
    public QuestionDTO(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
