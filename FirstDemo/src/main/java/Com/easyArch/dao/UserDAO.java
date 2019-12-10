package Com.easyArch.dao;

import Com.easyArch.entity.*;

import java.util.List;

public interface UserDAO {
    //对数据库操作的接口
    int addUser(User user, UserBoard userBoard);//注册
    boolean deleteUser(String id);

    List<User> findAll();//管理员查所有成员 简单分页

    List<User> findUsersBySno(String sno);
    List<User> findUsersByName(String name);
    List<User> findUsersByAge(int age);
    List<User> findUsersByCollage(String collage);
    List<User> findUsersByClass(String sclass);

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

    boolean addRequest(FriendRequest request);
    boolean acceptRequest(FriendRequest request);
    int countRequest(String sno);

    User findUserBySno(String sno);
    List<Integer> findScore();

}
