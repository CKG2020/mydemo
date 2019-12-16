package Com.easyArch.dao;

import Com.easyArch.entity.BoardMsg;
import Com.easyArch.entity.FriendRequest;
import Com.easyArch.entity.User;
import Com.easyArch.util.mybatis;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public class FriendsDaoImp implements FriendsDao{

    private SqlSession sqlSession ;
    {
        sqlSession= UserDaoImp.sqlSession;
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
    public List<User> friendRequestList(String sno) {

        return sqlSession.selectList("UserBoard.friendsRequest",sno);
    }

    @Override
    public User findUserBySno(String sno) {
        return sqlSession.selectOne("UserMapper.findUserBySno");
    }

    @Override
    public boolean delFriends(FriendRequest del) {
        sqlSession.delete("UserBoard.delFriend1",del);
        sqlSession.delete("UserBoard.delFriend2",del);
        sqlSession.commit();
        return true;
    }

    @Override
    public boolean insertBoardMsg(BoardMsg msg) {
        sqlSession.insert("UserBoard.insertBoardMsg",msg);
        sqlSession.commit();
        return true;
    }


}
