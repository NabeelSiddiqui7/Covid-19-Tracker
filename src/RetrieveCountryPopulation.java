import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//FACADE DESIGN PATTERN
public class RetrieveCountryPopulation extends Data{
    private BufferedReader reader;
    private double population = 0;

    RetrieveCountryPopulation(){}

    public double getData(String country){
        try {
            reader = new BufferedReader(new FileReader("Resources/country-by-population.json"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line;
        String countryString = "";
        String populationString = "";
        try {
            while ((line = reader.readLine()) != null) {
                if (line.contains(country)) {
                    countryString = line;
                    line = reader.readLine();
                    populationString = line;
                    break;
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        populationString = (populationString.split(":"))[1];
        population = Double.parseDouble(populationString);
        return population;
    }
}
