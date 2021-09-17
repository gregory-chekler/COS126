public class RandomWalkers {


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); //steps
        int trials = Integer.parseInt(args[1]);
        int x = 0;
        int y = 0;/**
         * simulates a random walk for # of steps for a certain amount of trials
         * and determines the mean squared distance over the amount of trials
         *
         * @param "args" Command line argument for steps and trials
         */
        int choice = 0; //value that stores what direction point will go
        double distance = 0;

        for (int z = 0; z <= trials; z++) {

            //resets value after each iteration of outside for loop
            x = 0;
            y = 0;
            int i = 0;

            for (i = 0; i <= n; i++) {
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
                        break;
                    case 1:
                        x -= 1;
                        break;
                    case 2:
                        y += 1;
                        break;
                    case 3:
                        y -= 1;
                        break;
                    case 4:
                        x += 1;
                        break;
                }
            }
            distance += (Math.pow(x, 2) + Math.pow(y, 2));
        }
        distance = distance / trials; //mean squared distance
        System.out.println("Mean squared distance: " + distance);
    }
}
