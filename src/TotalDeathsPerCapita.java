import java.util.ArrayList;

//STRATEGY DESIGN PATTERN
public class TotalDeathsPerCapita extends Analysis{

    TotalDeathsPerCapita(){}

    @Override
    public ArrayList<Double> getAnalysisData(){
        //USING FACADE TO RETRIEVE DATA
        RetrieveData deathCases = new RetrieveData();
        RetrieveData countryPopulation = new RetrieveData();
        double num, denom, result;
        for (int i = 0; i < countries.size(); i++) {
            num = deathCases.getDeathCases(countries.get(i));
            denom = countryPopulation.getPopulation(countries.get(i));
            result = num/denom;
            resultData.add(result);
            System.out.println(countries.get(i) + ":" + result);
        }
        return resultData;
    }
}
