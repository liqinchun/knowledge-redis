package com.liqnchun.knowledge.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HashMappingTest {

    @Autowired
    HashMapping hashMapping;

    @Test
    void writeHash() {
        Person person = new Person();
        person.setName("liqinchun");
        hashMapping.writeHash("person",person);
    }

    @Test
    void loadHash() {
        hashMapping.loadHash("person");
    }
}