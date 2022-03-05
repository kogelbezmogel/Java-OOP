import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public List<String> validate( String[] args ) {


        ArrayList<String> to_return = new ArrayList<String>();

        if (args.length < 4) {
            to_return.add("Wrong number of arguments");
            return to_return;
        }

        if( ! args[0].matches("\\d{4}-[01]\\d-[0-3]\\d") ) {
            to_return.add("First argument should be date with format yyyy-MM-dd");
        }

        if( ! args[1].matches("^(\\d\\d:\\d\\d:\\d\\d)") ) {
            to_return.add("Second argument should be time with format HH:mm:ss");
        }

        if( args[2].length() != 3 ) {
            to_return.add("Third argument should be exactly 3 letters long");
        }

        if( ! args[3].matches("^[0-9]+$") ) {
            to_return.add("Fourth argument should be a number");
        }

        return to_return;
    }
}