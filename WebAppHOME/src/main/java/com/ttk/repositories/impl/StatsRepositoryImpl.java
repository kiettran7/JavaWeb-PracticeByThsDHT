/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttk.repositories.impl;

import com.ttk.pojo.OrderDetail;
import com.ttk.pojo.Product;
import com.ttk.pojo.SaleOrder;
import com.ttk.repositories.StatsRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kitj3
 */
@Repository
@Transactional
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Object> statsRevenueByProduct() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootProduct = q.from(Product.class);
        Root rootOrderDetail = q.from(OrderDetail.class);

        q.multiselect(rootProduct.get("id"),
                rootProduct.get("name"),
                b.sum(b.prod(rootOrderDetail.get("quantity"), rootOrderDetail.get("unitPrice"))));

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootProduct.get("id"), rootOrderDetail.get("id")));

        q.where(predicates.toArray(Predicate[]::new));

        q.groupBy(rootProduct.get("id"));

        Query query = s.createQuery(q);
        return query.getResultList();

    }

//    @Override
//    public List<Object[]> statsRevenueByPeriod(int year, String period) {
//        Session s = this.factory.getObject().getCurrentSession();
//        CriteriaBuilder b = s.getCriteriaBuilder();
//        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
//
//        Root rootOrderDetail = q.from(OrderDetail.class);
//        Root rootSaleorder = q.from(SaleOrder.class);
//
//        q.multiselect(b.function("MONTH", Integer.class, rootSaleorder.get("createdDate"),
//                b.sum(b.prod(rootOrderDetail.get("unitPrice"), rootOrderDetail.get("quantity")))));
//
//        List<Predicate> predicates = new ArrayList<>();
//        predicates.add(b.equal(rootSaleorder.get("id"), rootOrderDetail.get("id")));
//        predicates.add(b.equal(b.function("YEAR", Integer.class, rootSaleorder.get("createdDate")), year));
//
//        q.where(predicates.toArray(Predicate[]::new));
//
//        q.groupBy(b.function("MONTH", Integer.class, rootSaleorder.get("createdDate")));
//
//        Query query = s.createQuery(q);
//        return query.getResultList();
//    }
}
