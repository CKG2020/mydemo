package Com.easyArch.service;

import Com.easyArch.dao.QuestionDao;
import Com.easyArch.dao.QuestionDaoImp;
import Com.easyArch.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {

    QuestionDao questionDao = new QuestionDaoImp();

    @Override
    public List<Question> showQuestion(int curr,int pageSize) {
        return questionDao.questionList();
    }

    @Override
    public List<Question> changeQuestion() {
        return null;
    }

    @Override
    public List getUserAnswers(List<Object> answers) {
        return null;
    }


    @Override
    public int addScores() {
        return 0;
    }

    @Override
    public void RecordUserAnswers(String ans) {

    }

    @Override
    public String RetrunResult(int scores) {
        return null;
    }
}
