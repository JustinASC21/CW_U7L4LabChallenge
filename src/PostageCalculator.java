public class PostageCalculator {
    private static final double baseCount = 3.75;

    public static double calculatePostage(Package pg) {
        double total  = baseCount;
        total += pg.getWeight() * 10 * .05;
        String address1Code = pg.getOrigin().getZipcode() + "";
        String address2Code = pg.getDestination().getZipcode() + "";
        double differenceInCounty = (Integer.parseInt(address1Code.substring(0,3)) - Integer.parseInt(address2Code.substring(0,3))) / 100.0;
        total += differenceInCounty;
        return total;
    }
    public static double calculatePostage() {
        
    }
}
