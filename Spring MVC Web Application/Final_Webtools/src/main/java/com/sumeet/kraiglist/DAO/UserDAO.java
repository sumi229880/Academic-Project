package com.sumeet.kraiglist.DAO;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.sumeet.kraiglist.exception.AdException;
import com.sumeet.kraiglist.pojo.User;

@Component
public class UserDAO extends DAO {
  
    
    public User loginValidation(String username, String password)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where username = :USERNAME and password = :PASSWORD");
            q.setParameter("USERNAME", username);
            q.setParameter("PASSWORD", password);
            User user = (User) q.uniqueResult();
          //  System.out.println("from user dao" + user.getFirstName());
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }

    public User get(String username)
            throws AdException {
        try {
            begin();
            Criteria cr = getSession().createCriteria(User.class);
            cr.add(Restrictions.ilike("username", username));
            User user = (User) cr.uniqueResult();
           
//            Query q = getSession().createQuery("from User where username = :USERNAME");
//            q.setString("USERNAME", username);
//            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }

    public User getmail(String username)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where email = :USERNAME");
            q.setString("USERNAME", username);
            User user = (User) q.uniqueResult();
            System.out.println("maillllll"+user);
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }
    
    public User gethusky(String username)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where huskyId = :USERNAME");
            q.setString("USERNAME", username);
            User user = (User) q.uniqueResult();
            System.out.println("userrrrrrrr"+user);
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }
    public User create(String firstName, String lastName, String huskyId, String email, String phone, String username,
			String password)
            throws AdException {
        try {
            begin();
            User user = new User(firstName,lastName,huskyId,email,phone,username,password);
            getSession().save(user);
            
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + user name, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

    public void delete(User user)
            throws AdException {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + user.getUsername(), e);
        }
    }
}