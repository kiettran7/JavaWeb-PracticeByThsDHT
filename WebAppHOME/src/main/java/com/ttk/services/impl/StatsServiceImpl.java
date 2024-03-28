/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttk.services.impl;

import com.ttk.repositories.StatsRepository;
import com.ttk.services.StatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kitj3
 */
@Service
public class StatsServiceImpl implements StatsService {
    @Autowired
    private StatsRepository StatsRepo;

    @Override
    public List<Object> statsRevenueByProduct() {
        return this.StatsRepo.statsRevenueByProduct();
    }

//    @Override
//    public List<Object[]> statsRevenueByPeriod(int year, String period) {
//        return this.StatsRepo.statsRevenueByPeriod(year, period);
//    }
//    
    
}
