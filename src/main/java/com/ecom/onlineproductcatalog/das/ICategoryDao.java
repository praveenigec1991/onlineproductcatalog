package com.ecom.onlineproductcatalog.das;

import com.ecom.onlineproductcatalog.core.entity.Category;
import com.ecom.onlineproductcatalog.core.entity.Product;

import java.util.List;

public interface ICategoryDao {

    Category createCategory(Category category);
    Category getCategory(Integer id);
    List<Category> getAllCategories();
}
