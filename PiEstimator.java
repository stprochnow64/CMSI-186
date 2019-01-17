public class PiEstimator{

    public static boolean inCircle(double x, double y) {
        double distance = Math.sqrt((x * x) + (y * y));
        return distance < 1;
    }

    public static double darts(int total) {
        int hits = 0;
        double x;
        double y;
        for (int i = 0; i < total; i++) {
            x = (2 * Math.random()) - 1;
            y = (2 * Math.random()) - 1;
            if (inCircle(x, y)) {
                hits++;
            }
        }
        return hits;
    }

    public static double getPi(double hits, double total) {
        return (4 * hits) / total;
    }

     public static void main(String[] args) {
        int darts = 0;
        if (args.length == 1) {
            darts = Integer.parseInt(args[0]);
            if (darts <= 0) {
                System.out.println("IMPROPER DATA AMOUNT");
                }
            }
        double hits = darts(darts);
        double pi = getPi(hits, darts);
        System.out.println("Estimate: " + pi);

     }
}
