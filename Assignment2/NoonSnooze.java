public class NoonSnooze {

    /**
     * takes value representing # of minutes and prints time that elapsed after
     * the vaue is added to 12:00pm
     *
     * @param "args" Commnad line argument for snooze
     */
    public static void main(String[] args) {
        int snooze = Integer.parseInt(args[0]);
        int hours = 0;
        int mins = 0;
        int switches = 0; //looks at switches from pm to am and vice-versa

        if ((snooze / 60) < 1) { // instance where number is less than 1 hour
            System.out.println("12:" + snooze + "pm");
        } else {
            hours = snooze / 60; //gives # of hours

            if (hours >= 12) {
                switches = hours / 12; //determines how many switches btwn am and pm
                hours = hours % 12; //gives number of hours left after looking at switches
                if (hours == 0) {// if hours % 12 gives 0, sets hours to 12
                    hours = 12;
                }
            }

            mins = snooze % 60;//finds number of minutes

            //determines wether to give am or pm
            if (switches % 2 == 0) {
                System.out.print(hours + ":");
                if (mins < 10) {
                    System.out.println("0" + mins + "pm");
                } else {
                    System.out.println(mins + "pm");
                }
            } else {
                System.out.print(hours + ":");
                if (mins < 10) {
                    System.out.println("0" + mins + "am");
                } else {
                    System.out.println(mins + "am");
                }
            }
        }
    }
}
