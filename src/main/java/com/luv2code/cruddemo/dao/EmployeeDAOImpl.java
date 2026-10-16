package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

//    define entity
    private EntityManager entityManager;
//    define constructor
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
//        create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee theEmployee = entityManager.find(Employee.class, id);

        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {

        Employee theEmployee = entityManager.find(Employee.class, id);

        entityManager.remove(theEmployee);

    }
}
