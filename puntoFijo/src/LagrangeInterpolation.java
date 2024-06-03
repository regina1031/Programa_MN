import java.util.Scanner;

public class LagrangeInterpolation {

    // Método para calcular el polinomio de interpolación de Lagrange
    public static double lagrangeInterpolation(double[] x, double[] y, double xp) {
        int n = x.length;
        double yp = 0.0;

        for (int i = 0; i < n; i++) {
            double li = 1.0;

            for (int j = 0; j < n; j++) {
                if (j != i) {
                    li *= (xp - x[j]) / (x[i] - x[j]);
                }
            }

            yp += li * y[i];
        }

        return yp;
    }

    public static void LagrangeInterpolation() {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de puntos
        System.out.print("Ingrese el número de puntos: ");
        int n = scanner.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        // Leer los puntos
        System.out.println("Ingrese los valores de x y y:");
        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "] = ");
            x[i] = scanner.nextDouble();
            System.out.print("y[" + i + "] = ");
            y[i] = scanner.nextDouble();
        }

        // Leer el punto donde se quiere evaluar el polinomio
        System.out.print("Ingrese el punto para evaluar el polinomio (xp): ");
        double xp = scanner.nextDouble();

        // Calcular el valor del polinomio de Lagrange en xp
        double yp = lagrangeInterpolation(x, y, xp);

        // Mostrar el resultado
        System.out.println("El valor del polinomio de interpolación de Lagrange en x = " + xp + " es y = " + yp);

        scanner.close();
    }
}

