package Com.easyArch.dao;

import Com.easyArch.entity.Question;
import Com.easyArch.util.LoadTxt;
import Com.easyArch.util.mybatis;
import org.apache.ibatis.session.SqlSession;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.List;


public class QuestionDaoImp implements QuestionDao{

    SqlSession sqlSession ;
    {
        sqlSession= mybatis.Connection();
    }

    @Override
    public List<Question> questionList() {
        String str = sqlSession.selectOne("QuestionMapper.loadAnswers");
        System.out.println(LoadTxt.ReadQuestions(str));
        return LoadTxt.ReadQuestions(str);
    }

    @Override
    public int addQuestion(Question question) {
        return sqlSession.insert("QuestionMapper.addQuestion",question);
    }
}
