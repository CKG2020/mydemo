package Com.easyArch;

import Com.easyArch.entity.Question;
import Com.easyArch.util.LoadTxt;
import Com.easyArch.util.mybatis;
import org.apache.ibatis.session.SqlSession;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.get(0));


//        SqlSession sqlSession= mybatis.Connection();
//        String str =sqlSession.selectOne("QuestionMapper.loadAnswers");
//
//        List<Question> list = LoadTxt.ReadQuestions(str);
//
//        System.out.println(list);



    }
}
