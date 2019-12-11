package Com.easyArch.service;

import Com.easyArch.entity.*;

import java.util.List;

public interface UserService {

    //业务层 创建User实例
    int times=0;
    void setTimes(int times);
    User addUser(String sno, String pwd);

    boolean delUser(String sno);
    List<User> findAll();
    List<User> findUsersBySno(String sno);
    List<User> findUsersByName(String name);
    List<User> findUsersByAge(int age);
    List<User> findUsersByCollage(String collage);
    List<User> findUsersByClass(String sclass);

    User findUserBySno(String sno);

    Object login(String username, String pwd);
    Admin adminLogin(String username, String pwd);
    boolean updateUser(FormValidate user);

    int findallcount();
    int findAgeCount(int age);
    int findNameCount(String name);
    int findCollageCount(String collage);
    int findClassCount(String sclass);
    int findSnoCount(String sno);
    int findFriendsCount(String sno);
    int countRequest(String sno);


    UserBoard addScores(String sno, List<ReturnAnswer> list);
    String returnResult(String sno);
    boolean isFinished(String sno);

    List<BoardMsg> showBoardMsg(String sno);
    boolean addBoardMsg(BoardMsg sno);
    int boardMsgCount(String sno);
    int tipMsgCount(String sno);
    int tipRequestCount(String sno);
    int historyMsgCount(String sno);
    int historyRequestCount(String sno);

    boolean addRequest(String sno1,String sno2);
    boolean acceptRequest(String sno1,String sno2);
    boolean refuseRequest(String sno1,String sno2);
    boolean delFriend(String sno1,String sno2);


    int findAllFinished();
    double percent(int a,int b);
    AnalyzingData analyzingRes();

    List findpage(int start, int end);

    List<User> showFriends(String sno);
    List<User> showFriendsRequest(String sno);

    void close();
    void getSession();

}
