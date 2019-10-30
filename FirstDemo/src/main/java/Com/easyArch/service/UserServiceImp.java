package Com.easyArch.service;

import Com.easyArch.dao.UserDaoImp;
import Com.easyArch.entity.Admin;
import Com.easyArch.entity.User;
import Com.easyArch.util.Page;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImp implements UserService{

    UserDaoImp userDao = new UserDaoImp();
    List<User> userList;

    private static UserServiceImp userService= null;
    private User user;

    public static UserServiceImp getUserService() {
        if (userService == null){
            return new UserServiceImp();
        }
        return userService;
    }
    @Override
    public User addUser(String sno, String pwd) {
        user = new User();
        user.setSno(sno);
        user.setSpwd(pwd);
        if (userDao.addUser(user)!=0){
            return user;
        }
        return null;
    }

    @Override
    public boolean delUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public List<User> findAll() {
        userList=userDao.findAll();
        return userList;
    }

    @Override
    public List<User> findUsersBySno(String sno) {
        userList=userDao.findUsersBySno(sno);
        return userList;
    }

    @Override
    public List<User> findUsersByName(String name) {
        userList=userDao.findUsersByName(name);
        return userList;
    }

    @Override
    public List<User> findUsersByAge(int age) {
        userList=userDao.findUsersByAge(age);
        return userList;
    }

    @Override
    public List<User> findUsersByCollage(String collage) {
        userList=userDao.findUsersByCollage(collage);
        return userList;
    }

    @Override
    public List<User> findUsersByClass(String sclass) {
        userList=userDao.findUsersByClass(sclass);
        return userList;
    }

    @Override
    public User findUserBySno(String sno) {
        return userDao.findUserBySno(sno);
    }

    @Override
    public Object login(String username, String pwd) {
        //判断
        user=userDao.login(username, pwd);
        if (user!=null){
            if(pwd.equals(user.getSpwd())){
                return user;
            }else{
                return 1;
            }
        }else{
            return 0;
        }

    }

    @Override
    public Admin adminLogin(String username, String pwd) {
        Admin user=userDao.adminlogin(username, pwd);
        if(user!=null){
            if(pwd.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }


    @Override
    public int findallcount() {
        return userDao.findallcount();
    }

    @Override
    public List<User> findpage(int curr, int pageSize) {

        return Page.pageDiv(curr,pageSize,userList);
    }

    @Override
    public int findAgeCount(int age){
        return userDao.findAgeCount(age);
    }

    @Override
    public int findNameCount(String name) {
        return userDao.findNameCount(name);
    }

    @Override
    public int findCollageCount(String collage) {
        return userDao.findCollageCount(collage);
    }

    @Override
    public int findClassCount(String sclass) {
        return userDao.findClassCount(sclass);
    }

    @Override
    public int findSnoCount(String sno) {
        return userDao.findSnoCount(sno);
    }

}
