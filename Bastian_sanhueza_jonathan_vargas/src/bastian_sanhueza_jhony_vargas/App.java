package bastian_sanhueza_jhony_vargas;

import java.util.Scanner;

import bastian_sanhueza_jhony_vargas.JSystem;

public class App {

    Scanner scan = new Scanner(System.in);
    String[][] matriz;

    int maximo = 20;
    String medidas;
    String medidasG;
    String medidasR;
    int columnas;
    int filas;
    int por = 0;
    int cantidadGato;
    int cantidadRaton;
    int numG;
    int numR;
    int numM;
    boolean continuar = true;

    public void principal() {
        crearMatriz();

    }

    public void crearMatriz() {
        System.out.println("ingrese ancho y largo de la pieza con el siguiente formato(x,x)");
        medidas = scan.nextLine();
        String[] posiciones = medidas.split(",");

        columnas = Integer.parseInt(posiciones[0]);
        filas = Integer.parseInt(posiciones[1]);
        validar(columnas, filas);

        matriz = new String[columnas][filas];
        matriz[0][0] = new String(" f/c");
        rellenar(matriz);
        crearRatones(cantidadRaton);
        crearGatos(cantidadGato);
        int op;
        boolean continuar=true;
        while(continuar){
            crearMueble();
            mostrar();
            System.out.println("continuar 1.si / 2.no");
            
            op = Integer.parseInt(scan.nextLine());
            if(op==2){
                continuar=false;
            }
        } 
        
    }

    public void validar(int c, int f) {
        while (true) {
            if (c > maximo || f > maximo) {
                if (c > maximo) {
                    System.out.println("el primer valor:" + c + "->es mayor que 20 ingrese un numero menor");
                } else {
                    System.out.println("el segundo valor:" + f + "->es mayor que 20 ingrese un numero menor");
                }
                System.out.println("---------------------------------------------------------------");
                System.out.println("ingrese ancho y largo de la pieza con el siguiente formato(x,x)");
                medidas = scan.nextLine();
                String[] posiciones = medidas.split(",");
                c = Integer.parseInt(posiciones[0]);
                f = Integer.parseInt(posiciones[1]);

            } else {
                por = c * f;
                cantidadGato = (10 * por) / 100;
                cantidadRaton = (25 * por) / 100;
                break;
            }

        }

    }

    public void rellenar(String[][] m) {
        for (int x = 0; x < matriz.length; x++) {

            for (int y = 0; y < matriz[x].length; y++) {

                if (y == 0 && x != 0) {

                    matriz[x][y] = new String(" " + y + x + " ");

                }
                if (y != 0 && x == 0) {

                    matriz[0][y] = new String(" " + x + y + " ");

                }
                if (y != 0 && x != 0) {
                    matriz[x][y] = new String("  - ");

                }

                System.out.print(matriz[x][y]);

            }

            System.out.println("");

        }
        System.out.println("usted puede ingresar " + cantidadRaton + " ratones y" + cantidadGato + " gatos");

    }

    public void pedirDatos() {
        while (continuar) {
            System.out.println("ingrese  cantidad de ratones");
            numR = Integer.parseInt(scan.nextLine());
            while (true) {
                if (numR > cantidadRaton) {
                    System.out.println("ingrese  cantidad de ratones validas");
                    numR = Integer.parseInt(scan.nextLine());
                } else {
                    break;
                }
            }

        }

    }

    public void crearRatones(int r) {
        int contador = 1;
        int opcion = 1;
        System.out.println("cuanto ratones colocara ?>>");
        int respuesta = Integer.parseInt(scan.nextLine());
        while (true) {
            if (respuesta > cantidadRaton) {
                JSystem.out.printColor(JSystem.Color.red, "la cantidad de ratones tiene que ser menor que :" + cantidadRaton);
                System.out.println("cuanto ratones colocara ?>>");
                respuesta = Integer.parseInt(scan.nextLine());
            } else {
                break;
            }
        }
        while (contador <= respuesta) {
            System.out.println("ingrese posicion del raton:" + contador + " en la pieza con el siguiente formato(x,x)");
            medidasR = scan.nextLine();
            String[] posicionR = medidasR.split(",");
            int columnaR = Integer.parseInt(posicionR[0]);
            int filaR = Integer.parseInt(posicionR[1]);
            if (filaR > 1 || columnaR > 1) {
                if (contador == 1) {
                    matriz[columnaR][filaR] = "  R ";
                }
                if (contador > 1) {
                    if (matriz[columnaR][filaR].equals("  - ")) {
                        matriz[columnaR][filaR] = "  R ";
                        System.out.println("se a Agregado");
                        System.out.println("-------------------------------------------");

                    } else {
                        JSystem.out.printColor(JSystem.Color.red, " ya se encuentra un Raton en esta posicion[" + columnaR + "," + filaR + "] \n");
                        System.out.println("-------------------------------------------");
                        contador--;

                    }

                }
                mostrar();
                contador++;

            }else{
                 JSystem.out.printColor(JSystem.Color.red, " ya se encuentra un Raton en esta posicion[" + columnaR + "," + filaR + "] \n");
                        System.out.println("-------------------------------------------");
                        contador--;

            }

        }

    }

    public void crearGatos(int g) {
        int contador = 1;
        int opcion = 1;
        System.out.println("cuanto Gatos colocara ?>>");
        int respuesta = Integer.parseInt(scan.nextLine());
        while (true) {
            if (respuesta > cantidadGato) {
                JSystem.out.printColor(JSystem.Color.red, "la cantidad de gatos tiene que ser menor que :" + cantidadGato);
                System.out.println("cuanto gatos colocara ?>>");
                respuesta = Integer.parseInt(scan.nextLine());
            } else {
                break;
            }
        }
        while (contador <= respuesta) {
            System.out.println("ingrese posicion del gato:" + contador + " en la pieza con el siguiente formato(x,x)");
            medidasR = scan.nextLine();
            String[] posicionG = medidasR.split(",");
            int columnaG = Integer.parseInt(posicionG[0]);
            int filaG = Integer.parseInt(posicionG[1]);
            if (filaG > 1 || columnaG > 1) {

                if (contador > 1) {
                    if (matriz[columnaG][filaG].equals("  - ")) {
                        matriz[columnaG][filaG] = "  G ";
                        System.out.println("se a Agregado");
                        System.out.println("-------------------------------------------");

                    } else {
                        if (matriz[columnaG][filaG].equals("  R ")) {
                            JSystem.out.printColor(JSystem.Color.red, " ya se encuentra un Raton en esta posicion[" + columnaG + "," + filaG + "] \n");
                        } else {
                            JSystem.out.printColor(JSystem.Color.red, " ya se encuentra un GATO en esta posicion[" + columnaG + "," + filaG + "] \n");

                        }

                        System.out.println("-------------------------------------------");
                        contador--;

                    }

                }else{
                     if (matriz[columnaG][filaG].equals("  R ")) {
                            JSystem.out.printColor(JSystem.Color.red, " ya se encuentra un Raton en esta posicion[" + columnaG + "," + filaG + "] \n");
                        } else {
                            JSystem.out.printColor(JSystem.Color.red, " ya se encuentra un GATO en esta posicion[" + columnaG + "," + filaG + "] \n");

                        }

                        System.out.println("-------------------------------------------");
                        contador--;
                
                }
                mostrar();
                contador++;

            }

        }

    }

    public void mostrar() {
        for (int x = 0; x < matriz.length; x++) {

            for (int y = 0; y < matriz[x].length; y++) {
                System.out.print(matriz[x][y]);

            }
            System.out.println("");

        }
    }

    public void crearMueble() {

        String cordaadaMuebleI = "";
        String cordnadayMuebleF = "";
        String respuesta;
        System.out.println("posicion inicial del mueble");
        cordaadaMuebleI = scan.nextLine();
        String[] posicionM = cordaadaMuebleI.split(",");
        int columna1 = Integer.parseInt(posicionM[0]);
        int fila1 = Integer.parseInt(posicionM[1]);
        System.out.println("posicion Final del mueble");
        cordnadayMuebleF = scan.nextLine();
        String[] posicionMF = cordnadayMuebleF.split(",");
        int columna2 = Integer.parseInt(posicionMF[0]);
        int fila2 = Integer.parseInt(posicionMF[1]);
        boolean activo = true;

//        if (columna1 > columna2) {
        for (int x = columna1; x <= columna2; x++) {

            if (activo) {
                for (int y = fila1; y <= fila2; y++) {
                    if (matriz[x][y].equals("  - ")) {

                    } else {

                        activo = false;

                    }

                }

            }

        }
        if (activo) {
            for (int x = columna1; x <= columna2; x++) {

                for (int y = fila1; y <= fila2; y++) {
                    matriz[x][y] = new String(" " + " M" + " ");

                }

            }
        } else {
            JSystem.out.printColor(JSystem.Color.red, " ya se encuentra  un elemento dentro de este rango \n");
            System.out.println("-------------------------------------------");
        }

    }



}
