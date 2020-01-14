package com.ecom.onlineproductcatalog.das.impl;

import com.ecom.onlineproductcatalog.core.entity.Inventory;
import com.ecom.onlineproductcatalog.das.IInventoryDao;
import com.ecom.onlineproductcatalog.services.IInventoryService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

@Repository
public class InventoryDaoImpl implements IInventoryDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Inventory createInventory(Inventory inventory) {
        return (Inventory) sessionFactory.getCurrentSession().merge(inventory );
    }

    @Override
    public Inventory getInventory(Integer id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Inventory where id=:inid" );
       query.setParameter("inid", id);
        return (Inventory) ((org.hibernate.query.Query) query).uniqueResult();
    }

    @Override
    public List<Inventory> getAllInventories() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Inventory" );
        return query.getResultList();
    }
}
