package com.Jagdish.service;

import com.Jagdish.enitity.department;
import com.Jagdish.repository.departmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

// unit testing of service layer
@SpringBootTest
class departmentServiceTest {

    @Autowired
    private departmentService departmentService;

    @MockBean
    private departmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        department department1 = department.builder()
                .departmentCode("11")
                .departmentAddress("111")
                .departmentName("IT")
                .departmentId(1L).build();
        when(departmentRepository.findByDepartmentName("IT")).thenReturn(department1);
    }

    @Test
    @Disabled
    public void checkGetDepartmentByName(){
        String departName = "IT";
        department found = departmentService.getByName(departName);
        assertEquals(departName,found.getDepartmentName());
    }
}