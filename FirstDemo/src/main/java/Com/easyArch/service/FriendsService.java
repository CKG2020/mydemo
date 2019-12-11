package Com.easyArch.service;

import Com.easyArch.entity.BoardMsg;

import java.util.List;

public interface FriendsService {

    int countFriends(String sno);//好友数量

    boolean addFriend(String sno1,String sno2);

    String tipsMessage();//提示信息

    String friendhandler();//处理好友申请

    List<String> showAdd();//展示好友申请列表

    boolean addBoardMsg(BoardMsg sno);



}
