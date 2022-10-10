package com.example.models;

import java.math.BigDecimal;
import java.util.Date;

public class Historico {
    private Date fecha;
    private BigDecimal saldoAnterior;
    private BigDecimal saldoActual;
    private BigDecimal montoRetirado;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(BigDecimal saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public BigDecimal getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(BigDecimal saldoActual) {
        this.saldoActual = saldoActual;
    }

    public BigDecimal getMontoRetirado() {
        return montoRetirado;
    }

    public void setMontoRetirado(BigDecimal montoRetirado) {
        this.montoRetirado = montoRetirado;
    }

    @Override
    public String toString() {
        return "Historico{" +
                "fecha=" + fecha +
                ", saldoAnterior=" + saldoAnterior +
                ", saldoActual=" + saldoActual +
                ", montoRetirado=" + montoRetirado +
                '}';
    }
}
