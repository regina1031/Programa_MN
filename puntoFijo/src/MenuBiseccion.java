import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuBiseccion {
    
    public static void menu2() {
        
        Scanner scn1 = new Scanner(System.in);
        
        int op; String ecuacion, rango; double err;

        imprimir("""
           
           Antes de empezar unos puntos:

           - para valores trigonométricas escriba: Sen(x), Cos(x), Tan(x) ... etc
           - para varias ecuaciones utilize corchetes: [...] operador [...]
           - Operadores como: +, -, *, /,^, (). Son validos
           - Para las incógnitas utilice solo 'x', ejemplo: 3*x. No: 3x o 3y o 3*z... etc
           """
        );
            
        try{
            do {
                imprimir("""
                   
                   Menu:
                   1. Calcular Nueva Función
                   2. Salir
                   Ingrese una Opcion: \
                   """
                );

                op = scn1.nextInt();

                switch (op) {
                    case 1:

                        imprimir("\n Ingrese su ecuación: ");ecuacion = scn1.next();
                        imprimir(" Ingrese rangos (Ejemplo: 'a, b' ): ");rango = scn1.next();
                        String[] rangos = rango.split(","); // Divide la cadena de texto de rango en 2 partes, separadas por las comas

                        double b = testeo(
                            Double.parseDouble(rangos[0]), 
                            Double.parseDouble(rangos[1]), 
                            scn1
                        );
                        imprimir(" Ingrese porcentaje de error: ");err = scn1.nextDouble();
                        imprimir("\n DATOS OBTENIDOS: \n");


                        Biseccion.calcularValores(
                            Double.parseDouble(rangos[0]), 
                            b, 
                            err, 
                            ecuacion
                        ); 

                    break;

                    case 2:
                    break;
                
                    default:
                        imprimir("Opcion invalida, intente de nuevo");
                    break;

                }

            } while (op != 2);
        } catch (InputMismatchException e){
            imprimir("\n Error: Ingrese un número válido\n");
        }
    }

    static void imprimir(String text){
        System.out.print(text);
    }

    public static double testeo(Double a, Double b, Scanner scn){

        while (a>b){
            imprimir("\n Vuelva a Ingresar un valor para el rango B, mayor que el rango A: ");
            b = scn.nextDouble();
        }

        return b;
    }
}
