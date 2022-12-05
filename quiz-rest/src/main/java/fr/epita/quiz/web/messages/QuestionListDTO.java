package fr.epita.quiz.web.messages;

import java.util.List;

public class QuestionListDTO {

    int numberOfResults;
    int currentPage;

    public int getNumberOfResults() {
        return numberOfResults;
    }

    public void setNumberOfResults(int numberOfResults) {
        this.numberOfResults = numberOfResults;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<QuestionDTO> getDtoList() {
        return dtoList;
    }

    public void setDtoList(List<QuestionDTO> dtoList) {
        this.dtoList = dtoList;
    }

    List<QuestionDTO> dtoList;

}
