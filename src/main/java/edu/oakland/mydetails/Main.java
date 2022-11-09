package edu.oakland.mydetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "edu.oakland")
public class Main extends SpringBootServletInitializer {
  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
}
