package Com.easyArch.service;

import Com.easyArch.dao.QuestionDao;
import Com.easyArch.dao.QuestionDaoImp;
import Com.easyArch.dao.UserDAO;
import Com.easyArch.dao.UserDaoImp;
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


}
