package com.dam.arturoexameninterfaces.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DBConnection {

    private static DBConnection connection;
    private SessionFactory sessionFactory;


    private DBConnection(){
        try {
            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
            this.sessionFactory = new MetadataSources(ssr).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Error al crear la SessionFactory");
            e.printStackTrace();
        }
    }

    public static DBConnection getInstance(){
        if(connection == null){
            connection = new DBConnection();
        }
        return connection;
    }

    public SessionFactory getSessionFactory(){
        return this.sessionFactory;
    }

    public Session getSession(){
        if(this.sessionFactory != null) {
            return this.sessionFactory.openSession();
        }
        System.out.println("La session factory no esta inicializada");
        return null;
    }
}
