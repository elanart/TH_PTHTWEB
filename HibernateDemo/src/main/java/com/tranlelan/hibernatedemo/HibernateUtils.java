/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tranlelan.hibernatedemo;

import com.tranlelan.pojo.Category;
import com.tranlelan.pojo.Comment;
import com.tranlelan.pojo.OrderDetail;
import com.tranlelan.pojo.ProdTag;
import com.tranlelan.pojo.Product;
import com.tranlelan.pojo.SaleOrder;
import com.tranlelan.pojo.Tag;
import com.tranlelan.pojo.User;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author admin
 */
public class HibernateUtils {
    private static final SessionFactory factory;
    static {
        Configuration configuration = new Configuration();
        Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL, "jdbc:mysql://localhost/saledb");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "Admin@123");
        props.put(Environment.SHOW_SQL, true);
        
        configuration.setProperties(props);
        
        configuration.addAnnotatedClass(Category.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(SaleOrder.class);
        configuration.addAnnotatedClass(OrderDetail.class);
        configuration.addAnnotatedClass(Tag.class);
        configuration.addAnnotatedClass(ProdTag.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Comment.class);
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        
        factory = configuration.buildSessionFactory(serviceRegistry);
    }

    /**
     * @return the factory
     */
    public static SessionFactory getFactory() {
        return factory;
    }
}
