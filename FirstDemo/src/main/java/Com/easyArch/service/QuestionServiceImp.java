package Com.easyArch.service;

import Com.easyArch.dao.QuestionDao;
import Com.easyArch.dao.QuestionDaoImp;
import Com.easyArch.entity.Question;
import Com.easyArch.entity.ReturnAnswer;
import Com.easyArch.entity.UserBoard;
import Com.easyArch.util.LoadTxt;
import Com.easyArch.util.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {

    static QuestionDao questionDao = new QuestionDaoImp();
    static List list =questionDao.questionList();


    @Override
    public List showQuestion(int curr,int pageSize) {
        return Page.pageDiv(curr,pageSize,list);
    }

    @Override
    public List getUserAnswers(List<Object> answers) {
        return null;
    }


    @Override
    public void addScores(String sno,List<ReturnAnswer> list) {
        int scores = 0;
        for (ReturnAnswer returnAnswer : list) {
            scores += returnAnswer.getScore();
        }
        questionDao.setScores(sno,scores);
    }

    @Override
    public String returnResult(String sno) {
        int scores = questionDao.searchScore(sno);
        String x;
        if(scores>=48){
            x="A";
        }else if(scores>=37){
            x="B";
        }else if(scores>=27){
            x="C";
        }else {
            x="D";
        }
        return LoadTxt.sendResult(x);
    }

    @Override
    public boolean isFinished(String sno) {
        return questionDao.isFinished(sno);
    }


}
