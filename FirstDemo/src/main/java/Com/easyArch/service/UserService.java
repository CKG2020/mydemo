package Com.easyArch.service;

import Com.easyArch.entity.User;

import java.util.List;

public interface UserService {

    //业务层 创建User实例

    User addUser(String sno, String pwd);

    boolean delUser(int id);
    List<User> findAll();
    List<User> findUsersBySno(String sno);
    List<User> findUsersByName(String name);
    List<User> findUsersByAge(int age);
    List<User> findUsersByCollage(String collage);
    List<User> findUsersByClass(String sclass);

    User findUserBySno(String sno);

    Object login(String username, String pwd);
    User adminLogin(String username, String pwd);
    boolean updateUser(User user);

    int findallcount();
    int findAgeCount(int age);
    int findNameCount(String name);
    int findCollageCount(String collage);
    int findClassCount(String sclass);
    int findSnoCount(String sno);


    List<User> findpage(int start,int end);

}
