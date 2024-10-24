package com.example.javaspringpro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "account_number")
  private String AccountNumber;

  @Column(name = "balance")
  private Integer Balance;

  @Column(name = "product_type")
  private String ProductType;

  @Column(name = "user_id")
  private Long userId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAccountNumber() {
    return AccountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    AccountNumber = accountNumber;
  }

  public Integer getBalance() {
    return Balance;
  }

  public void setBalance(Integer balance) {
    Balance = balance;
  }

  public String getProductType() {
    return ProductType;
  }

  public void setProductType(String productType) {
    ProductType = productType;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long user) {
    this.userId = user;
  }
}
