import java.util.Random;

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
        String letters = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        for (int i = 0; i < t1.length; i++){
            int randomSize = 5 + random.nextInt(15);
            t1[i] = "";
            for (int j = 0; j < randomSize; j++){
                int randomLetter = random.nextInt(letters.length());
                t1[i] += letters.charAt(randomLetter);
            }
        }

        for (int i = 0; i < t2.length; i++){
            t2[i] = t1[random.nextInt(t1.length)];
        }

        for (int i = 0; i < t3.length; i++){
            int randomSize = 5 + random.nextInt(15);
            t3[i] = "";
            for (int j = 0; j < randomSize; j++){
                int randomLetter = random.nextInt(letters.length());
                t3[i] += letters.charAt(randomLetter);
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
