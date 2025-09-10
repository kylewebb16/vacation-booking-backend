package com.d288.performanceassessment.bootstrap;

import com.d288.performanceassessment.dao.CustomerRepository;
import com.d288.performanceassessment.dao.DivisionRepository;
import com.d288.performanceassessment.entity.Customer;
import com.d288.performanceassessment.entity.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {
    private CustomerRepository customerRepository;
    private DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (customerRepository.count() > 1) {
            return;
        }
        List<Division> divisionSet = divisionRepository.findAll();
        customerRepository.save(new Customer("Jake", "Gylenhall", "123 Roadhouse lane", "01234", "9998887777", divisionSet.get(1)));
        customerRepository.save(new Customer("Leonardo", "Dicaprio", "456 Titanic Road", "12345", "5554443333", divisionSet.get(2)));
        customerRepository.save(new Customer("Brad", "Pitt", "789 Troy Street", "23456", "2221119999", divisionSet.get(3)));
        customerRepository.save(new Customer("Christian", "Bale", "234 Psycho Drive", "34567", "8887776666", divisionSet.get(4)));
        customerRepository.save(new Customer("Tom", "Hardy", "234 Gotham Ave", "45678", "2345678901", divisionSet.get(5)));
    }
}
