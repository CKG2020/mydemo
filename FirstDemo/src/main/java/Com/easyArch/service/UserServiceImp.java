package Com.easyArch.service;
import Com.easyArch.dao.FriendsDao;
import Com.easyArch.dao.FriendsDaoImp;
import Com.easyArch.dao.UserDAO;
import Com.easyArch.dao.UserDaoImp;
import Com.easyArch.entity.*;
import Com.easyArch.util.LoadTxt;
import Com.easyArch.util.Page;
import Com.easyArch.util.dateUtil;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImp implements UserService{

    UserDAO userDao = new UserDaoImp();
    FriendsDao friendsDao = new FriendsDaoImp();
    List<UserShow> userList;

    private int countMsg=0;
    private int countRequest=0;
    private int times=0;

    public void setTimes(int times) {
        this.times = times;
    }

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
    public List<UserShow> findAll() {
        userList=userDao.findAll();
        return userList;
    }

    @Override
    public List<UserShow> findUsersBySno(String sno) {
        userList=userDao.findUsersBySno(sno);
        return userList;
    }

    @Override
    public List<UserShow> findUsersByName(String name) {
        userList=userDao.findUsersByName(name);
        return userList;
    }

    @Override
    public List<UserShow> findUsersByAge(int age) {
        userList=userDao.findUsersByAge(age);
        return userList;
    }

    @Override
    public List<UserShow> findUsersByCollage(String collage) {
        userList=userDao.findUsersByCollage(collage);
        return userList;
    }

    @Override
    public List<UserShow> findUsersByClass(String sclass) {
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
    public List<User> showFriendsRequest(String sno) {
        return friendsDao.friendRequestList(sno);
    }

    @Override
    public List<UserBoard> findUserBoard(String sno) {
        return userDao.findUserBoard(sno);
    }

    @Override
    public void close() {
        userDao.close();
    }

    @Override
    public void getSession() {
        userDao.getSession();
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
    public int findFriendsCount(String sno) {
        return userDao.findFriendsCount(sno);
    }

    @Override
    public int countRequest(String sno) {
        return userDao.countRequest(sno);
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

    @Override
    public boolean addBoardMsg(BoardMsg msg) {
        msg.setDate_time(dateUtil.sendDate());
        return userDao.insertBoardMsg(msg);
    }

    @Override
    public int boardMsgCount(String sno) {
        if(times==0){
            countMsg=userDao.countBoardMsg(sno);
            System.out.println("sno:"+countMsg+"\ntimes"+times);
            times++;
        }else{
            int count1 = userDao.countBoardMsg(sno);
            System.out.println("count1"+count1+"\ntimes"+times);
            if(count1>countMsg){
                int countDiv = count1 - countMsg;
                System.out.println("div"+ countDiv);
                return countDiv;
            }
        }
        return 0;
    }

    @Override
    public int tipMsgCount(String sno) {
        int count1=userDao.countBoardMsg(sno);
        countMsg=userDao.historyMsgCount(sno);
        if(count1>countMsg){
            return count1-countMsg;
        }else{
            return 0;
        }
    }

    @Override
    public int tipRequestCount(String sno) {
        int count1=userDao.countRequest(sno);
        countRequest=userDao.historyRequestCount(sno);
        if(count1>countRequest){
            return count1-countRequest;
        }else{
            return 0;
        }
    }

    @Override
    public int historyMsgCount(String sno) {
        countMsg=userDao.countBoardMsg(sno);
        System.out.println(countMsg);
        Tips tips = new Tips();
        tips.setSno(sno);
        tips.setCount(countMsg);
        userDao.setHistoryMsgCount(tips);
        return 0;
    }

    @Override
    public int historyRequestCount(String sno) {
        countRequest=userDao.countRequest(sno);
        System.out.println(countRequest);
        Tips tips = new Tips();
        tips.setSno(sno);
        tips.setCount(countRequest);
        userDao.setHistoryRequestCount(tips);
        return 0;
    }

    @Override
    public boolean addRequest(String sno1, String sno2) {
        FriendRequest request = new FriendRequest();
        request.setSno1(sno1);
        request.setSno2(sno2);
        request.setAddStatus(false);
        userDao.addRequest(request);
        return true;
    }

    @Override
    public boolean acceptRequest(String sno1, String sno2) {
        FriendRequest request = new FriendRequest();
        request.setSno1(sno1);
        request.setSno2(sno2);
        request.setAddStatus(true);
        userDao.acceptRequest(request);
        return true;
    }

    @Override
    public boolean refuseRequest(String sno1, String sno2) {
        FriendRequest request = new FriendRequest();
        request.setSno1(sno1);
        request.setSno2(sno2);
        request.setAddStatus(false);
        userDao.refuseRequest(request);
        return true;
    }

    @Override
    public boolean delFriend(String sno1, String sno2) {
        FriendRequest del = new FriendRequest();
        del.setSno1(sno1);
        del.setSno2(sno2);
        friendsDao.delFriends(del);
        return true;
    }


}
