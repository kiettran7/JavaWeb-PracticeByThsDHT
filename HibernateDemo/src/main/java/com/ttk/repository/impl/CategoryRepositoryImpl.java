/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttk.repository.impl;

import com.ttk.hibernatedemo.HibernateUtils;
import com.ttk.pojo.Category;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class CategoryRepositoryImpl {
    public List<Category> getCategories() {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            Query q = s.createNamedQuery("Category.findAll");
            return q.getResultList();
        }
    }
    
    public Category getCateById(int id) {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            return s.get(Category.class, id);
        }
    }
}
