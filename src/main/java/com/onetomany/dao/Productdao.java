package com.onetomany.dao;

import com.onetomanyuni1.dto.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Productdao {

    public EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nanditha");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    public void saveProduct(Product product) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(product);
        entityTransaction.commit();
    }

    public void updateProduct(int id, Product updatedProduct) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Product existingProduct = entityManager.find(Product.class, id);
        
        if (existingProduct != null) {
            existingProduct.setId(id);
            existingProduct.setList(updatedProduct.getList());
            entityTransaction.begin();
            entityManager.merge(existingProduct);
            entityTransaction.commit();
        } else {
            System.out.println("Product doesn't exist");
        }
    }

    public void deleteProduct(int id) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            entityTransaction.begin();
            entityManager.remove(product);
            entityTransaction.commit();
        } else {
            System.out.println("Product doesn't exist");
        }
    }

    public List<Product> getAllProducts() {
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("SELECT p FROM Product p");
        List<Product> productList = query.getResultList();
        for (Product product : productList) {
            System.out.println(product);
        }
        return productList;
    }
}
