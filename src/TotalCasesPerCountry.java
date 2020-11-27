import java.util.ArrayList;

//STRATEGY DESIGN PATTERN
public class TotalCasesPerCountry extends Analysis{

    TotalCasesPerCountry(){}

    @Override
    public ArrayList<Double> getAnalysisData(){
        //USING FACADE TO RETRIEVE DATA
        RetrieveData confirmedCases = new RetrieveData();
        for (int i = 0; i < countries.size(); i++) {
            resultData.add(confirmedCases.getConfirmedCases(countries.get(i)));
            System.out.println(countries.get(i) + ":" + resultData.get(i));
        }
        return resultData;
    }
}
