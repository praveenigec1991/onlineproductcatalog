package com.ecom.onlineproductcatalog.services;

import com.ecom.onlineproductcatalog.core.entity.Category;

import java.util.List;

public interface ICategoryService {
    Category createCategory(Category category);
    Category getCategory(Integer id);
    List<Category> getAllCategories();
}
