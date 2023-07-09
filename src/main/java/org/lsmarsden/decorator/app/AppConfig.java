package org.lsmarsden.decorator.app;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
// some methods have been removed from flyway 9.x that spring tries to call in auto configuration
@EnableAutoConfiguration(exclude = FlywayAutoConfiguration.class)
@EnableJpaRepositories("org.lsmarsden")
@ComponentScan("org.lsmarsden")
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        emf.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "update");
        emf.setPackagesToScan("org/lsmarsden/order", "org/lsmarsden/user");
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(hibernateJpaVendorAdapter);

        return emf;
    }
}
