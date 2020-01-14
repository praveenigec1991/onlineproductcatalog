package com.ecom.onlineproductcatalog.das.impl;

import com.ecom.onlineproductcatalog.core.entity.Category;
import com.ecom.onlineproductcatalog.core.entity.Product;
import com.ecom.onlineproductcatalog.das.ICategoryDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CategoryDaoImpl implements ICategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Category createCategory(Category category) {
        return (Category) sessionFactory.getCurrentSession().merge(category);
    }



    @Override
    public Category getCategory(Integer id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Category where id=:cid" );
        query.setParameter("cid", id);
        return (Category)query.uniqueResult();
    }

    @Override
    public List<Category> getAllCategories() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Category" );
        return query.getResultList();
    }
}
