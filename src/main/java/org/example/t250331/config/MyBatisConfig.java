package org.example.t250331.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class MyBatisConfig {
    private static final SqlSessionFactory sqlSessionFactory;

    static {
        // dotenv 로드
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        // 환경변수
        Properties properties = new Properties();
        properties.setProperty("DB_DRIVER", dotenv.get("MYSQL_DRIVER"));
        properties.setProperty("DB_URL", dotenv.get("MYSQL_URL"));
        properties.setProperty("DB_USER", dotenv.get("MYSQL_USER"));
        properties.setProperty("DB_PASSWORD", dotenv.get("MYSQL_PASSWORD"));

        String resource = "mybatis-config.xml";


        try (InputStream inputStream = MyBatisConfig.class.getClassLoader().getResourceAsStream(resource)) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}