import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HelloWorld {

    public static void test1() {
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
        int moon = 9 , star = 2 + 2 * 3;
        float sun = star > 10 ? 1 : 3;
        double jupiter = (sun + moon) - 1.0f;
        int mars = --moon <= 8 ? 2 : 3;
        System.out.println( sun + ", " + jupiter + ", " + mars);
    }

    public static void test3() {
        List<Integer> data = new ArrayList<>();

        IntStream.range(0 , 100).forEach( s -> data.add(s));

        System.out.println( data.size() );
    }

 
    public static void test4() {

        Predicate<String> empty = String::isEmpty;

        Predicate<String> notEmpty = empty.negate();

        var result = Stream.generate(() -> "").filter(notEmpty).collect(Collectors.groupingBy(k -> k)).entrySet().stream().map(Entry::getValue).flatMap(Collection::stream).collect(Collectors.partitioningBy(notEmpty));
       
        System.out.println(result);
    }

    public static void test5() {
    
        var a = 15;
        var b = 10;

        addToInt(a, b);

        System.out.println(a);
        
    }

    public static void test6() {

        Locale fr = new Locale("fr");

        Locale.setDefault(new Locale("en" , "US"));

        var b = ResourceBundle.getBundle("Penguin", fr);

        System.out.println( b.getString("name"));
        System.out.println( b.getString("age"));

    }

    public static void addToInt(int x, int amountToAdd) {
        x = x + amountToAdd;
    }

    public static void test7() {
        int[] array = { 6,9,8 };

        System.out.println("B"+ Arrays.binarySearch(array, 9));
        System.out.println("C"+ Arrays.compare(array, new int[] { 6 , 9, 8}));
        System.out.println("M"+ Arrays.mismatch(array, new int[] { 6 , 9 , 8}));
    }


    public static void main(String[] args) {

        Set<? extends RuntimeException> mySet1 = new HashSet<? extends RuntimeException>();
        Set<? extends RuntimeException> mySet2 = new TreeSet<RuntimeException>();
        Set<? extends RuntimeException> mySet3 = new TreeSet<RuntimeException>();
        Set<? extends RuntimeException> mySet4 = new TreeSet<RuntimeException>();

        test7(); 
    }

}