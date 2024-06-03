import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.Scanner;

public class EulerAproxDiferencial {
    // Metodo que repesenta la ecuacion diferencial dy/xd = f(x,y)
    public static double f(Expression expresion, double x, double y) {
        // Establecer los variables como 'x' y 'y'
        expresion.setVariable("x", x);
        expresion.setVariable("y", y);

        // Evaluar la expresion
        return expresion.evaluate();
    }

    // Metodo para evaluar el metodo de euler
    public static double[] metodoEuler(Expression expresion, double x0, double y0, double xn, int n) {
        double h = (xn - x0) / n; // Calcular el tamaño de los saltos
        double[] y = new double[n + 1]; // Arreglo para almacenar los valores de y
        double[] x = new double[n + 1]; // Arreglo para almacenar los valores de x

        y[0] = y0; // Valor inicial de y
        x[0] = x0; // Valor inicial de x

        for (int i = 1; i <= n; i++) {
            y[i] = y[i - 1] + h * f(expresion, x[i - 1], y[i - 1]); // Se aplica el metodo de Euler
            x[i] = x[i - 1] + h; // Se incrementa x por el tamaño del salto
        }

        return y; // Se retorna el valor del arreglo de los valoes de y
    }

    public static void EulerAproxDiferencial() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la ecuacion diferencial en terminos de 'x' y 'y' (ejemplo, x + y): ");
        String equacion = scanner.nextLine();

        System.out.print("Ingrese el valor inicial de x (x0): ");
        double x0 = scanner.nextDouble();

        System.out.print("Ingrese el valor inicial de y (y0): ");
        double y0 = scanner.nextDouble();

        System.out.print("Ingrese el valor final de x (xn): ");
        double xn = scanner.nextDouble();

        System.out.print("Ingrese la cantidad de pasos (n): ");
        int n = scanner.nextInt();

        try {
            // Se crea la expresion de el dato ingresado por el usuario
            Expression expresion = new ExpressionBuilder(equacion)
                    .variables("x", "y")
                    .build();

            double[] resultado = metodoEuler(expresion, x0, y0, xn, n);

            // Se imprimen los reslutados
            System.out.println("x\t\ty");
            for (int i = 0; i <= n; i++) {
                double x = x0 + i * (xn - x0) / n;
                System.out.printf("%.4f\t%.4f\n", x, resultado[i]); //"%.4f\t%.4f\n" indica como se imprimiran los floats
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al evaluar la ecuacion");
        }

    }
}
