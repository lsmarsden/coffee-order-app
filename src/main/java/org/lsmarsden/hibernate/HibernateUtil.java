package org.lsmarsden.hibernate;

import org.lsmarsden.order.model.Order;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.lsmarsden.user.model.User;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration hibernateConfig = new Configuration();
            hibernateConfig.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test")
                    .setProperty("hibernate.connection.username", "root")
                    .setProperty("hibernate.connection.password", "")
                    .setProperty("hibernate.hbm2ddl.auto", "update")
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(User.class);

            sessionFactory = hibernateConfig.buildSessionFactory();
        } catch (Exception e) {

        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
