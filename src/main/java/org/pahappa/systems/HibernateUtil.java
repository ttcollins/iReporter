/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pahappa.systems;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author HP
 */
public class HibernateUtil {
 
    private static SessionFactory sessionFactoryObj = buildSessionFactoryObj();
 
    // Create The SessionFactory Object From Standard (Hibernate.cfg.xml) Configuration File
    @SuppressWarnings("deprecation")
    public static SessionFactory buildSessionFactoryObj() {
        try {
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (ExceptionInInitializerError exceptionObj) {
            exceptionObj.printStackTrace();
        }
        return sessionFactoryObj;
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactoryObj;
    }
}
