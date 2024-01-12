public class Sum {
    public static void main(String[] args)
    {
        if(args.length >= 2)
        {
            try {
                int temp = Integer.parseInt(args[0]) + Integer.parseInt(args[1]);
                String test = String.valueOf(temp);
                System.out.println(test);
            } catch (Exception e) {
                System.err.println("Both arguments must be of type Integer!");
            }
        }
        else {
            System.err.println("Missing arguments: Provide two Integers!");
        }
    }
}
