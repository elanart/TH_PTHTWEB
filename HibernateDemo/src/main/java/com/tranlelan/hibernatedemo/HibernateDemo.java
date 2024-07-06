/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.tranlelan.hibernatedemo;

import com.tranlelan.pojo.Cart;
import com.tranlelan.repository.impl.CategoryRepositoryImpl;
import com.tranlelan.repository.impl.ProductRepositoryImpl;
import com.tranlelan.repository.impl.ReceiptRepositoryImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
//        CategoryRepositoryImpl categoryRepositoryImpl = new CategoryRepositoryImpl();
//        
//        categoryRepositoryImpl.getCategories().forEach(c -> System.out.println(c.getName()));

//        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();
        
//        Map<String, String> params = new HashMap<>();
//        params.put("name", "iPhone");
//        params.put("fromPrice", "30000000");
//        params.put("cateId", "5");

//        params.put("page", "1");

        
//        productRepositoryImpl.getProducts(params).forEach(p -> System.out.printf("%s - %.1f\n", p.getName(), p.getPrice()));
        List<Cart> carts = new ArrayList<>();
        carts.add(new Cart(1, "iPhone 7", 2, 200l));
        
        ReceiptRepositoryImpl receiptRepositoryImpl = new ReceiptRepositoryImpl();
        receiptRepositoryImpl.addReceipt(carts);
    }
}
