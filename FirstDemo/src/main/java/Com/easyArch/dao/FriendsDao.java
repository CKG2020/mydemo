package Com.easyArch.dao;

import Com.easyArch.util.mybatis;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public interface FriendsDao {

    int countFriends(String sno);
    List<Map<String,String>> friendList(String sno);


}
