package com.example.cajero;

import java.util.Scanner;

public class Login {
    public static Integer pswd = 1235;

    public boolean logIn(){

        boolean access = false;
        Scanner scan = new Scanner(System.in);
        Integer pswdIn = 0;
        int intentos = 3;

        for (int i=0 ; i<3; i++){
            System.out.println("Bienvenido Ingresa PIN tienes " + intentos + " intentos.");
            if (scan.hasNextInt()){
                pswdIn = scan.nextInt();
                if (pswd.equals(pswdIn)){
                    access=true;
                    break;
                }else {
                    System.out.println("PIN Incorrecto");
                    intentos--;
                }
            }else {
                scan.next();
                intentos--;
                System.out.println("Recuerda el PIN es numerico, No ingreses caracteres alfabeticos.");
            }

        }

        return access;
    }
}
