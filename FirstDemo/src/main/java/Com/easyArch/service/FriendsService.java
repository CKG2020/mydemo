package Com.easyArch.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public interface FriendsService {

    Queue<String> friendsMes = new LinkedList<>();
    //好友消息队列
    Queue<Boolean> friendsAdd = new LinkedList<>();
    //好友申请队列

    int countFriends(String sno);//好友数量

    List<Map<String,String>> friendList(String sno);//展示好友列表

    boolean addFriend(String sno1,String sno2);

    String tipsMessage();//提示信息

    String friendhandler();//处理好友申请

    List<String> showAdd();//展示好友申请列表

}
