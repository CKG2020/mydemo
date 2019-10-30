package Com.easyArch.service;

import Com.easyArch.entity.Question;

import java.util.List;

public interface QuestionService {

    List<Question> showQuestion();

    int addQuestion(String title,String a1,String a2,String a3,String a4);

}
