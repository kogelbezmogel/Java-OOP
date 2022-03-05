import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;

class Main {

    public static void main( String arguments[] ) {

        BufferedReader input = new BufferedReader( new InputStreamReader(System.in) );
        String file1 = "";
        String file2 = "";
    
        try {
            file1 = input.readLine();
            file2 = input.readLine();
            System.out.println( file1 + file2);
        }
        catch( Exception e ){
            System.err.println("wrong file name");
        }

        Path path1 = Paths.get( "./" + file1 );
        Path path2 = Paths.get( "./" + file2 );
        Charset charset = Charset.forName("UTF-8");

        ArrayList<Double> values = new ArrayList<Double>();
        ArrayList<Double> args = new ArrayList<Double>();
        ArrayList<String> lines1 = new ArrayList<String>();
        ArrayList<String> lines2 = new ArrayList<String>();


        try {
            BufferedReader reader1 = Files.newBufferedReader(path1, charset);
            BufferedReader reader2 = Files.newBufferedReader(path2, charset);

            String line1 = "";
            String line2 = "";
            String[] arg_val1;
            String[] arg_val2; 
            while( ( line1 = reader1.readLine() ) != null ) {
                lines1.add(line1);
            }
            while( ( line2 = reader2.readLine() ) != null ) {
                lines2.add(line2);
            }
            for(int i = 0; i < lines1.size(); ++i) {
                arg_val1 = lines1.get(i).split(" ");
                arg_val2 = lines2.get(i).split(" ");

                if( arg_val1[0].equals( arg_val2[0] ) ) {
                    values.add( Double.valueOf(arg_val1[1]) + Double.valueOf(arg_val2[1]) );
                    args.add( Double.valueOf(arg_val1[0]) );
                }
            }
            reader1.close();
            reader2.close();
        }
        catch( IOException e ) {
            System.err.println("Can't open file");
        }
        catch( Exception e ) { System.out.println("Error"); }


        try {
            file1 = input.readLine();
            System.out.println(file1);
        }
        catch( Exception e ){
            System.err.println("wrong file name");
        }

        Path path_to_save = Paths.get( "./" + file1 );


        String answer = "";
        while( Files.exists(path_to_save) && answer.equals("no") ) {

            System.out.println("That file exists. Should I overwirte that file?");
            try {
                answer = input.readLine();
            }
            catch(Exception e) {}

            if( answer.equals("no") ) {
                try {
                    System.out.println("Give new file name: ");
                    file1 = input.readLine();
                    path_to_save = Paths.get( "./" + file1 );

                }
                catch( Exception e ){
                    System.err.println("wrong file name");
                }
            }
        }

        try {
            BufferedWriter write = Files.newBufferedWriter(path1, charset);
            String str = "";

            for( int i = 0; i < args.size(); ++i ) {
                str = args.get(i) + " " + values.get(i);
                write.write(str, 0, str.length());
                write.newLine();
            }
        }
        catch( Exception e ) { System.err.println( "Error"); }
       
    }
}