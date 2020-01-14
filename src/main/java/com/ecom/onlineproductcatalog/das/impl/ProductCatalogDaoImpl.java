package com.ecom.onlineproductcatalog.das.impl;

import com.ecom.onlineproductcatalog.core.entity.Product;
import com.ecom.onlineproductcatalog.das.IProductCatalogDao;
import com.ecom.onlineproductcatalog.services.IProductCatalogService;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class ProductCatalogDaoImpl implements IProductCatalogDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Product createProduct(Product product) {
        return (Product) sessionFactory.getCurrentSession().merge(product );
    }

    @Override
    public Product getProductBySku(String sku) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Product where sku =:sku");
        query.setParameter("sku", sku);
        return (Product) query.uniqueResult();
    }

    @Override
    public List<Product> getAllProductsByBrand(String brand) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Product where brand =:brand");
        query.setParameter("brand", brand);
        return query.getResultList();
    }

    @Override
    public List<Product> getAllProductsByPrice(Double min, Double max) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Product where price between :min and :max");
        query.setParameter("min", min);
        query.setParameter("max", max);
        return query.getResultList();
    }

    @Override
    public List<Product> getAllProductsByColor(String color) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Product where color =:color");
        query.setParameter("color", color);
        return query.getResultList();
    }

    @Override
    public List<Product> getAllProductsBySize(String size) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Product where size =:size");
        query.setParameter("size", size);
        return query.getResultList();
    }
}
