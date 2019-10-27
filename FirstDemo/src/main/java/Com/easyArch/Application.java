package Com.easyArch;

import Com.easyArch.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
@EnableCaching
public class Application {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class,args);
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
            // 第二个参数：指定传入sql的参数：这里是用户id
//            User user = sqlSession.selectOne("MyMapper.selectUser",1);
//            System.out.println(user);
//            User user1 = sqlSession.selectOne("MyMapper.selectUser", 1);
//            System.out.println(user1);
        } finally {
            sqlSession.close();
        }
    }
}
