package Com.easyArch.dao;

import Com.easyArch.entity.BoardMsg;
import Com.easyArch.entity.FriendRequest;
import Com.easyArch.entity.User;
import Com.easyArch.util.mybatis;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public interface FriendsDao {

    int countFriends(String sno);
    List<User> friendList(String sno);
    List<User> friendRequestList(String sno);
    User findUserBySno(String sno);
    boolean delFriends(FriendRequest del);

    boolean insertBoardMsg(BoardMsg msg);



}
