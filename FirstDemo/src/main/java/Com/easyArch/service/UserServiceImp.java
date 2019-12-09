package Com.easyArch.service;
import Com.easyArch.dao.FriendsDao;
import Com.easyArch.dao.FriendsDaoImp;
import Com.easyArch.dao.UserDAO;
import Com.easyArch.dao.UserDaoImp;
import Com.easyArch.entity.*;
import Com.easyArch.util.LoadTxt;
import Com.easyArch.util.Page;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImp implements UserService{

    UserDAO userDao = new UserDaoImp();
    FriendsDao friendsDao = new FriendsDaoImp();
    List<User> userList;

    private static UserServiceImp userService= null;
    private User user;
    private UserBoard userBoard;

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
        userBoard = new UserBoard();
        userBoard.setSno(sno);
        if (userDao.addUser(user,userBoard)==2){
            return user;
        }
        return null;
    }

    @Override
    public boolean delUser(String sno) {
        return userDao.deleteUser(sno);
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
    public boolean updateUser(FormValidate form) {
        User user = new User();
        user.setSname(form.getName());
        user.setBirth(form.getDate());
        user.setCollage(form.getCollage());
        user.setGender(form.getGender());
        user.setSno(form.getSno());
        user.setSage(form.getAge());
        user.setMajor(form.getMajor());
        user.setSclass(form.getSclass());
        user.setScall(form.getCall());
        return userDao.updateUser(user);
    }


    @Override
    public int findallcount() {
        return userDao.findallcount();
    }

    @Override
    public List findpage(int curr, int pageSize) {

        return Page.pageDiv(curr,pageSize,userList);
    }

    @Override
    public List<User> showFriends(String sno) {
        return friendsDao.friendList(sno);
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

    @Override
    public UserBoard addScores(String sno,List<ReturnAnswer> list) {
        int scores = 0;
        for (ReturnAnswer returnAnswer : list) {
            scores += returnAnswer.getScore();
        }
        return userDao.setScores(sno,scores);
    }

    public double percent(int a,int b){
        return Math.floor(((double) a / (double) b)*100);
    }
    @Override
    public int findAllFinished(){
        return userDao.findAllFinished();
    }

    public AnalyzingData analyzingRes(){
        AnalyzingData data = new AnalyzingData();

        int finishedCount=findAllFinished();
        int allCount=findallcount();

        data.setAllCount(allCount);
        data.setFinishedCount(finishedCount);

        data.setPercent(percent(finishedCount,allCount));
        List<Integer> list = userDao.findScore();
        int countA=0;
        int countB=0;
        int countC=0;
        int countD=0;
        for (Integer integer : list) {
            if (integer >= 48) {
                countA++;
            } else if (integer >= 37) {
                countB++;
            } else if (integer >= 27) {
                countC++;
            } else {
                countD++;
            }
        }
        data.setCountA(countA);
        data.setCountB(countB);
        data.setCountC(countC);
        data.setCountD(countD);
        data.setPercentA(percent(countA,finishedCount));
        data.setPercentB(percent(countB,finishedCount));
        data.setPercentC(percent(countC,finishedCount));
        data.setPercentD(percent(countD,finishedCount));
        return data;
    }
    @Override
    public String returnResult(String sno) {
        int scores = userDao.searchScore(sno);
        String x;
        if(scores>=48){
            x="A";
        }else if(scores>=37){
            x="B";
        }else if(scores>=27){
            x="C";
        }else {
            x="D";
        }
        return LoadTxt.sendResult(x);
    }

    @Override
    public boolean isFinished(String sno) {
        return userDao.isFinished(sno);
    }

    @Override
    public List<BoardMsg> showBoardMsg(String sno) {
        return userDao.showBoardMsg(sno);
    }


}
