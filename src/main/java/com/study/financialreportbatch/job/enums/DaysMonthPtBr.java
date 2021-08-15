package com.study.financialreportbatch.job.enums;

public enum DaysMonthPtBr {

    JAN("01", "JAN"),
    FEV("02", "FEV"),
    MAR("03", "MAR"),
    ABR("04", "ABR"),
    MAI("05", "MAI"),
    JUN("06", "JUN"),
    JUL("07", "JUL"),
    AGO("08", "AGO"),
    SET("09", "SET"),
    OUT("10", "OUT"),
    NOV("11", "NOV"),
    DEZ("12", "DEZ");

    DaysMonthPtBr(String mounthNumber, String mounthName) {
        this.mounthName = mounthName;
        this.mounthNumber = mounthNumber;
    }

    private String mounthNumber;
    private String mounthName;

    public String getMounthNumber() {
        return mounthNumber;
    }

    public String getMounthName() {
        return mounthName;
    }

    public static String getNumberMounthByNamePtBr(String name) {
        for (DaysMonthPtBr dM : DaysMonthPtBr.values()) {
            if (name.equalsIgnoreCase(dM.getMounthName()))
                return dM.getMounthNumber();
        }
        return null;
    }

}