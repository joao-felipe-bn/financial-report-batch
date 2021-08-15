package com.study.financialreportbatch.job.reader;

import com.study.financialreportbatch.job.entity.Despesas;
import com.study.financialreportbatch.job.util.Utils;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.validation.BindException;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Configuration
public class AquivoDespesasBancoReaderConfiguration {

    @Bean
    public FlatFileItemReader<Despesas> arquivoDespesasBancoReader() {
        return new FlatFileItemReaderBuilder<Despesas>()
                .name("arquivoDespesasBancoReader")
                .resource(new FileSystemResource("files/extrato.csv"))
                .delimited()
                .names("dataDespesa", "descricaoDespesa", "tipo","valor")
                .fieldSetMapper(fieldSetMapper())
                .linesToSkip(1)
                .build();
    }

    private FieldSetMapper<Despesas> fieldSetMapper() {
        return new FieldSetMapper<Despesas>() {
            @Override
            public Despesas mapFieldSet(FieldSet fieldSet) throws BindException {
                Despesas despesas = new Despesas();
                despesas.setDataDesp(Utils.convertStringCsvToDate(fieldSet.readString("dataDespesa")));
                despesas.setDescricao(fieldSet.readString("descricaoDespesa"));
                despesas.setTipo(fieldSet.readString("tipo"));
                despesas.setValor(readValor(fieldSet.readString("valor")));
                System.out.println(despesas);
                return despesas;
            }
        };
    }

    private BigDecimal readValor(String csvValue) {

        String csvValue1 = csvValue.replaceAll(",", ".");
        String csvValue2 = csvValue1.replace("-","");
        String csvValue3 = csvValue2.replace("R$","");

        NumberFormat format = NumberFormat.getInstance(Locale.US);

        try {
            return BigDecimal.valueOf(format.parse(csvValue3.trim()).doubleValue());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}

