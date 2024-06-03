import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

public class ReglaSimpson {

    public static double integrar(DoubleUnaryOperator f, double a, double b, int n) {
        if (n % 2 != 0) {
            throw new IllegalArgumentException("El número de intervalos (n) debe ser par.");
        }
        double h = (b - a) / n;
        double suma = f.applyAsDouble(a) + f.applyAsDouble(b);

        for (int i = 1; i < n; i += 2) {
            double x = a + i * h;
            suma += 4 * f.applyAsDouble(x);
        }

        for (int i = 2; i < n - 1; i += 2) {
            double x = a + i * h;
            suma += 2 * f.applyAsDouble(x);
        }

        return suma * h / 3;
    }

    public static void ReglaSimpson() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el límite inferior del intervalo:");
        double a = scanner.nextDouble();

        System.out.println("Ingrese el límite superior del intervalo:");
        double b = scanner.nextDouble();

        System.out.println("Ingrese el número de intervalos (debe ser par):");
        int n = scanner.nextInt();

        if (n % 2 != 0) {
            System.out.println("El número de intervalos (n) debe ser par.");
            return;
        }

        DoubleUnaryOperator funcion = x -> Math.exp(x * x); // Función a integrar, e^x^2

        double resultado = integrar(funcion, a, b, n);
        System.out.println("El resultado de la integral es: " + resultado);

        scanner.close();
    }
}