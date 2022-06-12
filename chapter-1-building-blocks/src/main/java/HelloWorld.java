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
        
    }

    public static void main(String[] args) {

        double jupiter = ( 3 + 9 ) - 1.0f;

        var x = 2 + 2 * 3;

        System.out.println("Hello World" + x);    


        test1();
    }

}