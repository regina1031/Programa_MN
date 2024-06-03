import java.util.Scanner;

class Polynom {
    static final double EPS = 1e-8;
    double p[];

    Polynom(double a[]) {
        p = (double[]) a.clone();
        reduce();
    }

    void reduce() {
        int size;
        for (size = p.length - 1; size > 0 && Math.abs(p[size]) < EPS; size--) ;
        if (++size < p.length) {
            double q[] = new double[size];
            System.arraycopy(p, 0, q, 0, size);
            p = q;
        }
    }

    Polynom add(Polynom b) {
        int n = Math.max(this.p.length, b.p.length);
        double q[] = new double[n];
        for (int i = 0; i < n; i++) {
            if (i < this.p.length) q[i] += this.p[i];
            if (i < b.p.length) q[i] += b.p[i];
        }
        return new Polynom(q);
    }

    Polynom multiply(Polynom b) {
        double q[] = new double[this.p.length + b.p.length - 1];
        for (int i = 0; i < this.p.length; i++)
            for (int j = 0; j < b.p.length; j++)
                q[i + j] += this.p[i] * b.p[j];
        return new Polynom(q);
    }

    public static double[] newton(double f[], double x[]) {
        Polynom r = new Polynom(new double[]{f[0]});
        int n = f.length;
        double a[][] = new double[n][n];
        for (int i = 0; i < n; i++) a[0][i] = f[i];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++)
                a[i][j] = (a[i - 1][j + 1] - a[i - 1][j]) / (x[j + i] - x[j]);
            Polynom m = new Polynom(new double[]{a[i][0]});
            for (int j = 0; j < i; j++) {
                m = m.multiply(new Polynom(new double[]{-x[j], 1}));
            }
            r = r.add(m);
        }
        return r.p;
    }

    public static void Polynom() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de coeficientes del primer polinomio: ");
        int n = scanner.nextInt();
        double[] coeficientes1 = new double[n];
        System.out.println("Ingrese los coeficientes del primer polinomio, empezando desde el término constante:");
        for (int i = 0; i < n; i++) {
            coeficientes1[i] = scanner.nextDouble();
        }

        System.out.print("Ingrese el número de coeficientes del segundo polinomio: ");
        int m = scanner.nextInt();
        double[] coeficientes2 = new double[m];
        System.out.println("Ingrese los coeficientes del segundo polinomio, empezando desde el término constante:");
        for (int i = 0; i < m; i++) {
            coeficientes2[i] = scanner.nextDouble();
        }

        Polynom polinomio1 = new Polynom(coeficientes1);
        Polynom polinomio2 = new Polynom(coeficientes2);

        System.out.println("Polinomio 1: " + java.util.Arrays.toString(polinomio1.p));
        System.out.println("Polinomio 2: " + java.util.Arrays.toString(polinomio2.p));

        Polynom suma = polinomio1.add(polinomio2);
        Polynom producto = polinomio1.multiply(polinomio2);

        System.out.println("Suma: " + java.util.Arrays.toString(suma.p));
        System.out.println("Producto: " + java.util.Arrays.toString(producto.p));

        System.out.println("Ingrese el número de puntos para la interpolación de Newton: ");
        int numPuntos = scanner.nextInt();
        double[] valoresF = new double[numPuntos];
        double[] valoresX = new double[numPuntos];

        System.out.println("Ingrese los valores de f(x) para la interpolación, uno por uno: ");
        for (int i = 0; i < numPuntos; i++) {
            valoresF[i] = scanner.nextDouble();
        }

        System.out.println("Ingrese los valores de x para la interpolación, uno por uno: ");
        for (int i = 0; i < numPuntos; i++) {
            valoresX[i] = scanner.nextDouble();
        }

        double[] interpolacionNewton = Polynom.newton(valoresF, valoresX);
        System.out.println("Interpolación de Newton: " + java.util.Arrays.toString(interpolacionNewton));

    }
}