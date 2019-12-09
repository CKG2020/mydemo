package Com.easyArch.dao;

import Com.easyArch.entity.User;
import Com.easyArch.util.mybatis;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class FriendsDaoImp implements FriendsDao{

    private UserDaoImp userDaoImp = new UserDaoImp();
    private SqlSession sqlSession ;
    {
        sqlSession= userDaoImp.sqlSession;
    }

    @Override
    public int countFriends(String sno) {
        return sqlSession.selectOne("UserBoard.countFriends",sno);
    }

    @Override
    public List<User> friendList(String sno) {
        return sqlSession.selectList("UserBoard.myFriends",sno);
    }

    @Override
    public User findUserBySno(String sno) {
        return sqlSession.selectOne("UserMapper.findUserBySno");
    }
}
