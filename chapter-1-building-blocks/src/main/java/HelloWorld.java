import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HelloWorld {


    // var var = 3; // var only allowed as local
    //Var case = new Var(); // case is keyword
    void var() {};
    //int Var() { var _ = 7 ; return _;}  // _ is keyword
    //String new = "var";
    //var var() { return null; }

    public static void test1() {

        logm();

        final int score1 = 8, score2 = 3;

        char myScore = 7;

        var goal = switch (myScore) {
            default -> { yield "unknown"; }
            case  score1 -> "great";
            case 2, 4, 6 -> "good";
            case score2, 0 -> {yield "bad";} // yield required, was missing
        };

        System.out.println( goal);

    };

    public static void test2() {

        logm();

        int moon = 9 , star = 2 + 2 * 3;
        float sun = star > 10 ? 1 : 3;
        double jupiter = (sun + moon) - 1.0f;
        int mars = --moon <= 8 ? 2 : 3;
        System.out.println( sun + ", " + jupiter + ", " + mars);
    }

    public static void test3() {

        logm();

        List<Integer> data = new ArrayList<>();

        IntStream.range(0 , 100).forEach( s -> data.add(s));

        System.out.println( data.size() );
    }

 
    public static void test4() {

        logm();

        Predicate<String> empty = String::isEmpty;

        Predicate<String> notEmpty = empty.negate();

        var result = Stream.generate(() -> "").filter(notEmpty).collect(Collectors.groupingBy(k -> k)).entrySet().stream().map(Entry::getValue).flatMap(Collection::stream).collect(Collectors.partitioningBy(notEmpty));
       
        System.out.println(result);
    }

    public static void test5() {
    
        logm();

        var a = 15;
        var b = 10;

        addToInt(a, b);

        System.out.println(a);
        
    }

    public static void test6() {
        logm();
        Locale fr = new Locale("fr");

        Locale.setDefault(new Locale("en" , "US")); // in geval niet gevonden neem engels (dus niet base bundle zonder b.v. _nl )

        var b = ResourceBundle.getBundle("Penguin", fr);

        System.out.println( b.getString("name"));
        System.out.println( b.getString("age"));

    }

    public static void addToInt(int x, int amountToAdd) {
        x = x + amountToAdd;
    }

    private static void logm() {
        
        StackWalker walker = StackWalker.getInstance();
        Optional<String> methodName = walker.walk(frames -> frames.filter( m -> !m.getMethodName().equals("logm") ).findFirst().map(StackWalker.StackFrame::getMethodName));
        System.out.println(String.format("-- %s --" , methodName.get()));
    }

    public static void test7() {

        logm();

        int[] array = { 6,9,8 };

        System.out.println("B"+ Arrays.binarySearch(array, 9)); // B1
        System.out.println("C"+ Arrays.compare(array, new int[] { 6 , 9, 8})); // C0
        System.out.println("M"+ Arrays.mismatch(array, new int[] { 6 , 9 , 8})); // M-1

        // eigen tests
        System.out.println("H"+ Arrays.mismatch(array, new int[] { 6 , 9 , 6})); // H2
    }

    public static void test19() {
        logm();

        var x = 5;
        var j = 0;
        
        OUTER: for ( var i=0 ; i< 3 ;)
            INNER: do {
                i++;
                x++;
                if ( x > 10) break INNER;
                x += 4;
                j++;
            } while ( j <= 2);
            System.out.println(x);
    }

    public static void test20() {
        logm();

        var pooh = """
            "Oh, bother." -Pooh    
            """.indent(1);

            System.out.println(pooh);
    }

    public static void test22() {
        var treeMap = new TreeMap<Character, Integer>();

        treeMap.put('k', 1);
        treeMap.put('k', 2);
        treeMap.put('m', 3);
        treeMap.put('M', 4);
        
        treeMap.replaceAll((k,v) -> v + v);

        treeMap.keySet().forEach(k -> System.out.print(treeMap.get(k)));
    }
    public static void test13() {

        logm();

        //Set<? extends RuntimeException> mySet1 = new HashSet<? extends RunitmeException>();
        //Set<? extends RuntimeException> mySet2 = new HashSet<Exception>();
        Set<? extends RuntimeException> mySet3 = new TreeSet<RuntimeException>();
        Set<? extends RuntimeException> mySet4 = new TreeSet<NullPointerException>();
    }

    public static void test23() {


        

        //System.out.println(test( (int i) ->  i == 5));

    }

    private static boolean test(Function<Integer,Boolean> b) {
        return b.apply(5);
    }
  

    public static void main(String[] args) { 

        //test6();
        //test7();
        
        test22();
    }

}