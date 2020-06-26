package com.waibizi;
import com.waibizi.dao.UserDao;
import com.waibizi.service.UserService;
import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
/**
 * @Author 歪鼻子
 * @Date 2020/6/26 18:04
 * @Description:
 * @Version 1.0
 */
public class ApplicationContext {
    public static void main(String[] args) {
        /* 初始化数据源 */
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        /* 事务 */
        TransactionFactory transactionFactory =
                new JdbcTransactionFactory();
        /* 构建环境变量 */
        Environment environment =
                new Environment("development",transactionFactory,dataSource);
        Configuration configuration = new Configuration(environment);
        /* log4j 打印sql */
        configuration.setLogImpl(Log4jImpl.class);
        /* 将Dao缓存起来 */
        configuration.addMapper(UserDao.class);
        /* 初始化mybatis的工厂 */
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(configuration);
        /* 启动SqlSession */
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        UserService userService = new UserService();
        /* 由于不采用Spring提供的注入，因为自己导入 */
        userService.SetUserDao(userDao);
        userService.query();
        /* 关闭SqlSession,让一级缓存不生效 */
        sqlSession.close();
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
        userService.SetUserDao(userDao);
        userService.query();
    }
}
