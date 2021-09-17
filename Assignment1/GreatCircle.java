public class GreatCircle {
    public static void main(String[] args) {
        //defines variables and converts them into radians
        double x_1 = Math.toRadians(Double.parseDouble(args[0]));
        double y_1 = Math.toRadians(Double.parseDouble(args[1]));
        double x_2 = Math.toRadians(Double.parseDouble(args[2]));
        double y_2 = Math.toRadians(Double.parseDouble(args[3]));

        //does calc in acos in rads and then converts into deg
        double distance = 60.0 * Math.toDegrees(Math.acos(((
                Math.sin(x_1) * Math.sin(x_2)) + (Math.cos(x_1)
                * Math.cos(x_2) * Math.cos(y_1 - y_2)))));

        //prints result
        System.out.println(distance + " nautical miles");
    }
}
