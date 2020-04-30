package org.e4x.mit21.dm2020MIT21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamSampleApplication {

    @Autowired
    TableSampleRepository tableSampleRepository;

    public static void main(String[] args) {
        SpringApplication.run(ExamSampleApplication.class, args);
    }

    

}
