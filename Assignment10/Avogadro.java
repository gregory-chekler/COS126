public class Avogadro {

    /**
     * Determines Avogadro's number and the Boltzmann constant
     *
     * @param args Command-line args: displacement run file
     */
    public static void main(String[] args) {
        // Constants
        double METERS_PER_PIXEL = 0.175e-6;
        int ROOM_TEMPERATURE = 297;
        double VISCOSITY_OF_WATER = 9.135e-4;
        double RADIUS_OF_BEAD = .5e-6;
        double UNIVERSAL_GAS_CONSTANT = 8.31446;

        double r2 = 0.0;
        int n = 0;
        while (!StdIn.isEmpty()) {
            //radius squared
            r2 += Math.pow((Double.parseDouble(StdIn.readString())
                    * METERS_PER_PIXEL), 2);
            n++;
        }
        double d = r2 / (2 * n); //σ^2

        // Boltzmann constant
        double k = 6 * d * RADIUS_OF_BEAD * VISCOSITY_OF_WATER
                * Math.PI / ROOM_TEMPERATURE;

        StdOut.printf("Boltzmann = %.4e\n", k);

        double avogadro = UNIVERSAL_GAS_CONSTANT / k;

        StdOut.printf("Avogadro = %.4e\n", avogadro);
    }
}
