package com.hai.advanced.a1ex2_a2ex1_a3ex2.utils;


import com.hai.advanced.a1ex1.entity.Group;
import com.hai.advanced.a1ex2_a2ex1_a3ex2.entity.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static volatile HibernateUtils obj  = null;

    private SessionFactory sessionFactory;

    private HibernateUtils() {}
    /**
     * Singleton Pattern <a href="https://www.geeksforgeeks.org/singleton-design-pattern/">Double Checked Locking</a>
     */
    public static HibernateUtils getInstance()
    {
        if (obj == null)
        {
            // To make thread safe
            synchronized (HibernateUtils.class)
            {
                // check again as multiple threads
                // can reach above step
                if (obj==null)
                    obj = new HibernateUtils();
            }
        }
        return obj;
    }

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null || sessionFactory.isClosed()) {
            sessionFactory = new Configuration()
                    .configure("hibernate-ex2.cfg.xml")
                    .addAnnotatedClass(Account.class)
                    .addAnnotatedClass(Answer.class)
                    .addAnnotatedClass(CompanyGroup.class)
                    .addAnnotatedClass(QuestionCategory.class)
                    .addAnnotatedClass(Department.class)
                    .addAnnotatedClass(Exam.class)
                    .addAnnotatedClass(Group.class)
                    .addAnnotatedClass(Position.class)
                    .addAnnotatedClass(Question.class)
                    .addAnnotatedClass(QuestionType.class)
                    .addAnnotatedClass(PositionTypeConverter.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    public Session getSession() {
        return getSessionFactory().getCurrentSession();
    }

    public boolean closeFactory() {
        if (sessionFactory != null && sessionFactory.isOpen()) {
            try {
                sessionFactory.close();
                return true;
            } catch (HibernateException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return true;
        }
    }
}
