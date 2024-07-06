/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tranlelan.repository.impl;

import com.tranlelan.hibernatedemo.HibernateUtils;
import com.tranlelan.pojo.Cart;
import com.tranlelan.pojo.OrderDetail;
import com.tranlelan.pojo.SaleOrder;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ReceiptRepositoryImpl {

    private static final UserRepositoryImpl u = new UserRepositoryImpl();
    private static final ProductRepositoryImpl pr = new ProductRepositoryImpl();

    public void addReceipt(List<Cart> carts) {
        try ( Session s = HibernateUtils.getFactory().openSession()) {
            if (carts != null) {
                SaleOrder order = new SaleOrder();
                order.setUserId(u.getuserByusername("dhthanh"));
                order.setCreatedDate(new Date());
                s.save(order);
                
                for (var c: carts) {
                    OrderDetail d = new OrderDetail();
                    d.setUnitPrice(c.getUnitPrice());
                    d.setQuantity(c.getQuantity());
                    d.setProductId(pr.getProductById(c.getId()));
                    d.setOrderId(order);
                    
                    s.save(d);
                }
            }
        }
    }
}
