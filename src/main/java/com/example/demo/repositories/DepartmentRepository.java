package com.example.demo.repositories;

import com.example.demo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
//    @Query("select p from Department p where p.fullName=?1")
//    Department myCustomQuery(String fullName);

    @Query(value="select * from Department p where p.Full_Name=?1",nativeQuery=true)
    Department findByFillName(String fullName);
}
