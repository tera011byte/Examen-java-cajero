package com.example.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private String nombre = "Cristobal Flores";
    private BigDecimal saldo = BigDecimal.valueOf(1000);
    private List<Historico> historicoList;

    public Cuenta() {
        historicoList = new ArrayList<>();
    }

    public List<Historico> getHistoricoList() {
        return historicoList;
    }

    public void setHistoricoList(List<Historico> historicoList) {
        this.historicoList = historicoList;
    }

    public void addHistorico(Historico histor){
        historicoList.add(histor);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
