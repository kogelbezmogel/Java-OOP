import java.util.List;
import java.util.Iterator;
import java.util.Collection;

public class ListAnalyzer extends Analyzer {

    // code here...

    private final List<String> _list;

    ListAnalyzer(List<String> list, int n, int m) {
        super(n, m);
        this._list = list;
    }

    protected void fillCollection() {
        for ( String s : t1 )
            _list.add(s);
    }

    protected void searchPresentElementsInCollection() {
        
        for( String s : t2 ) {
            _list.contains(s);
        } 

    }

    protected void searchMissingElementsInCollection() {
        for ( String s : t3 ) {
            _list.contains(s);
        }
    }

    protected void deleteAllElementsInCollection() {
        _list.removeAll(_list);
    }

    protected void indexedForLoop() {
        for (int i = 0; i < _list.size(); ++i)
            _list.get(i);
    }

    protected void forEachLoop() { 
        for( String s : _list) {

        }
    }

    protected void iteratorLoop() {
        Iterator<?> ite = _list.iterator();

        while( ite.hasNext() ) {
            ite.next();
        }
    }

    public void analyzeList(String listName) {
    fillCollection();

    long start = System.nanoTime();
    indexedForLoop();
    System.out.println("Indexed for loop over " + listName + ": " +
    (System.nanoTime() - start) + " ms");

    start = System.nanoTime();
    forEachLoop();
    System.out.println("For each loop over " + listName + ": " +
    (System.nanoTime() - start) + " ms");

    start = System.nanoTime();
    iteratorLoop();
    System.out.println("Iterator loop over " + listName + ": " +
    (System.nanoTime() - start) + " ms");
    }
}
