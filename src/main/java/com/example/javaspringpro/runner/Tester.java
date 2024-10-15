package com.example.javaspringpro.runner;


import com.example.javaspringpro.model.Product;
import com.example.javaspringpro.model.User;
import com.example.javaspringpro.service.ProductService;
import com.example.javaspringpro.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Tester implements CommandLineRunner {

  private final UserService userService;
  private final Logger log = LoggerFactory.getLogger(Tester.class);
  private final ProductService productService;

  public Tester(UserService userService, ProductService productService) {
    this.userService = userService;
    this.productService = productService;
  }

  @Override
  public void run(String... args) throws Exception {
    log.info("Tester started");

    productService.deleteAll();
    userService.deleteAll();

    User user1 =  userService.insert("Bob");
    log.info("inserted user: {}", user1);
    User user2 = userService.insert("Tom");
    log.info("inserted user: {}", user2);


    log.info("found by id: {}", userService.findById(user1.getId()));
    log.info("found all users: {}", userService.findAll());

    Product product1 = productService.insert("40702810_1", 100, "Account", user1);
    log.info("inserted product: {}", product1);
    Product product2 = productService.insert("40702810_2", 200, "Card", user1);
    log.info("inserted product: {}", product2);

    log.info("found by id: {}", productService.findById(product1.getId()));
    log.info("found all products: {}", productService.findAllByUser(user1));
   }
}
