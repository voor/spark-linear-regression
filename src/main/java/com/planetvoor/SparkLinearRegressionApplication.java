package com.planetvoor;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SparkLinearRegressionApplication implements CommandLineRunner {


    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job tweetTopHashtags;

    public static void main(String[] args) {
        SpringApplication.run(SparkLinearRegressionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("RUNNING ...");
        jobLauncher.run(tweetTopHashtags, new JobParametersBuilder().toJobParameters());
    }

}
