import java.util.Scanner;
public class Jacobi {
    static Scanner UA = new Scanner(System.in);
    public static void Jacobi(){
        double[][] matO = new double[3][4];
        double[][] matD = new double[3][3];
        double[][] valI = new double[3][1];
        double[][] matLU = new double[3][3];
        double[][] matEcuacion = new double[3][3];
        double xN = 0, xV = 0, yN = 0, yV = 0, zN = 0, zV = 0, errorD;
        int iteracion = 0;
        for(int i = 0; i < 3; i++){
            System.out.println("Llene los valores de la ecuacion #" + (i+1));
            for(int j = 0; j < 4; j++){
                matO[i][j] = UA.nextDouble();
                if (j == i){
                    matD[i][j] = 1/matO[i][j];
                    matLU[i][j] = 0;
                }
                if (j != i && j < 3){
                    matLU[i][j] = -matO[i][j];
                    matD[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (i == j) {
                    valI[i][0] = matD[i][j] * matO[i][3];
                    if (i == 0){
                        xV = valI[i][0];
                    } else if (i == 1){
                        yV = valI[i][0];
                    } else {
                        zV = valI[i][0];
                    }
                }
                if (i != j){
                    matEcuacion[i][j] = matD[i][i] * matLU[i][j];
                }
            }
        }
        System.out.println("Cual es su margen de error deseado?");
        errorD = UA.nextDouble();
        boolean ver = false;
        for (int i = 0; i < 100; i++){
            if (i == 0){
                iteracion++;
            } else {
                xN = valI[0][0] + matEcuacion[0][1] * yV + matEcuacion[0][2] * zV;
                yN = valI[1][0] + matEcuacion[1][0] * xV + matEcuacion[1][2] * zV;
                zN = valI[2][0] + matEcuacion[2][0] * xV + matEcuacion[2][1] * yV;
                iteracion++;
                if ((xN-xV)/xN <= errorD && (yN-yV)/yN <= errorD && (zN-zV)/zN <= errorD){
                    ver = true;
                }
                xV = xN;
                yV = yN;
                zV = zN;
            }
            if (ver){
                break;
            }
        }
        System.out.println("Los valores aproximados con un marge de error del " + errorD*100 + "% son despues de " + iteracion + " iteraciones son:");
        System.out.println("x: " + xN);
        System.out.println("y: " + yN);
        System.out.println("z: " + zN);
    }
}
