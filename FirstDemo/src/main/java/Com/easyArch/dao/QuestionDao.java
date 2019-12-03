package Com.easyArch.dao;

import Com.easyArch.entity.Question;
import Com.easyArch.entity.UserBoard;

import java.util.List;

public interface QuestionDao {

    List questionList();

    int addQuestion(Question question);

    void setScores(String sno,int scores);

    int searchScore(String sno);

    boolean isFinished(String sno);

}
