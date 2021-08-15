package com.study.financialreportbatch.job.writer;

import com.study.financialreportbatch.job.entity.Despesas;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;

@Configuration
public class DatabaseDespesasWriterConfiguration {

    @Bean
    public JdbcBatchItemWriter<Despesas> databaseDespesas(
            @Qualifier("springDataSource") DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Despesas>()
                .dataSource(dataSource)
                .sql("insert into despesas (descricao, data_desp, hor_inc, tipo,forma_pagamento, valor) values (:descricao, :dataDesp, :horInc, :tipo, :formaPagamento, :valor )")
                .beanMapped()
                .build();
    }

}