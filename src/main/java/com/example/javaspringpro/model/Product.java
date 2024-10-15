package com.example.javaspringpro.model;

import org.apache.catalina.valves.LoadBalancerDrainingValve;

public class Product {
  private Long id;
  private String AccountNumber;
  private Integer Balance;
  private String ProductType;
  private User  user;

  public Product(Long id, String accountNumber, Integer balance, String productType, User user) {
    this.id = id;
    AccountNumber = accountNumber;
    Balance = balance;
    ProductType = productType;
    this.user = user;
  }

  public Long getId() {
    return id;
  }

  public String getAccountNumber() {
    return AccountNumber;
  }

  public Integer getBalance() {
    return Balance;
  }

  public String getProductType() {
    return ProductType;
  }

  public User getUser() {
    return user;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setAccountNumber(String accountNumber) {
    AccountNumber = accountNumber;
  }

  public void setBalance(Integer balance) {
    Balance = balance;
  }

  public void setProductType(String productType) {
    ProductType = productType;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "Product{" +
            "id=" + id +
            ", AccountNumber='" + AccountNumber + '\'' +
            ", Balance=" + Balance +
            ", ProductType='" + ProductType + '\'' +
            ", user=" + user +
            '}';
  }
}
