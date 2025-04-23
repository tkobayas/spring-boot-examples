package com.example.demo;

import com.example.Person;
import com.example.demo.rule.facade.RuleFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RuleFacadeTest {

    @Autowired
    private RuleFacade ruleFacade;

    @Test
    void executeRule() {
        Person testPerson = new Person("Test", 25);
        ruleFacade.executeRule(testPerson);
        assertThat(testPerson.isAdult()).isTrue();
    }
}