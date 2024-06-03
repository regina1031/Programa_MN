import java.util.Scanner;

public class TaylorSeries {

    // Método para calcular el factorial de un número
    public static double factorial(int n) {
        double result = 1.0;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Método para calcular la serie de Taylor para e^x y mostrar los pasos
    public static void taylorExponential(double x, int terms) {
        double sum = 1.0;  // e^0 = 1
        System.out.println("Paso 1: e^0 = 1.0");
        for (int i = 1; i < terms; i++) {
            double term = Math.pow(x, i) / factorial(i);
            sum += term;
            System.out.println("Paso " + (i + 1) + ": " + sum + " (sumando " + term + ")");
        }
    }

    public static void TaylorSeries() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor de x para e^x: ");
        double x = scanner.nextDouble();

        System.out.print("Ingrese el número de términos de la serie de Taylor: ");
        int terms = scanner.nextInt();

        System.out.println("Pasos para calcular e^" + x + " usando " + terms + " términos de la serie de Taylor:");
        taylorExponential(x, terms);

        scanner.close();
    }
}
