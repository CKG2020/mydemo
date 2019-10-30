package Com.easyArch.service;

import Com.easyArch.dao.QuestionDao;
import Com.easyArch.dao.QuestionDaoImp;
import Com.easyArch.entity.Question;

import java.util.List;

public class QuestionServiceImp implements QuestionService{
    QuestionDao questionDao= new QuestionDaoImp();

    @Override
    public List<Question> showQuestion() {
        return questionDao.QUESTION_LIST();
    }

    @Override
    public int addQuestion(String title, String a1, String a2, String a3, String a4) {
        Question q = new Question();
        q.setTitle(title);
        q.setA1(a1);
        q.setA2(a2);
        q.setA3(a3);
        q.setA4(a4);
        return questionDao.addQuestion(q);
    }
}
