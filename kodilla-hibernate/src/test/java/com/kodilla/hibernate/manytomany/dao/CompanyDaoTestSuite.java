package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testRetrieveNames() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee adamSmith = new Employee("Adam", "Smith");

        Company softwareMachine = new Company("Software Machine");
        Company softwareMaesters = new Company("Software Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        softwareMachine.getEmployees().add(adamSmith);
        softwareMaesters.getEmployees().add(stephanieClarckson);
        softwareMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(softwareMaesters);
        lindaKovalsky.getCompanies().add(softwareMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);
        adamSmith.getCompanies().add(softwareMachine);

        companyDao.save(softwareMachine);
        companyDao.save(softwareMaesters);
        companyDao.save(greyMatter);

        //When
        List<Employee> employeesWithLastName = employeeDao.retrieveEmployeesWithLastName("Smith");
        List<Company> companiesStartingWith = companyDao.retrieveCompaniesWithNameStarting("sof");

        //Then
        try {
            assertThat(employeesWithLastName).containsExactly(johnSmith, adamSmith);
            assertThat(employeesWithLastName.get(0).getId()).isGreaterThan(0);
            assertThat(companiesStartingWith).containsExactly(softwareMachine, softwareMaesters);
            assertThat(companiesStartingWith.get(0).getId()).isGreaterThan(0);
        } finally {
            //CleanUp
            try {
                companyDao.deleteById(softwareMachine.getId());
                companyDao.deleteById(softwareMaesters.getId());
                companyDao.deleteById(greyMatter.getId());
            } catch (EmptyResultDataAccessException e) {
                //do nothing
            }
        }
    }
}