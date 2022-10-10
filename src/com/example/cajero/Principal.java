package com.example.cajero;

public class Principal {

    public static void main(String[] args) {
        Login log = new Login();

        if (log.logIn()){

            Operaciones op = new Operaciones();

            op.mostarOperaciones();


        }else{
            System.out.println("PIN Incorrecto");
        }
    }

}
