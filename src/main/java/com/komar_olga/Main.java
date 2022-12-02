package com.komar_olga;

public class Main {

  public static void main(String[] args) {
    SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
    sessionFactoryUtils.init();
    try {
      ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);

      System.out.println(productDao.findById(0L));
      System.out.println(productDao.findById(3L));
      System.out.println(productDao.findById(6L));
      System.out.println();

      System.out.println(productDao.findByName("Almond"));
      System.out.println();

      System.out.println(productDao.findAll());
      System.out.println();

      productDao.saveOrUpdate(new Product("Brazil nut", 20));


      System.out.println(productDao.findAll());
      System.out.println();

      productDao.updateNameById(3L, "APPLE");
      System.out.println(productDao.findById(3L));

      productDao.deleteById(4L);
      System.out.println(productDao.findAll());
      System.out.println();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sessionFactoryUtils.shutdown();
    }
  }
}