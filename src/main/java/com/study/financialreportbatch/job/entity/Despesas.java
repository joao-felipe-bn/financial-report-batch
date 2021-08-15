package com.study.financialreportbatch.job.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class Despesas {

    private BigInteger id;
    private String descricao;
    private Date dataDesp;
    private Date horInc;
    private String tipo;
    private String formaPagamento;
    private BigDecimal valor;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataDesp() {
        return dataDesp;
    }

    public void setDataDesp(Date dataDesp) {
        this.dataDesp = dataDesp;
    }

    public Date getHorInc() {
        return horInc;
    }

    public void setHorInc(Date horInc) {
        this.horInc = horInc;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Despesas{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", dataDesp=" + dataDesp +
                ", horInc=" + horInc +
                ", tipo='" + tipo + '\'' +
                ", formaPagamento='" + formaPagamento + '\'' +
                ", valor=" + valor +
                '}';
    }
}
