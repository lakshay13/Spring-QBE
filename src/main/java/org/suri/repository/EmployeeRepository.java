package org.suri.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.suri.model.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>, QueryByExampleExecutor<Employee> {

    List<Employee> findByEmployeePosition(String position);
    List<Employee> findByEmployeeId(int id);
}
