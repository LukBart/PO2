import java.util.Map;

public class MapAnalyzer extends Analyzer{

    private final Map<String,String> mapOfStrings;

    public MapAnalyzer (Map<String, String> map, int n, int m){
        super(n , m);
        mapOfStrings = map;
    }
    
    public void fillCollection(){
        for (int i = 0; i < super.t1.length; i++){
            mapOfStrings.put(t1[i], t1[i]);
        }
    }

    public void searchPresentElementsInCollection(){
        for (int i = 0; i < super.t2.length; i++){
            mapOfStrings.get(super.t2[i]);
        }
    }

    public void searchMissingElementsInCollection(){
        for (int i = 0; i < super.t3.length; i++){
            mapOfStrings.get(super.t3[i]);
        }
    }

    public void deleteAllElementsInCollection(){
        mapOfStrings.clear();
    }

}
