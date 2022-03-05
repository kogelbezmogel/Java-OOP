import java.util.Random;
import java.util.Arrays;

public abstract class Analyzer {

    protected String[] t1;
    protected String[] t2;
    protected String[] t3;

    protected Analyzer(int n, int m) {
        t1 = new String[n];
        t2 = new String[m];
        t3 = new String[m];

        Random random = new Random();

        // generate t1, t2, t3 arrays content
        String alpha = "abcdefghijklmnoprstwxyzABCDEFGHIJKLMNOPRSTWXYZ";

        for(int i = 0; i < n; ++i) {
            t1[i] = "";
            int len = random.nextInt(15) + 5;
            for(int j = 0; j < len; ++j) {
                t1[i] += alpha.charAt(random.nextInt( alpha.length() ));
            }
        }

        for(int i  = 0; i < m; ++i) {
            t2[i] = t1[random.nextInt( t1.length )];
        }

        for(int i = 0; i < m; ++i) {
            t3[i] = "";
            int len = random.nextInt(15) + 5;
            for(int j = 0; j < len; ++j) {
                t3[i] += alpha.charAt(random.nextInt( alpha.length() ));
            }
        }

    }

    protected abstract void fillCollection();

    protected abstract void searchPresentElementsInCollection();

    protected abstract void searchMissingElementsInCollection();

    protected abstract void deleteAllElementsInCollection();

    public final void analyse(String collectionName) {
        long start = System.nanoTime();
        fillCollection();
        System.out.println("Filling " + collectionName + ": " + (System.nanoTime() - start) + " ms");

        start = System.nanoTime();
        searchPresentElementsInCollection();
        System.out.println("Searching present in " + collectionName + ": " + (System.nanoTime() - start) + " ms");

        start = System.nanoTime();
        searchMissingElementsInCollection();
        System.out.println("Searching missing in " + collectionName + ": " + (System.nanoTime() - start) + " ms");

        start = System.nanoTime();
        deleteAllElementsInCollection();
        System.out.println("Deleting all from " + collectionName + ": " + (System.nanoTime() - start) + " ms");
    }
}
