package onetomany.controller;

import com.onetomany.dao.Productdao;
import com.onetomanyuni1.dto.Discount;
import com.onetomanyuni1.dto.Product;

import java.util.ArrayList;
import java.util.List;

public class Productmain {

    public static void main(String[] args) {
        Productdao productDAO = new Productdao();

        // Create and save a new product
        Product newProduct = new Product();
        newProduct.setName("Example Product");
        newProduct.setDesc("Product description");
        newProduct.setSku("ABC123");
        newProduct.setCategory_id(1L);
        newProduct.setInventory_id(1L);
        newProduct.setPrice(49.99);

        // Create and save discounts
        Discount d1 = new Discount();
        d1.setDiscountName("Discount 1"); // Corrected method name
        d1.setDiscountValue(0.1);

        Discount d2 = new Discount();
        d2.setDiscountName("Discount 2"); // Corrected method name
        d2.setDiscountValue(0.2);

        List<Discount> discountList = new ArrayList<>();
        discountList.add(d1);
        discountList.add(d2);

        newProduct.setDiscountList(discountList);

        productDAO.saveProduct(newProduct);
        System.out.println("New product saved. Product ID: " + newProduct.getId());

        // Retrieve and display all products
        System.out.println("All Products:");
        List<Product> allProducts = productDAO.getAllProducts();
        for (Product product : allProducts) {
            System.out.println("Product ID: " + product.getId() + ", Name: " + product.getName());
        }

        // Close the EntityManager and EntityManagerFactory
       
    }
}
