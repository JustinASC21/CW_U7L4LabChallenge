import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SimulationTester {
    public static void main(String[] args) {
        Address test = new Address("54","Bleecker St","2R","Queens","NY",11237);
        System.out.println(test);

        Address stringTest = new Address("54 Bleecker St Apt 2R, Queens, NY 11237");
        System.out.println(stringTest);

        Address thirdTest = new Address(test);
        System.out.println(thirdTest);

        parseFile("src/USCities.json");

    }

//    @SuppressWarnings("unchecked")
    public static void parseFile(String fileName) {
        JSONParser jsonParser = new JSONParser(); // create json parser
        try (FileReader reader = new FileReader(fileName)) {
            // read json file
            Object obj = jsonParser.parse(reader);

            JSONArray cityList = (JSONArray) obj;
            System.out.println(cityList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
