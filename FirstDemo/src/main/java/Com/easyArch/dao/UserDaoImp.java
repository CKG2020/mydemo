package Com.easyArch.dao;


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
        int s=sqlSession.insert("MyMapper.addUser",user);
        sqlSession.commit();
        return s;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return sqlSession.selectList("MyMapper.findall");
    }

    @Override
    public boolean addFriend(int id1, int id2) {
        return false;
    }

    @Override
    public List<User> findUsersBySno(String Sno) {
        return sqlSession.selectList("MyMapper.findbysno",Sno);
    }

    @Override
    public List<User> findUsersByName(String name) {
        return sqlSession.selectList("MyMapper.findbyName",name);
    }

    @Override
    public List<User> findUsersByAge(int age) {
        return sqlSession.selectList("MyMapper.findbyAge",age);
    }

    @Override
    public List<User> findUsersByCollage(String collage) {
        return sqlSession.selectList("MyMapper.findbyCollage",collage);
    }

    @Override
    public List<User> findUsersByClass(String sclass) {
        return sqlSession.selectList("MyMapper.findbyClass",sclass);
    }


    @Override
    public User login(String Sno, String pwd) {
        return sqlSession.selectOne("MyMapper.selectUser",Sno);
    }

    @Override
    public User adminlogin(String username, String pwd) {
        return sqlSession.selectOne("MyMapper.selectAdmin",username);
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public int findSnoCount(String sno) {
        return sqlSession.selectOne("MyMapper.findSnoCount",sno);
    }

    @Override
    public int findallcount(){
        return sqlSession.selectOne("MyMapper.findallcount");
    }

    @Override
    public int findAgeCount(int age){
        return sqlSession.selectOne("MyMapper.findAgeCount",age);
    }

    @Override
    public int findNameCount(String name) {
        return sqlSession.selectOne("MyMapper.findNameCount",name);
    }

    @Override
    public int findCollageCount(String collage) {
        return sqlSession.selectOne("MyMapper.findCollageCount",collage);
    }

    @Override
    public int findClassCount(String sclass) {
        return sqlSession.selectOne("MyMapper.findClassCount",sclass);
    }

    @Override
    public User findUserBySno(String sno) {
        return sqlSession.selectOne("MyMapper.selectSno",sno);
    }
    //实现对数据库操作的接口中的方法
}
