package Com.easyArch;

import Com.easyArch.entity.BoardMsg;


import java.text.SimpleDateFormat;
import java.util.*;

public class test {

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        System.out.println(list.get(0));
//        SqlSession sqlSession= mybatis.Connection();
//        String str =sqlSession.selectOne("QuestionMapper.loadAnswers");
//
//        List<Question> list = LoadTxt.ReadQuestions(str);
//
//        System.out.println(list);

//        QuestionDao questionDao = new QuestionDaoImp();
//        System.out.println(questionDao.isFinished("2240170128"));
//        System.out.println(questionDao.searchScore("2240170128"));
//        try {


//        System.out.println(LoadTxt.ReadQuestions("classpath:Questions/Research_2"));

//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        UserServiceImp user = new UserServiceImp();
//        UserDaoImp userDaoImp = new UserDaoImp();
//        System.out.println(user.analyzingRes());
//        System.out.println(user.percent(3,4));

        List<BoardMsg> list = new ArrayList<>();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time=df.format(System.currentTimeMillis());
        System.out.println(time);
        BoardMsg msg = new BoardMsg();
        msg.setFromName("");
        msg.setDate(time);
        msg.setText("");
        list.add(msg);
        String li = list.toString();
        System.out.println(li);
        System.out.println(li.length());

    }
}
