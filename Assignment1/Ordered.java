public class Ordered {
    public static void main(String[] args) {

        //define variables
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        //checks if numbers are in order
        boolean ordered = (((a > b) && (b > c)) || (((a < b) && (b < c))));

        //prints out result
        System.out.println(ordered);
    }
}
