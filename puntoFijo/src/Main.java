import com.singularsys.jep.JepException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws JepException {
        Scanner UA = new Scanner(System.in);
        int a;
        do{
            menuP();
            a = UA.nextInt();
            switch (a){
                case 1:
                    do {
                        menuT1();
                        a = UA.nextInt();
                        switch (a){
                            case 1:
                                NumeroSignificativo.NumeroSignificativo(); //Equipo de Regina
                                break;
                            case 2:
                                PrecisionOExactitud.PrecisionOExactitud(); //Equipo de Andrej
                                break;
                            case 3:
                                ErrorAbsoluto.menu1(); //Equipo de Felipe
                                break;
                            case 4:
                                System.out.println("Regresara al menu principal");
                                break;
                            default:
                                System.out.println("Ingreso una opcion incorrecta");
                                break;
                        }
                    } while (a != 4);
                    break;
                case 2:
                    do {
                        menuT2();
                        a = UA.nextInt();
                        switch (a){
                            case 1:
                                PuntoFijo.PuntoFijo(); //Equipo de Andrej
                                break;
                            case 2:
                                MenuBiseccion.menu2(); //Equipo de Felipe
                                break;
                            case 3:
                                Polynom.Polynom(); //Equipo de Alicia
                                break;
                            case 4:
                                System.out.println("Regresara al menu principal");
                                break;
                            default:
                                System.out.println("Ingreso una opcion incorrecta");
                                break;
                        }
                    } while (a != 4);
                    break;
                case 3:
                    do {
                        menuT3();
                        a = UA.nextInt();
                        switch (a){
                            case 1:
                                Jacobi.Jacobi(); //Equipo de Andrej
                                break;
                            case 2:
                                GaussSeidel.GaussSeidel(); //Equipo de Cristian
                                break;
                            case 3:
                                System.out.println("Regresara al menu principal");
                                break;
                            default:
                                System.out.println("Ingreso una opcion incorrecta");
                                break;
                        }
                    } while (a != 3);
                    break;
                case 4:
                    do {
                        menuT4();
                        a = UA.nextInt();
                        switch (a){
                            case 1:
                                ReglaSimpson.ReglaSimpson(); //Equipo de Regina
                                break;
                            case 2:
                                ReglaTrapecio.ReglaTrapecio(); //Equipo de Nuria
                                break;
                            case 3:
                                System.out.println("Regresara al menu principal");
                                break;
                            default:
                                System.out.println("Ingreso una opcion incorrecta");
                                break;
                        }
                    } while (a != 3);
                    break;
                case 5:
                    do {
                        menuT5();
                        a = UA.nextInt();
                        switch (a){
                            case 1:
                                NewtonInterpolacion.NewtonInterpolation(); //Equipo de Andrej
                                break;
                            case 2:
                                LagrangeInterpolation.LagrangeInterpolation(); //Equipo de Alvin
                                break;
                            case 3:
                                regresionSimple.menu(); //Equipo de Felipe
                                break;
                            case 4:
                                MinimosCuadrados.MinimosCuadrados(); //Equipo de Nuria
                                break;
                            case 5:
                                System.out.println("Regresara al menu principal");
                                break;
                            default:
                                System.out.println("Ingreso una opcion incorrecta");
                                break;
                        }
                    } while (a != 5);
                    break;
                case 6:
                    do {
                        menuT6();
                        a = UA.nextInt();
                        switch (a){
                            case 1:
                                EulerAproxDiferencial.EulerAproxDiferencial(); //Equipo de Andrej
                                break;
                            case 2:
                                TaylorSeries.TaylorSeries(); //Equipo de Cristian
                                break;
                            case 3:
                                AdamsBashforth.AdamsBashforth(); //Equipo de Regina
                                break;
                            case 4:
                                System.out.println("Regresara al menu principal");
                                break;
                            default:
                                System.out.println("Ingreso una opcion incorrecta");
                                break;
                        }
                    } while (a != 4);
                    break;
                case 7:
                    System.out.println("Gracias por usar nuestro programa");
                    break;
                default:
                    System.out.println("Ingreso una opcion incorrecta");
            }
        } while (a != 7);
    }
    public static void menuP(){
        System.out.println("1. Metodos del Primer Tema");
        System.out.println("2. Metodos del Segundo Tema");
        System.out.println("3. Metodos del Tercer Tema");
        System.out.println("4. Metodos del Cuarto Tema");
        System.out.println("5. Metodos del Quinto Tema");
        System.out.println("6. Metodos del Sexto Tema");
        System.out.println("7. Salir");
    }
    public static void menuT1(){
        System.out.println("1. Numero Significativo");
        System.out.println("2. Precision o Exactitud");
        System.out.println("3. Error Absoluto");
        System.out.println("4. Regresar");
    }
    public static void menuT2(){
        System.out.println("1. Punto Fijo");
        System.out.println("2. Metodo de Biseccion");
        System.out.println("3. Interpolacion de Newton");
        System.out.println("4. Regresar");
    }
    public static void menuT3(){
        System.out.println("1. Metodo de Jacobi");
        System.out.println("2. Metodo de Gauss-Seidel");
        System.out.println("3. Regresar");
    }
    public static void menuT4(){
        System.out.println("2. Metodo de Simpson");
        System.out.println("2. Metodo del Trapecio");
        System.out.println("3. Regresar");
    }
    public static void menuT5(){
        System.out.println("1. Interpolacion de Newton");
        System.out.println("2. Interpolacion de Lagrange");
        System.out.println("3. Regresion Lineal");
        System.out.println("4. Minimos Cuadrados");
        System.out.println("5. Regresar");

    }
    public static void menuT6(){
        System.out.println("1. Metodo de Euler (Un paso)");
        System.out.println("2. Metodo de Taylor (Un paso)");
        System.out.println("3. Metodo de Adams-Bashforth(Pasos multiples");
        System.out.println("4. Regresar");
    }
}
