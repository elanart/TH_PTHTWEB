/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tranlelan.repository.impl;

import com.tranlelan.hibernatedemo.HibernateUtils;
import com.tranlelan.pojo.Category;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class CategoryRepositoryImpl {
    public List<Category> getCategories() {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            Query q = s.createQuery("From Category");
            
            return q.getResultList();
        }
    }
}
