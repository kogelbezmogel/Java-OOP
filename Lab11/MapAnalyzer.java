import java.util.Map;

public class MapAnalyzer extends Analyzer {

    private final Map<String, String> _map;

    MapAnalyzer(Map<String, String> map, int n, int m) {
        super(n, m);
        this._map = map;
    }

    protected void fillCollection() { }

    protected void searchPresentElementsInCollection() { }

    protected void searchMissingElementsInCollection() { }

    protected void deleteAllElementsInCollection() { }


}