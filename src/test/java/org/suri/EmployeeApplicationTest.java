package org.suri;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;
import org.suri.model.Employee;
import org.suri.repository.EmployeeRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by lakshay on 26/11/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeApplicationTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee emp1;
    private Employee emp2;
    private Employee emp3;

    @Before
    public void setup() {
        emp1 = new Employee("Lakshay", "Developer", 12);
        emp2 = new Employee("John", "Analyst", 13);
        emp3 = new Employee("David", "Developer", 14);

        employeeRepository.save(emp1);
        employeeRepository.save(emp2);
        employeeRepository.save(emp3);
    }

    @Test
    public void testFindEmployeesWithPositionAnalyst() {

        /**
         * The aim is to find the employees whose position is analyst
         */

        // given: example object with specific employee that needs to be searched
        Example<Employee> example = Example.of(emp1);

        // when: findAll with the example object is made
        Iterable<Employee> iterable = employeeRepository.findAll(example);
        List<Employee> list = Lists.newArrayList(iterable);

        // then: list should contain the employee defined by example
        assertEquals(emp1.getName(), list.get(0).getName());
        assertEquals(emp1.getEmpId(), list.get(0).getEmpId());
        assertEquals(emp1.getPosition(), list.get(0).getPosition());
    }

    @Test
    public void testFindEmployeesWhosePositionContainDev() {

        // given: find all employees who have "Dev" in their position
        Employee emp1 = new Employee();
        emp1.setPosition("Dev");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnorePaths("employeeName","employeeId");// do not take into account the values of these fields
        Example<Employee> example = Example.of(emp1, matcher);

        // when: example object is used to search all the employees with the condition
        Iterable<Employee> iterable = employeeRepository.findAll(example);
        List<Employee> list = Lists.newArrayList(iterable);

        // then: list should contain the employees who have "Dev" in their position
        assertEquals("Developer", list.get(0).getPosition());
        assertEquals("Developer", list.get(1).getPosition());
    }
}
