package com.sumeet.kraiglist.DAO;

import com.sumeet.kraiglist.pojo.User;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
//import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.sumeet.kraiglist.exception.AdException;
import com.sumeet.kraiglist.pojo.Advertisements;

@Component
public class AdvertisementDAO extends DAO {
	public Advertisements create(String category, String title, double price, String descripition, String yearOld, String photos, User user)
            throws AdException {
        try {
            begin();
            if (category.equalsIgnoreCase("Freebie")){
            	price = 0.0;       	
            }
          //   System.out.println("iam here in the list method"+category + title+ price + descripition + yearOld + photos + user + user.getEmail());
            Advertisements advertisements = new Advertisements(category, title, price, descripition, yearOld,photos,user,user.getEmail());
            getSession().save(advertisements);
            commit();
            return advertisements;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating advertisement: " + e.getMessage());
        }
    }
	
    @SuppressWarnings("unchecked")
	public List<Advertisements> list(String differentiator) throws AdException {
        try {
            this.begin();
            Query q = getSession().createQuery("from Advertisements where category = :differentiator");
            q.setString("differentiator", differentiator);
            List<Advertisements> list = q.list();
            this.commit();
            return list;
        }
        catch (HibernateException e) {
            this.rollback();
            throw new AdException("Could not list the advertisements", (Throwable)e);
        }
    }
    
    @SuppressWarnings("unchecked")
	public List<Advertisements> userList(Object user) throws AdException {
        try {
            this.begin();
          //  System.out.println("iam here in the list method");
            Query q = getSession().createQuery("from Advertisements where user = :id");
            q.setLong("id",((Long)user));
            List<Advertisements> userList = q.list();
            this.commit();
            return userList;
        }
        catch (HibernateException e) {
            this.rollback();
            throw new AdException("Could not list the individual User advertisements", (Throwable)e);
        }
    }
    
	public Advertisements update(Long advertId) throws AdException {
        try {
            this.begin();
          //  System.out.println("iam here in the list method");
            Query q = getSession().createQuery("from Advertisements where advertId = :id");
            q.setLong("id",advertId);
            Advertisements advertisements = (Advertisements) q.uniqueResult();
            this.commit();
            return advertisements;
        }
        catch (HibernateException e) {
            this.rollback();
            throw new AdException("Could not select the individual User advertisements", (Throwable)e);
        }
    }

    public void delete(Long advertId)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("delete from Advertisements where advertId= :advertid");
            q.setLong("advertid",advertId);
            int result = q.executeUpdate();
            System.out.println("Number of rows that got deleted:" + result);
            this.commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete advertisement", e);
        }
    }
    
    public void aftSelectUpdate(Long advertId, String titl, double prce, String desc)
            throws AdException {
        try {
            begin();
            System.out.println("Numberupdated:" + advertId);
            Query q = getSession().createQuery("update Advertisements set title = :titl, price = :prce, descripition = :desc where advertId= :advertid");
            q.setLong("advertid",advertId);
            q.setString("titl",titl);
            q.setDouble("prce",prce);
            q.setString("desc",desc);
            System.out.println("Numberupdated:2");
            int result = q.executeUpdate();
            System.out.println("Number of rows that got updated:" + result);
            this.commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not update advertisement", e);
        }
    }
}
