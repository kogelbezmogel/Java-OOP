import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Set;
import java.util.Random;

public class RandomZoneGenerator {

    long _seed;

    public RandomZoneGenerator( long seed ) {
        _seed = seed;
    }

    public ZoneId generate() {
        Set<String> zones_set = ZoneId.getAvailableZoneIds();
        ArrayList<String> zones = new ArrayList<String>( zones_set );

        Random rand = new Random(_seed);
        return ZoneId.of( zones.get( rand.nextInt(zones.size()) ) );

    }
}