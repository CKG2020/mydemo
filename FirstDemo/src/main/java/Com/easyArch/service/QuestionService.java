package Com.easyArch.service;

import Com.easyArch.entity.Question;
import Com.easyArch.entity.ReturnAnswer;

import java.util.List;

public interface QuestionService  {

    List<Question> list = null;

    List showQuestion(int curr,int pageSzie);

    List getUserAnswers(List<Object> answers);
    //将用户答案整合一下
    
    void addScores(String sno,List<ReturnAnswer> list);

    String returnResult(String sno);

    boolean isFinished(String sno);









}
