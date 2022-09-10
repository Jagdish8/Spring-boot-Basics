package com.Jagdish.controller;

import com.Jagdish.enitity.department;
import com.Jagdish.service.departmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

// unit test for controller layer
@WebMvcTest(departmentController.class)
class departmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private departmentService departmentService;

    private department Department;

    @BeforeEach
    void setUp() {
        Department = department.builder()
                .departmentAddress("11")
                .departmentId(1L)
                .departmentCode("11")
                .departmentName("IT")
                .build();
    }

    @Test
    @Disabled
    void saveDepartment() {
        department inputDepartment = department.builder()
                .departmentAddress("11")
                .departmentCode("11")
                .departmentName("IT")
                .build();

        when(departmentService.saveDepartment(inputDepartment)).thenReturn(Department);

//THIS IS CORRECT WAY, BELOW SHOULD NOT BE COMMENTED
//        mockMvc.perform(post(urlTemplate : "")
//                .contenType(MediaType.APPLICATION_JSON)
//                .content("some department content in string format"))
//                .andExpect(status().isOk());
    }

}