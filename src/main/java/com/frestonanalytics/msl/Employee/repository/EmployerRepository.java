package com.frestonanalytics.msl.Employee.repository;

import com.frestonanalytics.msl.Employee.entity.EmployerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<EmployerEntity,Integer> {

}