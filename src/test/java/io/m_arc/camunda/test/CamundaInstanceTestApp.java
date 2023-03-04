package io.m_arc.camunda.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamundaInstanceTestApp {
    public static void main(String... args) {
        SpringApplication.run(CamundaInstanceTestApp.class, args);
    }
}
