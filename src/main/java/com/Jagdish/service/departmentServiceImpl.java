package com.Jagdish.service;

import com.Jagdish.enitity.department;
import com.Jagdish.error.departmentNotFoundException;
import com.Jagdish.repository.departmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class departmentServiceImpl implements departmentService{

    @Autowired
    private departmentRepository departmentRespository;

    @Override
    public department saveDepartment(department departmentData) {
        return departmentRespository.save(departmentData);
    }

    @Override
    public List<department> getDepartments() {
        return departmentRespository.findAll();
    }

    @Override
    public department getDepartmentsById(Long departmentId) throws departmentNotFoundException {

        Optional<department> department = departmentRespository.findById(departmentId);
        if(! department.isPresent()){
            throw new departmentNotFoundException("Department not Found");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRespository.deleteById(departmentId);
    }

    @Override
    public department updateDepartment(Long departmentId, department department) {
        department tempDepartment = departmentRespository.findById(departmentId).get();
        tempDepartment.setDepartmentAddress(department.getDepartmentAddress());
        tempDepartment.setDepartmentName(department.getDepartmentName());
        tempDepartment.setDepartmentCode(department.getDepartmentCode());
        return departmentRespository.save(tempDepartment);
    }

    @Override
    public department getByName(String name) {
        return departmentRespository.findByDepartmentName(name);
    }


}
