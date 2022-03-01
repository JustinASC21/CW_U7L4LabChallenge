public class Package {
    private Address origin;
    private Address destination;
    private double weight;

    public Package(Address origin, Address destination, double weight) {
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

    public Address getDestination() {
        return destination;
    }

    public Address getOrigin() {
        return origin;
    }

    public double getWeight() {
        return weight;
    }
}
