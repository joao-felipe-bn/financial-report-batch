package com.study.financialreportbatch.job.processor;

import com.study.financialreportbatch.job.entity.Despesas;
import com.study.financialreportbatch.job.enums.FormaPagamento;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class DespesasProcessorConfiguration {

    @Bean
    public ItemProcessor<Despesas, Despesas> process() {
        return new ItemProcessor<Despesas, Despesas>() {
            @Override
            public Despesas process(Despesas despesas) throws Exception {
                if (despesas.getTipo().equalsIgnoreCase("Débito")) {
                    despesas.setFormaPagamento(FormaPagamento.getFormaPagamentoByDescription(despesas.getDescricao()));
                    despesas.setHorInc(new Date());
                    return despesas;
                }
                return null;
            }
        };
    }

}

