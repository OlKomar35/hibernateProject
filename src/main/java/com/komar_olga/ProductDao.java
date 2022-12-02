package com.komar_olga;

import java.util.List;

public interface ProductDao {
  Product findById(Long id);
  Product findByName(String title);
  List<Product> findAll();
  void save(Product product);
  void updateNameById(Long id, String newTitle);
}
