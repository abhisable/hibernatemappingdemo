package com.mappingdemo.relationalmappingdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mappingdemo.relationalmappingdemo.entity.Actor;
import com.mappingdemo.relationalmappingdemo.entity.Movie;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = new Configuration().
            configure("hibernate.cfg.xml").
            addAnnotatedClass(Actor.class). 
            addAnnotatedClass(Movie.class).
            buildSessionFactory();
        
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        Actor actor=new Actor();
//        actor.setActorName("Dharmedra");
//        
//        Movie sholay=new Movie();
//        sholay.setMovieName("Sholay");
//        
//        Movie yml=new Movie();
//        yml.setMovieName("yamla pagla");
//        
//        actor.addMovie(sholay);
//        actor.addMovie(yml);
//       
//        session.persist(actor);
//       
        
        Actor actor = session.get(Actor.class, 3);
        System.out.println(actor);
        
        session.remove(actor);
        
        session.getTransaction().commit();
        session.close();
        
        
    }
}
