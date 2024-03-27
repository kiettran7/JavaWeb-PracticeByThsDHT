/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttk.services.impl;

import com.ttk.pojo.Product;
import com.ttk.repositories.ProductRepository;
import com.ttk.services.ProductServices;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ProductServiceImpl implements ProductServices {
    @Autowired
    private ProductRepository prodrepo;

    @Override
    public List<Product> getProds(Map<String, String> params) {
        return this.prodrepo.getProds(params);
    }
}
