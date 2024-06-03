import java.util.Scanner;

public class AdamsBashforth {


    public static double f(double x, double y) {
        return x - y;
    }

    public static void adamsBashforth(double x0, double y0, double h, int n) {
        double[] x = new double[n + 1];
        double[] y = new double[n + 1];

        x[0] = x0;
        y[0] = y0;

        x[1] = x[0] + h;
        y[1] = y[0] + h * f(x[0], y[0]);

        for (int i = 1; i < n; i++) {
            x[i + 1] = x[i] + h;
            y[i + 1] = y[i] + h / 2 * (3 * f(x[i], y[i]) - f(x[i - 1], y[i - 1]));
        }

        for (int i = 0; i <= n; i++) {
            System.out.printf("x[%d] = %.5f, y[%d] = %.5f%n", i, x[i], i, y[i]);
        }
    }

    public static void AdamsBashforth() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor inicial de x (x0): ");
        double x0 = scanner.nextDouble();

        System.out.print("Ingrese el valor inicial de y (y0): ");
        double y0 = scanner.nextDouble();

        System.out.print("Ingrese el tamaño del paso (h): ");
        double h = scanner.nextDouble();

        System.out.print("Ingrese el número de pasos (n): ");
        int n = scanner.nextInt();

        adamsBashforth(x0, y0, h, n);

        scanner.close();
    }
}
