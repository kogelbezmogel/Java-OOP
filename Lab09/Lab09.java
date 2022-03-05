
import java.util.Arrays;
import java.lang.reflect.*;
import java.util.ArrayList;

class Lab10 {

    public static String[] splitArgs(String args) {
        return Arrays.stream(args.split("[\\s+(),]")).filter(w -> !w.isEmpty()).toArray(String[]::new);
    }

    public static void main (String[] args) {

        String[] splitted = splitArgs(args[0]);

        try {

            Class<?> cl = Class.forName("java.lang.Math");
            Method m = Math.class.getMethod( splitted[0], double.class );


            if( m.getParameterCount() != (splitted.length - 1) ) {
                throw new Exception("Wrong number of parameters");
            }

            ArrayList<Double> arguments = new ArrayList<Double>();
            
            for(int i = 1; i < splitted.length; ++i) {
                arguments.add( Double.valueOf( splitted[i] ) );
            }

            if( splitted.length == 1 ) {
                throw new Exception("No arguments o calculate");
            }

            if(splitted.length == 2) {
                System.out.println( m.invoke( null, arguments.get(0)).toString() );
            }

            if(splitted.length == 3) {
                System.out.println( m.invoke( null, arguments.get(0), arguments.get(1)).toString() );
            }
        } catch( ClassNotFoundException e ) {
            System.err.println("Nie ma klasy");
        } catch ( NoSuchMethodException e ) {
            System.err.println("No such Method");
        } catch ( NumberFormatException e ) { 
            System.err.println("Argumnt not a number");
        } catch ( Exception e ) {
            System.err.println( e.toString() );
        }
    }

}