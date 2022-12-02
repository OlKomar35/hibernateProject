package com.komar_olga;

import java.util.List;
import org.hibernate.Session;

public class ProductDaoImpl implements ProductDao {

  private final SessionFactoryUtils sessionFactoryUtils;

  public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
    this.sessionFactoryUtils = sessionFactoryUtils;
  }

  @Override
  public Product findById(Long id) {
    try (Session session = sessionFactoryUtils.getSession()) {
      session.beginTransaction();
      Product product = session.get(Product.class, id);
      session.getTransaction().commit();
      return product;
    }
  }

  @Override
  public Product findByName(String title) {
    try (Session session = sessionFactoryUtils.getSession()) {
      session.beginTransaction();
      Product product = session.createQuery("select product from Product product where product.title = :title",
              Product.class)
          .setParameter("title", title)
          .getSingleResult();
      session.getTransaction().commit();
      return product;
    }
  }

  @Override
  public List<Product> findAll() {
    try (Session session = sessionFactoryUtils.getSession()) {
      session.beginTransaction();
      List<Product> products = session.createQuery("select product from Product product",
          Product.class).getResultList();
      session.getTransaction().commit();
      return products;
    }
  }

  @Override
  public void save(Product product) {
    try (Session session = sessionFactoryUtils.getSession()) {
      session.beginTransaction();
      session.saveOrUpdate(product);
      session.getTransaction().commit();
    }
  }

  @Override
  public void updateNameById(Long id, String newTitle) {
    try (Session session = sessionFactoryUtils.getSession()) {
      session.beginTransaction();
      Product product = session.get(Product.class, id);
      product.setTitle(newTitle);
      session.getTransaction().commit();
    }
  }
}
