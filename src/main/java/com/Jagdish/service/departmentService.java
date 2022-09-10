package com.Jagdish.service;

import com.Jagdish.enitity.department;
import com.Jagdish.error.departmentNotFoundException;

import java.util.List;

public interface departmentService {
    public department saveDepartment(department departmentData);

    public List<department> getDepartments();

    public department getDepartmentsById(Long departmentId) throws departmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public department updateDepartment(Long departmentId, department department);

    public department getByName(String name);
}
