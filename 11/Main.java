import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]), m = Integer.parseInt(args[1]);
        ListAnalyzer arrayListAnalyzer = new ListAnalyzer(new ArrayList<>(), n, m);
        ListAnalyzer linkedListAnalyzer = new ListAnalyzer(new LinkedList<>(), n, m);
        MapAnalyzer hashMapAnalyzer = new MapAnalyzer(new HashMap<>(), n, m);
        MapAnalyzer treeMapAnalyzer = new MapAnalyzer(new TreeMap<>(), n, m);

        arrayListAnalyzer.analyse("ArrayList");
        System.out.println();
        linkedListAnalyzer.analyse("LinkedList");
        System.out.println();
        hashMapAnalyzer.analyse("HashMap");
        System.out.println();
        treeMapAnalyzer.analyse("TreeMap");

        System.out.println();
        System.out.println();

        arrayListAnalyzer.analyzeList("ArrayList");
        System.out.println();
        linkedListAnalyzer.analyzeList("LinkedList");
    }
}
