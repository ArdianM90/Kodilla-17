package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchEngineFacadeTestSuite {
    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    SearchEngineFacade searchEngine;

    @After
    public void cleanUp() {
        //CleanUp
        try {
            companyDao.deleteAll();
            employeeDao.deleteAll();
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    @Test
    @Transactional
    public void shouldFindCompaniesByNameFragment() {
        //Given
        Company dataMaesters = new Company("Data Maesters");
        Company softwareMachine = new Company("Software Machine");
        Company utilitarySoftware = new Company("Utilitary Software");
        Company greyMatter = new Company("Grey Matter");
        companyDao.save(dataMaesters);
        companyDao.save(softwareMachine);
        companyDao.save(utilitarySoftware);
        companyDao.save(greyMatter);

        //When
        List<Company> retrievedCompanies = searchEngine.findCompaniesByNameFragment("Soft");

        //Then
        assertEquals(2, retrievedCompanies.size());
    }

    @Test
    @Transactional
    public void shouldFindEmployeesByNameFragment() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee smithKovalsky = new Employee("Smith", "Kovalsky");
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);
        employeeDao.save(smithKovalsky);

        //When
        List<Employee> retrievedEmployees = searchEngine.findEmployeesByNameFragment("mit");

        //Then
        assertEquals(2, retrievedEmployees.size());
    }
}
