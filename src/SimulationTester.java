import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SimulationTester {
    public static void main(String[] args) {
        String[] streetNames = {
                "Zuniga St","Park Ave","Walnut St","Sycamore St","Crescent Ave","Prospect St","Oak St","Beverly Park Ave","Olive St","Pine St"
        };
        JSONArray AddressJSON;
        Scanner input = new Scanner(System.in);
        /*
        Address test = new Address("54","Cone St","2R","Queens","NY",11237);
        System.out.println(test);

        Address stringTest = new Address("54 Frown St Apt 9L, Brooklyn, NY 10921");
        System.out.println(stringTest);

        Address thirdTest = new Address(test);
        System.out.println(thirdTest);
*/
        AddressJSON = parseFile("src/USCities.json");
        System.out.println("Welcome to the package simulator!");
        System.out.print("How many packages do you want to simulate?: ");
        int numOfPackages = input.nextInt();
        ArrayList<Package> packages = new ArrayList<Package>();
        for (int x = 0; x < numOfPackages; x ++) {
            System.out.print("Enter the weight for Package " + (x+1) + ": ");
            double weight = input.nextDouble();
            Address origin = generateAddress(AddressJSON,streetNames);
            Address destination = generateAddress(AddressJSON,streetNames);
            Package pck = new Package(origin,destination,weight);
            packages.add(pck);
        }

        // show results
        for (int result = 0; result < packages.size(); result ++) {
            double shippingFee = (Math.round(PostageCalculator.calculatePostage(packages.get(result))* 100.0) / 100.0);
            System.out.println("Package " + (result + 1) + " was shipped from " + packages.get(result).getOrigin() + " to " + packages.get(result).getDestination() + " with a fee of $" + shippingFee);
        }

    }

//    @SuppressWarnings("unchecked")
    public static JSONArray parseFile(String fileName) {
        JSONArray cityList = null;
        JSONParser jsonParser = new JSONParser(); // create json parser
        try (FileReader reader = new FileReader(fileName)) {
            // read json file
            Object obj = jsonParser.parse(reader);

            cityList = (JSONArray) obj;
            return cityList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    return cityList;}

    public static Address generateAddress(JSONArray AddressJSON,String[] streetNames) {
        String streetNum = "" + (int) (Math.random() * 90) + 1;
        JSONObject addressInfo = (JSONObject) AddressJSON.get((int) (Math.random() * AddressJSON.size()));
        String zip = addressInfo.get("zip_code").toString();
        String city = addressInfo.get("city").toString();
        String state = addressInfo.get("state").toString();
        String streetName = streetNames[(int) (Math.random() * streetNames.length)];
        if (zip.length() < 6) {
            int numZeros = 6 - zip.length();
            for (int y = 0; y < numZeros; y ++) {
                zip = "0" + zip;
            }
        }
        int newZip = Integer.parseInt(zip);
        String apt = "";
        if (Math.random() <= .5) {
            // there is an apt
            apt = ((int) (Math.random() * 10) + 1)+ "L";
        }
        return new Address(streetNum,streetName,apt,city,state,newZip);
    }
}
