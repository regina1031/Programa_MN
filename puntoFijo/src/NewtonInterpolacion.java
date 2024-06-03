import java.util.Scanner;

public class NewtonInterpolacion {
    // Método para calcular las diferencias divididas
    public static double[] calcularDiferenciasDivididas(double[] x, double[] y) {
        int n = x.length;
        double[][] diferenciasDivididas = new double[n][n];

        // Copiar y a la primera columna de diferenciasDivididas
        for (int i = 0; i < n; i++) {
            diferenciasDivididas[i][0] = y[i];
        }

        // Calcular las diferencias divididas
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                diferenciasDivididas[i][j] = (diferenciasDivididas[i + 1][j - 1] - diferenciasDivididas[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        // Extraer los coeficientes de las diferencias divididas
        double[] coeficientes = new double[n];
        for (int i = 0; i < n; i++) {
            coeficientes[i] = diferenciasDivididas[0][i];
        }

        return coeficientes;
    }

    // Método para evaluar el polinomio de Newton
    public static double evaluarPolinomio(double[] coeficientes, double[] x, double valor) {
        int n = coeficientes.length;
        double resultado = coeficientes[0];
        double producto = 1.0;

        for (int i = 1; i < n; i++) {
            producto *= (valor - x[i - 1]);
            resultado += coeficientes[i] * producto;
        }

        return resultado;
    }
    public static void NewtonInterpolation() {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de puntos
        System.out.print("Ingrese el número de puntos: ");
        int n = scanner.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        // Leer los puntos
        System.out.println("Ingrese los puntos (x y): ");
        for (int i = 0; i < n; i++) {
            System.out.print("x" + i + ": ");
            x[i] = scanner.nextDouble();
            System.out.print("y" + i + ": ");
            y[i] = scanner.nextDouble();
        }

        // Calcular los coeficientes del polinomio interpolante
        double[] coeficientes = calcularDiferenciasDivididas(x, y);

        // Mostrar el polinomio interpolante
        System.out.println("Polinomio interpolante de Newton:");
        System.out.print("P(x) = ");
        for (int i = 0; i < coeficientes.length; i++) {
            if (i > 0) {
                System.out.print(" + ");
            }
            System.out.print(coeficientes[i]);
            for (int j = 0; j < i; j++) {
                System.out.print("(x - " + x[j] + ")");
            }
        }
        System.out.println();

        // Evaluar el polinomio en un punto dado
        System.out.print("Ingrese el valor de x para evaluar el polinomio: ");
        double valor = scanner.nextDouble();
        double resultado = evaluarPolinomio(coeficientes, x, valor);
        System.out.println("P(" + valor + ") = " + resultado);

    }
}
