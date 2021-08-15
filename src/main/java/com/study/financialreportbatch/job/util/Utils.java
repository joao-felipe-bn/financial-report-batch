package com.study.financialreportbatch.job.util;

import com.study.financialreportbatch.job.enums.DaysMonthPtBr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Utils {

    public static Date convertStringCsvToDate(String dataCsv){

        String currentYear = String.valueOf(LocalDate.now().getYear());
        String[] dataSplt = dataCsv.split("/");
        String day = dataSplt[0];
        String mounth = DaysMonthPtBr.getNumberMounthByNamePtBr(dataSplt[1]);

        String finalDate = String.format("%s/%s/%s",currentYear,mounth,day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            try {
                return sdf.parse(finalDate);
            } catch (ParseException e) {
                //empty on purpose
                System.out.println(e.getMessage());
            }
        return null;
    }

}
