public class Unterricht {
    static int x = 120;
    static int y = 2;
    static int z = 3;
    public static void main(String[] args) {
        System.out.println("" + (x != 'x' ? 2f : 1));
        System.out.println(((Object)(x != 'x' ? 2f : 1)).getClass().getName());
    }
}
