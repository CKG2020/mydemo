package Com.easyArch;

import Com.easyArch.util.mybatis;
import org.apache.ibatis.session.SqlSession;

public class test {


    public static void main(String[] args) {
        SqlSession sqlSession= mybatis.Connection();
        System.out.println(sqlSession.selectList("UserBoard.test","02240170128"));

    }
}
