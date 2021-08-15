package com.study.financialreportbatch.job.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class FinancialReportJobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job financialReportJob(@Qualifier("csvToDatabaseReportStep") Step csvToDatabaseReportStep){
        return jobBuilderFactory
                .get("financialReportJob")
                .start(csvToDatabaseReportStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

}
