import java.util.Scanner;
public class GaussSeidel {

    static final double TOLERANCE = 0.0001;
    static final int MAX_ITERATIONS = 10;

    static Scanner teclado = new Scanner(System.in);
    public static void GaussSeidel() {
        double[][] coefficients = new double[3][3];


        double[] constants = new double[3];

        System.out.println("ingrese los datos de la matriz 3x3");
        for (int i=0;i < 3; i++){
            for (int j=0;j<3;j++){
                coefficients[i][j]= teclado.nextDouble();
            }

        }
        System.out.println("ingrese los resultados de cada fila");
        for(int f=0;f<3;f++){
            constants[f]= teclado.nextDouble();
        }
        solve(coefficients, constants);
    }

    public static void solve(double[][] coefficients, double[] constants) {
        int n = constants.length;
        double[] solucion = new double[n];
        double[] previousSolution = new double[n];

        int iteration = 0;
        while (iteration < MAX_ITERATIONS) {
            System.arraycopy(solucion, 0, previousSolution, 0, n);

            System.out.println("Iteraccion " + iteration + ":");
            for (int i = 0; i < n; i++) {
                double sum = constants[i];
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum -= coefficients[i][j] * solucion[j];
                    }
                }
                solucion[i] = sum / coefficients[i][i];
                System.out.println("x[" + i + "] = " + solucion[i]);
            }

            if (converged(solucion, previousSolution)) {
                break;
            }

            iteration++;
        }
    }

    public static boolean converged(double[] current, double[] previous) {
        for (int i = 0; i < current.length; i++) {
            if (Math.abs(current[i] - previous[i]) > TOLERANCE) {
                return false;
            }
        }
        return true;
    }
}
