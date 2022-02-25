
public class Address {
    private String streetNum;
    private String streetName;
    private String aptNum;
    private String city;
    private String state;
    private int zipcode;

    public Address(String streeNum, String streetName, String aptNum, String city, String state, int zipcode) {
     this.streetNum = streeNum;
     this.streetName = streetName;
     this.aptNum = aptNum;
     this.city = city;
     this.state = state;
     this.zipcode = zipcode;
    }

public Address(Address adr) {
        this.streetNum = adr.getStreetNum();
        this.streetName = adr.getStreetName();
        this.aptNum = adr.getAptNum();
        this.city = adr.getCity();
        this.state = adr.getState();
        this.zipcode = adr.getZipcode();
}

public Address(String adrString) {
        this.streetNum = adrString.substring(0,adrString.indexOf(" "));
        adrString = adrString.substring(adrString.indexOf(" ") + 1);
        this.zipcode = Integer.parseInt(adrString.substring(adrString.lastIndexOf(" ") + 1));
        adrString = adrString.substring(0,adrString.lastIndexOf(" "));
        this.city = adrString.substring(adrString.lastIndexOf(" ") + 1);
        adrString = adrString.substring(0,adrString.lastIndexOf(" "));
        if (adrString.contains("Apt")) {
            this.aptNum = adrString.substring(adrString.indexOf("Apt ") + 4,adrString.length()-1);
            adrString = adrString.substring(adrString.indexOf(" Apt "));
            this.streetName = adrString;
        }
        else {
            this.streetName = adrString.substring(0,adrString.indexOf(","));
        }
}

    public String getStreetNum() {
        return streetNum;
    }

    public String getCity() {
        return city;
    }

    public String getAptNum() {
        return aptNum;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getState() {
        return state;
    }

    public String getStreetName() {
        return streetName;
    }

    public boolean compareAddresses(Address adrToCompare) {
        if (this == adrToCompare)
            return true;
        return false;
    }


    public String toString() {
        String str = "";
        if (aptNum == null)
            str = streetNum + " " + streetName + ", " + city + " " + zipcode;
        else
            str = streetNum + " " + streetName + " Apt " + aptNum + ", " + city + " " + zipcode;

        return str;
    }
}
