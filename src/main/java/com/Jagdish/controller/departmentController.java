package com.Jagdish.controller;

import com.Jagdish.enitity.department;
import com.Jagdish.error.departmentNotFoundException;
import com.Jagdish.service.departmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class departmentController {

    @Autowired
    private departmentService departmentService;

    @PostMapping("/departments")
    public department saveDepartment(@Valid @RequestBody department departmentData){
        return departmentService.saveDepartment(departmentData);
    }

    @GetMapping("/departments")
    public List<department> getDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public department getDepartmentsById(@PathVariable("id") Long departmentId) throws departmentNotFoundException {
        return departmentService.getDepartmentsById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody department department){
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public department getByName(@PathVariable("name") String name){
        return departmentService.getByName(name);
    }

}
