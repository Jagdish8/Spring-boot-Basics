package com.Jagdish.repository;

import com.Jagdish.enitity.department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

//unit test for respository layer
@DataJpaTest
class departmentRepositoryTest {

    @Autowired
    private departmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        department department1 = department.builder()
                .departmentCode("11")
                .departmentId(1L)
                .departmentAddress("21")
                .departmentName("IT")
                .build();
        testEntityManager.persist(department1);
    }

    @Test
    @Disabled
    public void checkFindById(){
        department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"IT");
    }
}