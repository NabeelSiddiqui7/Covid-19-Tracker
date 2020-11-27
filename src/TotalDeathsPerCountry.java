import java.util.ArrayList;

//STRATEGY DESIGN PATTERN
public class TotalDeathsPerCountry extends Analysis{

    TotalDeathsPerCountry(){};

    @Override
    public ArrayList<Double> getAnalysisData(){
        //USING FACADE TO RETRIEVE DATA
        RetrieveData deathCases = new RetrieveData();
        for (int i = 0; i < countries.size(); i++) {
            resultData.add(deathCases.getDeathCases(countries.get(i)));
            System.out.println(countries.get(i) + ":" + resultData.get(i));
        }
        return resultData;
    }
}
