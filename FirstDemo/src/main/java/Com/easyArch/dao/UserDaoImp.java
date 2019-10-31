package Com.easyArch.dao;


import Com.easyArch.entity.Admin;
import Com.easyArch.entity.User;
import Com.easyArch.util.mybatis;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class UserDaoImp implements UserDAO{

    SqlSession sqlSession ;

    {
        sqlSession=mybatis.Connection();
    }

    @Override
    public int addUser(User user) {
        int s=sqlSession.insert("UserMapper.addUser",user);
        sqlSession.commit();
        return s;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return sqlSession.selectList("UserMapper.findall");
    }

    @Override
    public boolean addFriend(String sno1, String sno2) {
        return false;
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
    public User login(String Sno, String pwd) {
        return sqlSession.selectOne("UserMapper.selectUser",Sno);
    }

    @Override
    public Admin adminlogin(String username, String pwd) {
        return sqlSession.selectOne("UserMapper.selectAdmin",username);
    }

    @Override
    public boolean updateUser(User user) {
        return false;
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
        return sqlSession.selectOne("UserMapper.selectSno",sno);
    }
    //实现对数据库操作的接口中的方法
}
