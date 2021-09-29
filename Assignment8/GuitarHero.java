public class GuitarHero {

    /**
     * creates GUI keyboard that plays musical notes
     *
     * @param args Command-line args (left blank)
     */
    public static void main(String[] args) {

        // creates a string that has list of all possible keyboard inputs
        String keyboardString = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        // creates a keyboard
        Keyboard keyboard = new Keyboard();

        // creates a guitar string for each note
        GuitarString[] gs = new GuitarString[keyboardString.length()];
        for (int i = 0; i < keyboardString.length(); i++) {
            gs[i] = new GuitarString(440 * Math.pow(2, (i - 24) / 12.0));
        }

        while (true) {

            // check if the user has played a key; if so, process it
            if (keyboard.hasNextKeyPlayed()) {

                // the key the user played
                char key = keyboard.nextKeyPlayed();

                // finds the index of key, so corresponding note can be played
                int index = keyboardString.indexOf(key);

                // pluck the corresponding string
                for (int i = 0; i < keyboardString.length(); i++) {
                    if (index == i) {
                        gs[i].pluck();
                    }
                }
            }

            // compute the superposition of the samples
            double sample = 0.0;
            for (int i = 0; i < keyboardString.length(); i++) {
                sample += gs[i].sample();
            }

            // play the sample on standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for (int i = 0; i < keyboardString.length(); i++) {
                gs[i].tic();
            }
        }
    }
}
