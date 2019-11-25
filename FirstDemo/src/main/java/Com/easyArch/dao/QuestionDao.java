package Com.easyArch.dao;

import Com.easyArch.entity.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> questionList();
    int addQuestion(Question question);

}
