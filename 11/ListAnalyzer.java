import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ListAnalyzer extends Analyzer {

    // code here...

    private final List<String> listOfStrings;

    public ListAnalyzer (List<String> list, int n, int m){
        super(n, m);
        listOfStrings = list;
    }

    public void fillCollection (){
        for (int i = 0; i < super.t1.length; i++){
            listOfStrings.add(super.t1[i]);
        }
    }

    public void searchPresentElementsInCollection(){
        for (int i = 0; i < super.t2.length; i++){
            listOfStrings.contains(super.t2[i]);
        }
    }

    public void searchMissingElementsInCollection(){
        for (int i = 0; i < super.t3.length; i++){
            listOfStrings.contains(super.t3[i]);
        }
    }

    public void deleteAllElementsInCollection(){
        listOfStrings.clear();
    }

    public void indexedForLoop(){
        for (int i = 0; i < listOfStrings.size(); i ++){
            listOfStrings.get(i);
        }
    }
    public void forEachLoop(){
        for (String s : listOfStrings);
    }

    public void iteratorLoop(){
        Iterator<String> iterator = listOfStrings.iterator();
        while (iterator.hasNext()){
            iterator.next();
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
