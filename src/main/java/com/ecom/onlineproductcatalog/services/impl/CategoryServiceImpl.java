package com.ecom.onlineproductcatalog.services.impl;

import com.ecom.onlineproductcatalog.core.entity.Category;
import com.ecom.onlineproductcatalog.das.ICategoryDao;
import com.ecom.onlineproductcatalog.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryDao categoryDao ;

    @Override
    public Category createCategory(Category category) {
        category.setCreated(new Date());
        category.setUpdated(new Date());
        return categoryDao.createCategory(category);
    }

    @Override
    public Category getCategory(Integer id) {
        return categoryDao.getCategory(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }
}
