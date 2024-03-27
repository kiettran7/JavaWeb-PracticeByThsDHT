/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttk.services.impl;

import com.ttk.pojo.Category;
import com.ttk.repositories.CategoryRepository;
import com.ttk.services.CategoryServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class CategoryServiceImpl implements CategoryServices{
    @Autowired
    private CategoryRepository caterepo;

    @Override
    public List<Category> getCates() {
        return this.caterepo.getCates();
    }
    
    
}
