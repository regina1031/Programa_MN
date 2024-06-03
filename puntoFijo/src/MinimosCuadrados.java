import java.util.Scanner;

/**
 *
 * @author Dilan Antonio
 */
public class MinimosCuadrados {

    public static void MinimosCuadrados() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el numero de puntos de datos: ");
        int n = scanner.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        System.out.println("Ingrese los valores de x e y: ");
        for (int i = 0; i < n; i++) {
            System.out.print("x[" + (i+1) + "]: ");
            x[i] = scanner.nextDouble();
            System.out.print("y[" + (i+1) + "]: ");
            y[i] = scanner.nextDouble();
        }

        // Calcular las sumas necesarias
        double sumX = 0, sumY = 0, sumXY = 0, sumXX = 0;
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumXX += x[i] * x[i];
        }

        // Calcular la pendiente (m) y la intersección (b)
        double m = (n * sumXY - sumX * sumY) / (n * sumXX - sumX * sumX);
        double b = (sumY - m * sumX) / n;

        // Mostrar la ecuación de la línea de ajuste
        System.out.println("La ecuacion de la linea de ajuste es: y = " + m + "x + " + b);

    }
}