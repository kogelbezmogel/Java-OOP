import java.time.ZonedDateTime;
import java.time.format.*;


public class StringToDateConverter {
    
    public ZonedDateTime convert( String str ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        return ZonedDateTime.parse(str, formatter);
    }
}