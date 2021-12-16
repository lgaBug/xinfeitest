package com.example.springbootdemo;

import com.example.springbootdemo.config.JpaConfiguration;
import com.example.springbootdemo.domain.Country;
import com.example.springbootdemo.repository.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {JpaConfiguration.class,SpringBootDemoApplication.class})
class SpringBootDemoApplicationTests {
    private static Logger logger=LoggerFactory.getLogger(SpringBootDemoApplicationTests.class);
    @Autowired
    private CountryRepository countryRepository;

    @BeforeEach
    public void createCountry(){
        Country country=new Country();
        country.setCountrycode("86");
        country.setCountryname("China");
        countryRepository.save(country);
        assert  country.getId()>0 : "create error";
    }

    @Test
    public void getData() {
        List<Country> countries=countryRepository.findAll();
        assert countries!=null:"getdata is null";
        for (Country countryi:countries){
            logger.info("=== country name ={}",countryi.getCountryname());
        }
    }

}
