package Com.easyArch.dao;

import Com.easyArch.entity.*;

import java.util.List;

public interface UserDAO {
    //对数据库操作的接口
    int addUser(User user, UserBoard userBoard);//注册
    boolean deleteUser(String id);

    List<UserShow> findAll();//管理员查所有成员 简单分页

    List<UserShow> findUsersBySno(String sno);
    List<UserShow> findUsersByName(String name);
    List<UserShow> findUsersByAge(int age);
    List<UserShow> findUsersByCollage(String collage);
    List<UserShow> findUsersByClass(String sclass);

    String findUserNameBySno(String sno);

    User login(String username, String pwd);
    Admin adminlogin(String username, String pwd);
    boolean updateUser(User user);

    int findSnoCount(String sno);

    int findallcount();
    int findAllFinished();
    int findAgeCount(int age);
    int findNameCount(String name);
    int findCollageCount(String collage);
    int findClassCount(String sclass);
    int findFriendsCount(String sno);

    UserBoard setScores(String sno,int scores);
    int searchScore(String sno);
    boolean isFinished(String sno);

    List<BoardMsg> showBoardMsg(String sno);
    boolean insertBoardMsg(BoardMsg msg);

    int countBoardMsg(String sno);
    int countRequest(String sno);

    int historyMsgCount(String sno);
    int historyRequestCount(String sno);
    int setHistoryMsgCount(Tips tips);
    int setHistoryRequestCount(Tips tips);

    boolean addRequest(FriendRequest request);
    boolean acceptRequest(FriendRequest request);
    boolean refuseRequest(FriendRequest request);
    void close();
    void getSession();

    List<UserBoard> findUserBoard(String sno);
    User findUserBySno(String sno);
    List<Integer> findScore();

}
