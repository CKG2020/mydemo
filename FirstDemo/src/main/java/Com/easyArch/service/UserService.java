package Com.easyArch.service;

import Com.easyArch.entity.Admin;
import Com.easyArch.entity.FormValidate;
import Com.easyArch.entity.User;
import Com.easyArch.entity.AnalyzingData;

import java.util.List;

public interface UserService {

    //业务层 创建User实例

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


    int findAllFinished();
    double percent(int a,int b);
    AnalyzingData analyzingRes();

    List findpage(int start, int end);

}
