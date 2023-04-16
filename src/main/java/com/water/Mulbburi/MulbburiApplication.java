package com.water.Mulbburi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.water.Mulbburi")
@SpringBootApplication
public class MulbburiApplication {

   public static void main(String[] args) {
      SpringApplication.run(MulbburiApplication.class, args);
   }

}