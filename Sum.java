public class Sum {
    public static void main(String[] args)
    {
        if(args.length >= 2)
        {
            try {
                int temp = Integer.parseInt(args[0]) + Integer.parseInt(args[1]);
                String test = String.valueOf(temp);
                System.out.println(test);
                //Funktionen
                output("Summe aus der Produkt-Funktion: " + product(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
                output("Quadratsumme der beiden Werte: " + squaresum(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
                //Prozeduren
                output("TEST");
                warning();
            } catch (Exception e) {
                System.err.println("Both arguments must be of type Integer!");
            }
        }
        else {
            System.err.println("Missing arguments: Provide two Integers!");
        }
    }

    public static int product(int x, int y)
    {
        return x * y;
    }

    public static int squaresum(int x, int y)
    {
        return (x * x) + (y * y);
    }

    public static void output(String content)
    {
        System.out.println(content);
    }

    public static void warning() {
        System.out.println("WARNUNG");
    }
}
