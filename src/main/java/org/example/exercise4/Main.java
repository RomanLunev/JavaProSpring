package org.example.exercise4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.sql.SQLException;

@ComponentScan
public class Main {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(Main.class);

        UserService userService = context.getBean(UserService.class);
        System.out.println(userService);

        User user1 =  userService.insert("Bob");
        User user2 = userService.insert("Tom");
        System.out.println(user1);

        System.out.println(userService.findById(user1.getId()));

        System.out.println(userService.findAll());

        userService.delete(user1);
        userService.delete(user2);
    }
}