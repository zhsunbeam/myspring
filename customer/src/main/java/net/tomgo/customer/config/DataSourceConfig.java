package net.tomgo.customer.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = "classpath:jdbc.properties")
public class DataSourceConfig {

    @Autowired
    Environment env;

    @Value("${user_name}")
    private String userName;

    @Value("${password}")
    private String password;

    @Value("${url}")
    private String url;

    @Value("${driverClassName}")
    private String driverName;

    /*@Bean("dbcpDataSource")
    public String createDBCPDataSource() {
        System.out.println(env.getProperty("user_name"));
        System.out.println(env.getProperty("url"));
        return "test";
    }*/

    /*@Bean("dbcpDataSource")
    public DataSource createDBCPDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername(env.getProperty("user_name"));
        ds.setPassword(env.getProperty("password"));
        ds.setUrl(env.getProperty("url"));
        ds.setDriverClassName(env.getProperty("driverClassName"));
        ds.setInitialSize(20);
        return ds;
    }*/

    @Bean("dbcpDataSource")
    @Profile("dev")
    public DataSource createDBCPDataSource() {
        System.out.println("开发环境的数据源");
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername(this.userName);
        ds.setPassword(this.password);
        ds.setUrl(this.url);
        ds.setDriverClassName(this.driverName);
        ds.setInitialSize(20);
        return ds;
    }

    @Bean("druidDataSource")
    @Profile("prod")
    public DataSource createDruidDataSource() {
        System.out.println("生产环境的数据源");
        DruidDataSource ds = new DruidDataSource();
        ds.setUsername(this.userName);
        ds.setPassword(this.password);
        ds.setUrl(this.url);
        ds.setDriverClassName(this.driverName);
        ds.setInitialSize(5);
        ds.setMinIdle(5);
        ds.setMaxActive(20);
        ds.setMaxWait(50000);
        ds.setPoolPreparedStatements(true);
        ds.setMaxPoolPreparedStatementPerConnectionSize(20);

        return ds;
    }
}
