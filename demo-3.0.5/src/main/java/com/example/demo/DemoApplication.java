package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        System.out.println("starting");

        SpringApplication.run(DemoApplication.class, args);

        HelloJarUnit unit = new HelloJarUnit();
        unit.getStrings().add("Hello Jar");

        try (RuleUnitInstance<HelloJarUnit> unitInstance = RuleUnitProvider.get().createRuleUnitInstance(unit)) {
            unitInstance.fire();
            System.out.println("results = " + unit.getResults());
        }
    }
}
