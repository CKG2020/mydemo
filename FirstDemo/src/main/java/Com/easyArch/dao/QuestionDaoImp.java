package Com.easyArch.dao;

import Com.easyArch.entity.Question;
import Com.easyArch.util.mybatis;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class QuestionDaoImp implements QuestionDao{

    SqlSession sqlSession ;
    {
        sqlSession= mybatis.Connection();
    }

    @Override
    public List<Question> QUESTION_LIST() {
        return sqlSession.selectList("QuestionMapper.showQuestion");
    }

    @Override
    public int addQuestion(Question question) {
        return sqlSession.insert("QuestionMapper.addQuestion",question);
    }
}
