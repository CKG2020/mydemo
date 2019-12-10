package Com.easyArch.dao;


import Com.easyArch.entity.*;
import Com.easyArch.util.mybatis;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class UserDaoImp implements UserDAO{

    public static SqlSession sqlSession ;

    {
        sqlSession=mybatis.getSqlSession();
    }

    @Override
    public int addUser(User user, UserBoard userBoard) {
        int s=sqlSession.insert("UserMapper.addUser",user);
        sqlSession.insert("UserBoard.addUserBoard",userBoard);
        sqlSession.commit();
        return s;
    }

    @Override
    public boolean deleteUser(String sno) {
//
        sqlSession.delete("UserMapper.delpyq",sno);
        sqlSession.delete("UserMapper.delb",sno);
        sqlSession.delete("UserMapper.delUser", sno);
        sqlSession.commit();
        return true;

    }

    @Override
    public List<User> findAll() {
        return sqlSession.selectList("UserMapper.findall");
    }

    @Override
    public List<User> findUsersBySno(String Sno) {
        return sqlSession.selectList("UserMapper.findbysno",Sno);
    }

    @Override
    public List<User> findUsersByName(String name) {
        return sqlSession.selectList("UserMapper.findbyName",name);
    }

    @Override
    public List<User> findUsersByAge(int age) {
        return sqlSession.selectList("UserMapper.findbyAge",age);
    }

    @Override
    public List<User> findUsersByCollage(String collage) {
        return sqlSession.selectList("UserMapper.findbyCollage",collage);
    }

    @Override
    public List<User> findUsersByClass(String sclass) {
        return sqlSession.selectList("UserMapper.findbyClass",sclass);
    }

    @Override
    public String findUserNameBySno(String sno) {
        return sqlSession.selectOne("UserMapper.findUserNameBySno",sno);
    }


    @Override
    public User login(String Sno, String pwd) {
        return sqlSession.selectOne("UserMapper.selectUser",Sno);
    }

    @Override
    public Admin adminlogin(String username, String pwd) {
        return sqlSession.selectOne("UserMapper.selectAdmin",username);
    }
    @Override
    public boolean updateUser(User user) {
        sqlSession.update("UserMapper.updateUser",user);
        sqlSession.update("UserMapper.updateBirth",user);
        sqlSession.commit();
        return true;
    }
    @Override
    public int findSnoCount(String sno) {
        return sqlSession.selectOne("UserMapper.findSnoCount",sno);
    }

    @Override
    public int findallcount(){
        return sqlSession.selectOne("UserMapper.findallcount");
    }

    @Override
    public int findAllFinished(){
        return sqlSession.selectOne("UserBoard.allFinished");
    }

    @Override
    public int findAgeCount(int age){
        return sqlSession.selectOne("UserMapper.findAgeCount",age);
    }

    @Override
    public int findNameCount(String name) {
        return sqlSession.selectOne("UserMapper.findNameCount",name);
    }

    @Override
    public int findCollageCount(String collage) {
        return sqlSession.selectOne("UserMapper.findCollageCount",collage);
    }

    @Override
    public int findClassCount(String sclass) {
        return sqlSession.selectOne("UserMapper.findClassCount",sclass);
    }

    @Override
    public int findFriendsCount(String sno) {
        return sqlSession.selectOne("UserBoard.countFriends",sno);
    }

    @Override
    public UserBoard setScores(String sno,int scores) {
        UserBoard userBoard = new UserBoard();
        userBoard.setSno(sno);
        userBoard.setIsFinishedQuestion(true);
        userBoard.setScores(scores);
        sqlSession.update("updateFinishedQuestion",userBoard);
        sqlSession.commit();
        return userBoard;
    }
    @Override
    public int searchScore(String sno){
        return sqlSession.selectOne("UserBoard.searchScore",sno);
    }

    @Override
    public boolean isFinished(String sno) {
        if(sqlSession.selectOne("UserBoard.isFinished", sno)==null){
            return false;
        }
        return sqlSession.selectOne("UserBoard.isFinished", sno);
    }

    @Override
    public List<BoardMsg> showBoardMsg(String sno) {
        return sqlSession.selectList("UserBoard.showBoardMsg",sno);
    }

    @Override
    public User findUserBySno(String sno) {
        return sqlSession.selectOne("UserMapper.findUserBySno",sno);
    }
    //实现对数据库操作的接口中的方法

    @Override
    public List<Integer> findScore(){
        return sqlSession.selectList("UserBoard.findScore");
    }

    @Override
    public boolean insertBoardMsg(BoardMsg msg) {
        sqlSession.insert("UserBoard.insertBoardMsg",msg);
        sqlSession.commit();
        return true;
    }

    @Override
    public boolean addRequest(FriendRequest request) {
        sqlSession.insert("UserBoard.addFriendRequest",request);
        sqlSession.commit();
        return true;
    }

    @Override
    public boolean acceptRequest(FriendRequest request) {
        sqlSession.update("UserBoard.acceptAdd",request);
        sqlSession.insert("UserBoard.addFriend",request);
        sqlSession.commit();
        return true;
    }

    @Override
    public int countRequest(String sno) {
        return sqlSession.selectOne("UserBoard.countRequest",sno);
    }
}
