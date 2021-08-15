package com.study.financialreportbatch.job.step;

import com.study.financialreportbatch.job.entity.Despesas;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CsvToDatabaseReportStepConfiguration {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step csvToDatabaseReportStep(@Qualifier("arquivoDespesasBancoReader") ItemReader<Despesas> arquivoDespesasBancoReader,
                                        @Qualifier("process") ItemProcessor<Despesas, Despesas> process,
                                        @Qualifier("databaseDespesas") ItemWriter<Despesas> databaseDespesas) {
        return stepBuilderFactory
                .get("csvToDatabaseReportStep")
                .<Despesas, Despesas>chunk(1)
                .reader(arquivoDespesasBancoReader)
                .processor(process)
                .writer(databaseDespesas)
                .build();
    }

}
