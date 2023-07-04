package hibernate;

import order.model.Order;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration hibernateConfig = new Configuration();
            hibernateConfig.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            hibernateConfig.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            hibernateConfig.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
            hibernateConfig.setProperty("hibernate.connection.username", "root");
            hibernateConfig.setProperty("hibernate.connection.password", "");
            hibernateConfig.addAnnotatedClass(Order.class);

            sessionFactory = hibernateConfig.buildSessionFactory();
        } catch (Exception e) {

        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
