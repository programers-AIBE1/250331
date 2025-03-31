package org.example.t250331.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@MapperScan("org.example.t250331.mapper")
public class MyBatisConfig {

    @Bean
    public DataSource dataSource() {
        Dotenv dotenv = Dotenv.load();
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(dotenv.get("MYSQL_DRIVER"));
        ds.setUrl(dotenv.get("MYSQL_URL"));
        ds.setUsername(dotenv.get("MYSQL_USER"));
        ds.setPassword(dotenv.get("MYSQL_PASSWORD"));
        return ds;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(ds);

        // XML 매퍼 위치 등록
        factory.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath:/mapper/*.xml")
        );

        return factory.getObject();
    }
}