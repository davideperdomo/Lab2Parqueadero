/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueaderolab;

/**
 *
 * @author Monica
 */
public class Parqueaderolab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int A1[] = new int[24];
        int B1[][] = new int[3][21];
        //horaing(6<=h<=20)
        int horaing;
        int A2[] = new int[24];
        int B2[][] = new int[3][21];
        //minutoing(h<60)
        int mining;
        int A3[] = new int[24];
        int B3[][] = new int[3][21];
        //placa
        String placa;
        String A4[] = new String[24];
        String B4[][] = new String[3][21];
        //disponibilidad(1-0)
        int A5[] = new int[24];
        int B5[][] = new int[3][21];
        //crearmatrizposicion
        int i;
        int j = 0;
        int n = 1;
        for (i = 0; i < 24; i = i + 1) {
            A5[i] = n;
            n++;
        }
        int n2 = 25;
        for (i = 0; i < 3; i = i + 1) {
            for (j = 2; j < 21; j = j + 1) {
                B5[i][j] = n2;
                n2 = n2 + 1;
            }
        }
        //crearmatrizdisponibilidad

        for (i = 0; i < 24; i = i + 1) {
            A5[i] = 0;
        }
        for (i = 0; i < 3; i = i + 1) {
            for (j = 2; j < 21; j = j + 1) {
                B5[i][j] = 0;
            }
        }
        //leerdatos
        java.util.Scanner lectura
                = new java.util.Scanner(System.in);
        System.out.println("Ingrese la hora(solo hora)");
        horaing = lectura.nextInt();
        System.out.println("Ingrese minutos");
        mining = lectura.nextInt();
        java.util.Scanner sc
                = new java.util.Scanner(System.in);

        System.out.println("Ingrese la PLACA del automovil que va a ingresar ");
        placa = sc.nextLine();

        int cp = 0;
        for (i = 0; i < 24; i = i + 1) {
            if (A5[i] == 0) {
                A5[i] = 1;
                A2[i] = horaing;
                A3[i] = mining;
                A4[i] = placa;
                cp = 1;
                break;
            }
            if (A5[i] == 1) {
                break;
            }
        }

        for (i = 0; i < 3; i = i + 1) {
            for (j = 0; j < 21; j = j + 1) {
                if (B5[i][j] == 0) {
                    B5[i][j] = 1;
                    B2[i][j] = horaing;
                    B3[i][j] = mining;
                    B4[i][j] = placa;
                    cp = 2;
                    break;
                }
                if (B5[i][j] == 1) {
                    break;
                }
            }
            if (B5[i][j] == 1) {
                break;
            }
        }
        switch (cp) {
            case 1:
                System.out.println("Debe parquearse en la posicion: " + A5[i]);
                break;
            case 2:
                System.out.println("Debe parquearse en la posicion: " + B5[i][j]);
                break;
        }
        //     
        String placaing;
        int hora = 0, min = 0;
        int horasal, minsal;
        System.out.println("Ingrese la hora(solo hora)");
        horasal = lectura.nextInt();
        System.out.println("Ingrese minutos");
        minsal = lectura.nextInt();
        System.out.println("Ingrese la PLACA del automovil que va a salir");
        placaing = sc.nextLine();
        for (i = 0; i < 24; i = i + 1) {
            if (A4[i] == placaing) {
                hora = A2[i];
                min = A3[i];
            }
        }
        for (i = 0; i < 3; i = i + 1) {
            for (j = 0; j < 21; j = j + 1) {
                if (B4[i][j] == placaing) {
                    hora = B2[i][j];
                    min = B3[i][j];
                }
            }
        }
        int horat, mint, t, din, dintotal=0;
        horat = horasal - hora;
        mint = minsal - min;
        t = horat + mint;
        din = t * 66;
        System.out.println("Debe pagar: " + din + "pesos");
        //
        dintotal=dintotal+din;
        puestosLibres(A5, B5);
        
        
      
        // TODO code application logic here
    }
    
    public static int puestosLibres(int A5[], int B5[][]){
        int i, j, cont=0, cont2=0;
       for(i=0; i<24; i=i+1){
           
                if(A5[i]==0){
                    cont=cont+1;
                }
            
        }
        for(i=0; i<3; i=i+1){
            for(j=0; j<21; j=j+1){
                if(B5[i][j]==0){
                    cont2=cont2+1;
                }
            }
        }    
        return cont+cont2;
        
    }

}
