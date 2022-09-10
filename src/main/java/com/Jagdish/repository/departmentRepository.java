package com.Jagdish.repository;

import com.Jagdish.enitity.department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface departmentRepository extends JpaRepository<department,Long> {
    public department findByDepartmentName(String name);
}
