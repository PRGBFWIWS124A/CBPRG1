public class Sum {
    public static void main(String[] args)
    {
        if(args.length >= 2)
        {
            try {
                int Z1 = Integer.parseInt(args[0]);
                int Z2 = Integer.parseInt(args[1]);
                System.out.println(Z1 + " + " + Z2 + " = " + (Z1 + Z2));
            } catch (NumberFormatException e) {
                System.err.println("Both arguments must be of type Integer!");
            }
        }
        else {
            System.err.println("Missing arguments: Provide two Integers!");
        }
    }
}
