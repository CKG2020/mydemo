package Com.easyArch.dao;

import Com.easyArch.util.mybatis;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class FriendsDaoImp implements FriendsDao{

    SqlSession sqlSession ;
    {
        sqlSession= mybatis.Connection();
    }

    @Override
    public int countFriends(String sno) {
        return sqlSession.selectOne("UserBoard.countFriends",sno);
    }

    @Override
    public List<Map<String, String>> friendList(String sno) {
        return sqlSession.selectList("UserBoard.myFriends",sno);
    }
}
