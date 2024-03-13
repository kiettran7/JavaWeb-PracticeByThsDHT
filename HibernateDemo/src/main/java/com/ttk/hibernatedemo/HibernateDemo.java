/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.ttk.hibernatedemo;

import com.ttk.pojo.Category;
import com.ttk.pojo.Product;
import com.ttk.repository.impl.CategoryRepositoryImpl;
import com.ttk.repository.impl.ProductRepositoryImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
        CategoryRepositoryImpl s = new CategoryRepositoryImpl();
        s.getCategories().forEach(o -> System.out.println(o.getName()));
        
        
            ProductRepositoryImpl sur = new ProductRepositoryImpl();
            
            Product p = new Product();
            p.setName("Iphone moi ve ne may fen");
            p.setPrice(13500000l);
            p.setCategoryId(s.getCateById(2));
            sur.addOrUpdate(p);
            
//            Map<String, String> params = new HashMap<>();
//            params.put("fromPrice", "18000000");
//            params.put("toPrice", "29000000");
//            params.put("kw", "iphone");
            
//            s.getProducts(params).forEach(p -> System.out.printf("%d - %s - %.1f - %s\n",
//                    p.getId(), p.getName(), p.getPrice(), p.getCategory().getName()));
//            Query q = s.createQuery("From Category");
//            List<Category> cates = q.getResultList();
//            
//            cates.forEach(c -> System.out.println(c.getName()));

    }
}
