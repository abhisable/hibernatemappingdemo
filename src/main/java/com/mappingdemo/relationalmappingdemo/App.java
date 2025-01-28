package com.mappingdemo.relationalmappingdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mappingdemo.relationalmappingdemo.entity.Customer;
import com.mappingdemo.relationalmappingdemo.entity.Order;
import com.mappingdemo.relationalmappingdemo.entity.ZomatoCustomer;


public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = new Configuration().
            configure("hibernate.cfg.xml").
//            addAnnotatedClass(Passport.class).
//            addAnnotatedClass(Student.class).
//            addAnnotatedClass(Customer.class).
//            addAnnotatedClass(Address.class).
            addAnnotatedClass(ZomatoCustomer.class).
            addAnnotatedClass(Order.class).
            buildSessionFactory();
        
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        ZomatoCustomer customer = session.get(ZomatoCustomer.class, 2);
        System.out.println(customer);
        
        session.remove(customer);
       
        session.getTransaction().commit();
        session.close();
        
        
    }
}
