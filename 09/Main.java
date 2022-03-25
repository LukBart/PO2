import java.lang.reflect.*;
import java.lang.Math;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        if (args.length != 0){
            String[] splitArg = splitArgs(args[0]);
            String fun = splitArg[0];
            double[] arg = new double[splitArg.length - 1];
            Class[] argType = new Class[splitArg.length - 1];
            try {
                for (int i = 0; i < splitArg.length-1; i++){
                        arg[i] = Double.parseDouble(splitArg[i+1]);
                        argType[i] = double.class;
                    
                }
                try {
                    if (arg.length == 0){
                        System.out.println("Wrong number of arguments passed to the function, enter one or two numbers.");
                    }else{
                        java.lang.reflect.Method m = Math.class.getMethod(fun, argType);
                        if (arg.length == 1){
                            System.out.println("Result: " + m.invoke(null, arg[0]));
                        }
                        if (arg.length == 2){
                            System.out.println("Result: " + m.invoke(null, arg[0], arg[1]));
                        }
                    }
                }
                catch (NoSuchMethodException e) {
                    System.out.println("There is no such method");
                }
                catch (IllegalAccessException e) {
                    System.out.println("Method is inaccessible");
                }
                catch (InvocationTargetException e) {
                    System.out.println("Method throws exception");
                }
                catch (IllegalArgumentException e) {
                    System.out.println("Wrong arguments");
                }
            }catch (NumberFormatException e){
                System.out.println("Function arguments must be numbers.");
            }
        }
        else{
            System.out.println("No arguments to calculate");
        }
    }
    public static String[] splitArgs(String arg) {
        return Arrays.stream(arg.split("[\\s+(),]")).filter(w -> !w.isEmpty()).toArray(String[]::new);
    }
}
