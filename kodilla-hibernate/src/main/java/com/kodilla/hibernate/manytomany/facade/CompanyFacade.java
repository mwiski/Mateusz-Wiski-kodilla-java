package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyFacade {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);

    public List<Company> retrieveCompanyWithNameHaving(final String namePart) throws RetrieverException {
        LOGGER.info("Searching for companies with " + namePart + " in company name");
        List<Company> foundCompanies = companyDao.retrieveCompaniesWithNameHaving(namePart);
        if (foundCompanies.isEmpty()) {
            LOGGER.error(RetrieverException.ERR_RETRIVING_COMPANY);
            throw new RetrieverException(RetrieverException.ERR_RETRIVING_COMPANY);
        }
        LOGGER.info("Companies have been found");
        return foundCompanies;
    }

    public List<Employee> retrieveEmployeeWithNameHaving(final String namePart) throws RetrieverException {
        LOGGER.info("Searching for employees with " + namePart + " in their last name");
        List<Employee> foundEmployees = employeeDao.retrieveEmployeesWithLastNameHaving(namePart);
        if (foundEmployees.isEmpty()) {
            LOGGER.error(RetrieverException.ERR__RETRIVING_EMPLOYEE);
            throw new RetrieverException(RetrieverException.ERR__RETRIVING_EMPLOYEE);
        }
        LOGGER.info("Employees have been found");
        return foundEmployees;
    }
}
