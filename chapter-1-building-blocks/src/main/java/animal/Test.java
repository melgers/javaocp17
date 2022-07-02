package animal;

import other.Tadpole;

public class Test {
    
    public static void main(String[] args) {
        

        Frog f = new Frog();

        f.jump();
        f.ribbit();

        Frog tf = new Tadpole();

        tf.jump();
        tf.ribbit();

        new Test();

    }

    { System.out.println("--- test ---");}

}
