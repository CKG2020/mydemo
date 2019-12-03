package Com.easyArch.dao;


import Com.easyArch.entity.Admin;
import Com.easyArch.entity.User;
import Com.easyArch.entity.UserBoard;
import Com.easyArch.util.mybatis;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class UserDaoImp implements UserDAO{

    SqlSession sqlSession ;

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
    public User findUserBySno(String sno) {
        return sqlSession.selectOne("UserMapper.selectUser",sno);
    }
    //实现对数据库操作的接口中的方法

    public int findAllFinished(){
        return sqlSession.selectOne("UserBoard.allFinished");
    }

    public List<Integer> findScore(){
        return sqlSession.selectList("UserBoard.findScore");
    }
}
