package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CompanyFacadeTest {

    @Autowired
    CompanyDao companyDao;
    @Autowired
    CompanyFacade companyFacade;

    @Test
    public void testCompanyFacade() {
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

        try {
            companyFacade.retrieveCompanyWithNameHaving("software");
            companyFacade.retrieveEmployeeWithNameHaving("mith");
        } catch (RetrieverException e) {
            //business exception - should be handled in real application
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