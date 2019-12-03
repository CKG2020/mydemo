package Com.easyArch.dao;

import Com.easyArch.entity.Admin;
import Com.easyArch.entity.User;
import Com.easyArch.entity.UserBoard;

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
    int findAgeCount(int age);
    int findNameCount(String name);
    int findCollageCount(String collage);
    int findClassCount(String sclass);

    User findUserBySno(String sno);


//    List<User> findpage(int start,int end);

}
