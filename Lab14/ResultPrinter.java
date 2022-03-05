import java.time.ZonedDateTime;

public class ResultPrinter {

    public void print(ZonedDateTime to_con, ZonedDateTime con ) {
        System.out.printf("%s => %s", to_con, con);
    }
}