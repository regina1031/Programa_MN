import org.apache.commons.math3.stat.regression.SimpleRegression;

import java.util.ArrayList;
import java.util.Scanner;

public class regresionSimple {

    private static final Scanner scn = new Scanner(System.in);
    public static String menu =
            """
            \nMenú:
            1. Ingresar datos
            2. Imprimir ecuación de la recta
            3. Predecir con la ecuacion
            4. Borrar datos
            5. Salir
           \s
            Escoja una opción:\s""";

    public static double[] regresionLineal(ArrayList<Double> x, ArrayList<Double> y){
        SimpleRegression regression = new SimpleRegression();

        for (int i = 0; i < x.size(); i++) {
            regression.addData(x.get(i), y.get(i));
        }

        double slope = regression.getSlope();
        double intercept = regression.getIntercept();

        return new double[]{slope, intercept};
    }

    private static void llenarArreglo(ArrayList<Double> x, ArrayList<Double> y, int n){
        System.out.println("\nIngrese los valores para x: ");
        for (int i = 0; i < n; i++) {
            x.add(scn.nextDouble());
        }

        System.out.println("Ingrese los valores para y: ");
        for (int i = 0; i < n; i++) {
            y.add(scn.nextDouble());
        }
    }

    private static void imprimirArreglo(ArrayList<Double> x, ArrayList<Double> y){
        System.out.println("\nDatos registrados: ");

        System.out.print(" * x: ");
        for (double v : x) {
            System.out.print(v + ", ");
        }
        System.out.print("\n * y: ");
        for (double v : y) {
            System.out.print(v + ", ");
        }
        System.out.println();
    }

    private static void calcularPrediccion(double[] coeficientes, double x){
        double y = coeficientes[0] * x + coeficientes[1];
        System.out.printf(" * resultado: %.2f \n", y);
    }

    public static void menu(){
        int opcion, n;
        ArrayList<Double> x = new ArrayList<>(), y = new ArrayList<>();
        double[] coeficientes = null;

        String nota = """
                \nNotas:
                Antes de realizar cualquier operación es necesario:
                - ingresar los datos de x y y.
                - saber que la cantidad ingresada en '#Numero de muestras' aplica tanto para x como para y
                  Y deben llenadas y no saltarse\s""";
        System.out.println(nota);

        do {
            System.out.print(menu);
            opcion = scn.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print(" # Numero de muestras: ");
                    n = scn.nextInt();
                    llenarArreglo(x, y, n);
                    imprimirArreglo(x, y);
                    coeficientes = regresionLineal(x, y);
                    break;
                case 2:
                    if (x.isEmpty() || y.isEmpty()) {
                        System.out.println(" * No hay datos para calcular la regresión lineal");
                        break;
                    }
                    System.out.printf(" \n La ecuación de la recta con los datos actuales, es:\n  y = %.2f x + %.2f \n", coeficientes[0], coeficientes[1]);
                    break;
                case 3:
                    if (x.isEmpty() || y.isEmpty()) {
                        System.out.println(" * No hay datos para calcular la regresión lineal");
                        break;
                    }
                    System.out.print("\n Ingrese el valor de x para predecir: ");
                    double x_p = scn.nextDouble();
                    calcularPrediccion(coeficientes, x_p);
                    break;
                case 4:
                    x.clear();
                    y.clear();
                    System.out.println(" * Datos borrados");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;

            }
        } while (opcion != 5);
    }
}