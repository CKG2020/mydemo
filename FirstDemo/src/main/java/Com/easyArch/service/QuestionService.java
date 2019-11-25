package Com.easyArch.service;

import Com.easyArch.entity.Question;

import java.util.List;

public interface QuestionService  {

    List<Question> list = null;

    List<Question> showQuestion(int curr,int pageSzie);

    List<Question> changeQuestion();//分题

    List getUserAnswers(List<Object> answers);
    //将用户答案整合一下
    
    int addScores();

    void RecordUserAnswers(String ans);

    String RetrunResult(int scores);









}
