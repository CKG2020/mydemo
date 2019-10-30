package Com.easyArch.dao;

import Com.easyArch.entity.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> QUESTION_LIST();
    int addQuestion(Question question);

}
