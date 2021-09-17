public class RandomWalker {

    /**
     * prints each random step a particle takes and then find the
     * squared distance from the origin
     *
     * @param "args" Commnad line argument for steps
     */
    public static void main(String[] args) {


        int n = Integer.parseInt(args[0]); //steps
        int x = 0;
        int y = 0;
        int choice = 0; //value that stores what direction point will go
        double distance = 0;


        for (int i = 0; i <= n; i++) {
            choice = (int) Math.round(Math.random() * 4); //rand num from 0 to 4 rounded to nearest int

            /*
            When Math.random happens, it gets rounded to specific cases depending on these ranges:
            case 0: 0 to .5
            case 1: .5 to 1.5
            case 2: 1.5 to 2.5
            case 3: 2.5 to 3.5
            case 4: 3.5 to 4

            case 0 and case 4 combine into one action to equal the others in terms of range and rounding frequency
             */
            switch (choice) {
                case 0:
                    x += 1;
                    System.out.println("(" + x + "," + y + ")");
                    break;
                case 1:
                    x -= 1;
                    System.out.println("(" + x + "," + y + ")");
                    break;
                case 2:
                    y += 1;
                    System.out.println("(" + x + "," + y + ")");
                    break;
                case 3:
                    y -= 1;
                    System.out.println("(" + x + "," + y + ")");
                    break;
                case 4:
                    x += 1;
                    System.out.println("(" + x + "," + y + ")");
                    break;
            }
        }
        distance = Math.pow(x, 2) + Math.pow(y, 2);
        System.out.println("Squared distance: " + distance);
    }
}
