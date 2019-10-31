package Com.easyArch.service;

import java.util.List;
import java.util.Map;

public interface FriendsService {

    int countFriends(String sno);
    List<Map<String,String>> friendList(String sno);
    boolean addFriend(String sno1,String sno2);



}
