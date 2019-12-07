package Com.easyArch.dao;

import Com.easyArch.util.LoadTxt;
import Com.easyArch.util.mybatis;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class QuestionDaoImp implements QuestionDao{

    SqlSession sqlSession ;
    {
        sqlSession= mybatis.getSqlSession();
    }

    @Override
    public List questionList() {
        String str = sqlSession.selectOne("loadAnswers");
        System.out.println(LoadTxt.ReadQuestions(str));
        return LoadTxt.ReadQuestions(str);
    }

}
