package Com.easyArch.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class mybatis {

    private static String resource = "mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession sqlSession;

    public static SqlSession Connection() {

        // 读取配置文件
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 构建sqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession();

        return sqlSession;
    }

}
