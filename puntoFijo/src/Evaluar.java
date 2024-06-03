public class Evaluar{

    /*Metodo que convierte y resuelve la cadena de texto de la ecuación a un resultado entero */
    /**
     * @param cadena: String con la ecuación a resolver
     * @param x: valor de x a evaluar
     * @return double: resultado de la ecuación
     * evaluar("2 + 2", 0) → 4
     * evaluar("sqrt(x)", 8) → 4
     * evaluar("x^2", 2) → 4
     * <br>
     * <h3>Consideraciones:<h3/>
     * <lis>
     *     <li>Si la cadena contiene "x" se reemplaza por el valor de x</li>
     *     <li>Si la cadena contiene "pi" se reemplaza por el valor de pi</li>
     *     <li>Si la cadena contiene un número, se convierte a double</li>
     *     <li>Si la cadena contiene un paréntesis {@code [ ... ]} , se resuelve la ecuación dentro de los paréntesis</li>
     *     <li>Si la cadena contiene una función trigonométrica {@code Sen(x), Cos(x^3)}, se resuelve la función</li>
     *     <li>Si la cadena contiene una raíz cuadrada {@code [sqrt(x) + 4] * 3}, se resuelve la raíz cuadrada</li>
     * </lis>
     */
    public static double evaluar(String cadena, double x) {
        cadena = cadena.toLowerCase();
        double resultado = 0;
        try {
            String[] tokens; 

            if (cadena.contains("x")) {
                    
                cadena = cadena.replace("x", String.valueOf(x));
            }
            if (cadena.contains("pi")) {

                cadena = cadena.replace("pi", String.valueOf(Math.PI));
            }
            if (Es_numero(cadena)) { 
                resultado = Double.parseDouble(cadena); 

            } else {
                if (cadena.contains("[") || cadena.contains("]")) {  
                    
                    int parentIni = cadena.indexOf("[");
                    int parentFin = cadena.lastIndexOf("]");
                    
                    if (parentIni != -1 && parentFin != -1) {
                        String valor = cadena.substring(parentIni + 1, parentFin);
                        
                        resultado = evaluar(valor, x);
                        
                        cadena = cadena.substring(0, parentIni) + resultado + cadena.substring(parentFin + 1);
                    }
                }
                if (cadena.contains("sqrt(")) {

                    int parentIni = cadena.indexOf("(");
                    int parentFin = cadena.lastIndexOf(")");

                    if (parentIni != -1 && parentFin != -1) {
                        String valor = cadena.substring(parentIni + 1, parentFin);

                        resultado = Math.sqrt(evaluar(valor, x));

                        cadena = cadena.substring(0, parentIni) + resultado + cadena.substring(parentFin + 1);
                    }
                }
                if (cadena.contains("sen(")) {
                    
                    int parentIni = cadena.indexOf("(");
                    int parentFin = cadena.lastIndexOf(")");
                    
                    if (parentIni != -1 && parentFin != -1) {
                        String valor = cadena.substring(parentIni + 1, parentFin);
                        
                        resultado = Math.sin(evaluar(valor, x));
                        
                        cadena = cadena.substring(0, parentIni) + resultado + cadena.substring(parentFin + 1);
                    }
                }
                if (cadena.contains("sec(")) {

                    int parentIni = cadena.indexOf("(");
                    int parentFin = cadena.lastIndexOf(")");

                    if (parentIni != -1 && parentFin != -1) {
                        String valor = cadena.substring(parentIni + 1, parentFin);

                        resultado = Math.asin(evaluar(valor, x));

                        cadena = cadena.substring(0, parentIni) + resultado + cadena.substring(parentFin + 1);
                    }
                }
                if (cadena.contains("cos(")) {
                    
                    int parentIni = cadena.indexOf("(");
                    int parentFin = cadena.lastIndexOf(")");
                    
                    if (parentIni != -1 && parentFin != -1) {
                        String valor = cadena.substring(parentIni + 1, parentFin);
                        
                        resultado = Math.cos(evaluar(valor, x));
                        
                        cadena = cadena.substring(0, parentIni) + resultado + cadena.substring(parentFin + 1);
                    }
                }
                if (cadena.contains("csc(")) {

                    int parentIni = cadena.indexOf("(");
                    int parentFin = cadena.lastIndexOf(")");

                    if (parentIni != -1 && parentFin != -1) {
                        String valor = cadena.substring(parentIni + 1, parentFin);

                        resultado = Math.acos(evaluar(valor, x));

                        cadena = cadena.substring(0, parentIni) + resultado + cadena.substring(parentFin + 1);
                    }
                }
                if (cadena.contains("tan(")) {
                    
                    int parentIni = cadena.indexOf("(");
                    int parentFin = cadena.lastIndexOf(")");
                    
                    if (parentIni != -1 && parentFin != -1) {
                        String valor = cadena.substring(parentIni + 1, parentFin);
                        
                        resultado = Math.tan(evaluar(valor, x));
                        
                        cadena = cadena.substring(0, parentIni) + resultado + cadena.substring(parentFin + 1);
                    }
                }
                if (cadena.contains("cot(")) {

                    int parentIni = cadena.indexOf("(");
                    int parentFin = cadena.lastIndexOf(")");

                    if (parentIni != -1 && parentFin != -1) {
                        String valor = cadena.substring(parentIni + 1, parentFin);

                        resultado = Math.atan(evaluar(valor, x));

                        cadena = cadena.substring(0, parentIni) + resultado + cadena.substring(parentFin + 1);
                    }
                }

                if (cadena.contains("^")) {
                    tokens = cadena.split("\\^"); 
                    resultado = Math.pow(evaluar(tokens[0], x), evaluar(tokens[1], x));

                } else if (cadena.contains("*")) {
                    tokens = cadena.split("\\*"); 
                    resultado = evaluar(tokens[0], x) * evaluar(tokens[1], x);

                } else if (cadena.contains("/")) {
                    tokens = cadena.split("/");
                    resultado = evaluar(tokens[0], x) / evaluar(tokens[1], x);

                } else if (cadena.contains("+")) {
                    tokens = cadena.split("\\+"); 
                    resultado = evaluar(tokens[0], x) + evaluar(tokens[1], x);

                } else if (cadena.contains("-")) {
                    tokens = cadena.split("-");
                    resultado = evaluar(tokens[0], x) - evaluar(tokens[1], x);
                }
                
                
            }
        } catch (Exception e) {
            System.out.println("Error en la expresión.");
        }
        return resultado;
    }

    static boolean Es_numero(String n)/* verifica si una cadena String puede pasar a un Double */ {
        try {
            Double.parseDouble(n);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}