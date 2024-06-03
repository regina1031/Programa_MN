import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Scanner;
import java.util.function.Function;

public class ReglaTrapecio {

    public static void ReglaTrapecio() {
        Scanner scanner = new Scanner(System.in);

        // Pedir la función al usuario
        System.out.println("Ingrese la función a integrar (por ejemplo, 'x^2' para x al cuadrado):");
        String funcionStr = scanner.nextLine();
        Function<Double, Double> funcion = x -> evaluarFuncion(funcionStr, x);

        // Pedir los límites de integración
        System.out.println("Ingrese el límite inferior de integración (a):");
        double a = scanner.nextDouble();
        System.out.println("Ingrese el límite superior de integración (b):");
        double b = scanner.nextDouble();

        // Pedir el número de trapecios
        System.out.println("Ingrese el número de trapecios a utilizar:");
        int n = scanner.nextInt();

        // Calcular el valor de la integral usando la regla del trapecio
        double resultado = reglaDelTrapecio(funcion, a, b, n);

        // Mostrar el resultado
        System.out.println("El resultado de la integral es: " + resultado);

        scanner.close();
    }

    // Método para evaluar la función en un punto dado
    private static double evaluarFuncion(String funcionStr, double x) {
        Expression expression = new ExpressionBuilder(funcionStr)
                .variables("x")
                .build();
        expression.setVariable("x", x);
        return expression.evaluate();
    }

    // Implementación de la regla del trapecio
    private static double reglaDelTrapecio(Function<Double, Double> funcion, double a, double b, int n) {
        double h = (b - a) / n;
        double suma = 0.5 * (funcion.apply(a) + funcion.apply(b));
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            suma += funcion.apply(x);
        }
        return h * suma;
    }
}