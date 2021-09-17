public class Bits {

    /**
     * determines number of times needed to divide by 2 until value is less than 1
     *
     * @param "args" Commnad line argument for value
     */
    public static void main(String[] args) {


        int n = Integer.parseInt(args[0]);
        int i = 0; //makes i global

        if (n < 0) {
            System.out.println("Illegal input");
        } else {
            for (i = 0; n >= 1; i++) {
                n /= 2;
            }
            System.out.println(i);
        }
    }
}
