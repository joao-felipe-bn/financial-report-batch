package com.study.financialreportbatch.job.enums;

public enum FormaPagamento {

    BOLETO("BOLETO"),
    DEBITO("DEBITO"),
    PIX_ENVIADO("PIX");

    FormaPagamento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private String value;

    public static String getFormaPagamentoByDescription(String value) {
        for (FormaPagamento fp : FormaPagamento.values()) {
            if (value.contains(fp.value)) {
                return fp.value;
            }
        }
        return null;
    }


}
