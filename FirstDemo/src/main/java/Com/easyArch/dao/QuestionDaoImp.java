package Com.easyArch.dao;

import Com.easyArch.entity.Question;
import Com.easyArch.entity.UserBoard;
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
    @Override
    public int searchScore(String sno){
        return sqlSession.selectOne("UserBoard.searchScore",sno);
    }

    @Override
    public boolean isFinished(String sno) {
        if(sqlSession.selectOne("UserBoard.isFinished", sno)==null){
            return false;
        }
        return sqlSession.selectOne("UserBoard.isFinished", sno);
    }

    @Override
    public int addQuestion(Question question) {
        return sqlSession.insert("QuestionMapper.addQuestion",question);
    }

    @Override
    public void setScores(String sno,int scores) {
        UserBoard userBoard = new UserBoard();
        userBoard.setSno(sno);
        userBoard.setScores(scores);
        sqlSession.update("updateFinishedQuestion",userBoard);
        sqlSession.commit();
    }
}
