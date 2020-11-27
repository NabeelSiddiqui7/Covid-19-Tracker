import java.util.ArrayList;

//STRATEGY DESIGN PATTERN
public class TotalCasesPerCapita extends Analysis{

    TotalCasesPerCapita(){}

    @Override
    public ArrayList<Double> getAnalysisData(){
        //USING FACADE TO RETRIEVE DATA
        RetrieveData confirmedCases = new RetrieveData();
        RetrieveData countryPopulation = new RetrieveData();
        double num, denom, result;
        for (int i = 0; i < countries.size(); i++) {
            num = confirmedCases.getConfirmedCases(countries.get(i));
            denom = countryPopulation.getPopulation(countries.get(i));
            result = num/denom;
            resultData.add(result);
            System.out.println(countries.get(i) + ":" + result);
        }
        return resultData;
    }
}
