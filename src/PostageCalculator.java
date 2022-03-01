public class PostageCalculator {
    private static final double baseCount = 3.75;

    public static double calculatePostage(Package pg) {
        double total  = baseCount;
        total += pg.getWeight() * 10 * .05;
        total += differenceInCounty(pg.getOrigin().getZipcode(),pg.getDestination().getZipcode());
        return total;
    }
    public static double calculatePostage(int zip1, int zip2, double packWeight) {
        double total = baseCount;
        total += packWeight * 10 * 0.05;
        total += differenceInCounty(zip1,zip2);
        return total;
    }

    public static double calculatePostage(Address adr1, Address adr2, double packWeight) {
        double total = baseCount;
        total += packWeight * 10 * 0.05;
        total += differenceInCounty(adr1.getZipcode(),adr2.getZipcode());
        return total;
    }

    private static double differenceInCounty(int zip1, int zip2) {
        String adr1County = (zip1 + "").substring(0,3);
        String adr2County = (zip2 + "").substring(0,3);
        return Math.abs(Integer.parseInt(adr1County) - Integer.parseInt(adr2County)) / 100.0;
    }
}
