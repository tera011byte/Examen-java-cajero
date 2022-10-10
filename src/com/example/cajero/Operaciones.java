package com.example.cajero;

import com.example.models.Cuenta;
import com.example.models.Historico;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

public class Operaciones {
    private Cuenta user = new Cuenta();

    public Cuenta getUser() {
        return user;
    }

    public void setUser(Cuenta user) {
        this.user = user;
    }

    public void consultarSaldo(){
        System.out.println("Saldo Disponible: $" + user.getSaldo() );
        subMenu();

    }

    public void retirarSaldo(){

        System.out.println("Saldo Disponible: $" + user.getSaldo() );
        System.out.print("Monto a Retirar: $");
        BigDecimal montoRetiro = validaEntrada();
        registroMovimientos(montoRetiro);
    }

    public void historicoMovimientos(){
        System.out.println("Movimientos Realizados");
        for (Historico hist : user.getHistoricoList()){
            System.out.println(hist);
        }
        subMenu();
    }

    public void mostarOperaciones(){


        System.out.println("Bienvenido "+ user.getNombre());
        System.out.println("1.- Consultar Saldo.");
        System.out.println("2.- Retirar Saldo.");
        System.out.println("3.- Historico de Movimientos.");
        System.out.println("4.- Salir.");
        Scanner scan = new Scanner(System.in);
        Integer opcion = 0;
        while(opcion != 4){
            if (scan.hasNextInt()){
                opcion = scan.nextInt();
                switch (opcion){
                    case 1:
                        consultarSaldo();
                        break;
                    case 2:
                        retirarSaldo();
                        break;
                    case 3:
                        historicoMovimientos();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        mostarOperaciones();
                        break;
                }
            }else {
                scan.next();
                System.out.println("Solo digita una opcion numerica");
            }
            break;
        }

    }

    private void subMenu() {


        System.out.println("1.- Menu Principal.");
        System.out.println("2.- Salir.");
        Scanner scanSub = new Scanner(System.in);
        Integer opcionSub = 0;
        while (opcionSub != 2) {
            if (scanSub.hasNextInt()) {
                opcionSub = scanSub.nextInt();
                switch (opcionSub) {
                    case 1:
                        mostarOperaciones();
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } else {
                scanSub.next();
                System.out.println("Solo digita una opcion numerica");
            }
            break;
        }
    }

    private BigDecimal validaEntrada(){
        Scanner scanV = new Scanner(System.in);
        BigDecimal valor = new BigDecimal(0);
        if (scanV.hasNextInt()){
            valor = scanV.nextBigDecimal();
            return valor;
        }else {
            scanV.next();
            System.out.println("No ingreses caracteres alfabeticos.");
        }
        return valor;
    }

    private void registroMovimientos(BigDecimal retiro){
        Historico nuevoMovimiento = new Historico();
        if (retiro.compareTo(user.getSaldo()) == -1){
            nuevoMovimiento.setSaldoAnterior(user.getSaldo());
            user.setSaldo(user.getSaldo().subtract(retiro));
            nuevoMovimiento.setSaldoActual(user.getSaldo());
            nuevoMovimiento.setMontoRetirado(retiro);
            nuevoMovimiento.setFecha(new Date());
            user.addHistorico(nuevoMovimiento);
            System.out.println("Transaccion Realizada con Exito");
            subMenu();
        }else{
            System.out.println("Saldo insufucuente");
            consultarSaldo();
        }

    }
}
