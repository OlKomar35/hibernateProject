package com.komar_olga;

import java.util.List;

public interface ProductDao {
  Product findById(Long id);
  Product findByName(String title);
  List<Product> findAll();
  void saveOrUpdate(Product product);
  void updateNameById(Long id, String newTitle);
  void deleteById(Long id);
}
