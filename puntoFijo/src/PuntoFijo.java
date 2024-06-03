import com.singularsys.jep.JepException;
import org.nfunk.jep.JEP;

import java.util.Scanner;
public class PuntoFijo {
    static Scanner UA = new Scanner(System.in);
    public static void PuntoFijo() throws JepException {
        //System.out.println("Ingrese su funcion");
        double x = 0, x1 = 0, e = 0, ed, funci, funci2;
        int c = 1;
        JEP myParser = new JEP();
        //String func = UA.next();
        //UA.nextLine();
        /*System.out.println("Ingrese la nueva funcion g(x)");
        String funcGX = UA.next();
        *///UA.nextLine();
        System.out.println("Ingrese la funcion inicial");
        String fug = UA.next();
        UA.nextLine();
        myParser.addVariable("x", x);
        myParser.parseExpression(fug);
        System.out.println("Ingrese la segunda funcion");
        String fug2 = UA.next();
        UA.nextLine();
        System.out.println("Ingrese el valor inicial de la funcion");
        x = UA.nextDouble();
        System.out.println("Ingrese el error deseado");
        ed = UA.nextDouble();
        for (int i = 0; i < 100; i++){
            if (i == 0){
                x1 = x;
                //System.out.println("Valor de f(x) en " + x + Parser.evaluar(func, x));
                myParser.addVariable("x", x);
                myParser.parseExpression(fug2);
                System.out.println("Valor de g(x) en " + x + ": " + myParser.getValue());
                x = myParser.getValue();
                myParser.addVariable("x", x);
            } else {
                myParser.addVariable("x", x);
                System.out.println("Valor de g(x) en " + x + ": " + myParser.getValue());
                x = myParser.getValue();
                myParser.addVariable("x", x1);
                x1 = myParser.getValue();
                e = Math.abs((x-x1)/x);
                if (e <= ed){
                    System.out.println("El error despues de " + i + " iteraciones es " + e);
                    System.out.println("La raiz aproximada de f(x) es " + x);
                    break;
                }
                //System.out.println("Valor de g(x) en " + x + Parser.evaluar(func, x));
                //x1 = Parser.evaluar(funcGX, x);
                //e = Math.abs((Parser.evaluar(funcGX, x1)-Parser.evaluar(funcGX, x))/Parser.evaluar(funcGX, x1));
                //if (e < ed){
                    //break;
                //}
            }
        }
    }
    public static double funcion1(double x){
        return 2*Math.pow(x,3) -2*x -5;
    }
    public static double funcion2(double x){
        double b = (2*x-5)/2;
        return Math.cbrt(b);
    }
}
