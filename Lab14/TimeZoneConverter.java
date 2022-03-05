import java.time.ZonedDateTime;
import java.time.ZoneId;

public class TimeZoneConverter {

    public ZonedDateTime convert( ZonedDateTime zonedatetime, ZoneId zone_id ) {
        return zonedatetime.withZoneSameInstant(zone_id);
    }   
}