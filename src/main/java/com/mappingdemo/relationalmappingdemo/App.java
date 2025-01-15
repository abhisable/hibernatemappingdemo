package com.mappingdemo.relationalmappingdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mappingdemo.relationalmappingdemo.entity.Address;
import com.mappingdemo.relationalmappingdemo.entity.Customer;
import com.mappingdemo.relationalmappingdemo.entity.Passport;
import com.mappingdemo.relationalmappingdemo.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = new Configuration().
            configure("hibernate.cfg.xml").
            addAnnotatedClass(Passport.class).
            addAnnotatedClass(Student.class).
            addAnnotatedClass(Customer.class).
            addAnnotatedClass(Address.class).
            buildSessionFactory();
        
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        Student student=session.get(Student.class, 1);
//        System.out.println(student);
//        
//        Passport passport=session.get(Passport.class, 1);
//        System.out.println(passport);
       
//        Customer customer = session.get(Customer.class, 1);
//        System.out.println(customer);
        
        //customer.getAddress().setAddress("changing address to check automatic dirty check");
        
        Address address=session.get(Address.class, 2);
        address.getCustomer().setAddress(null);
        session.remove(address);
        
        session.getTransaction().commit();
        session.close();
        
        
    }
}
