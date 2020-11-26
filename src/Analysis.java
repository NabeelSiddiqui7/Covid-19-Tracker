import java.util.ArrayList;

public class Analysis {
    String selectedAnalysis;
    ArrayList<String> countries = new ArrayList<String>();
    ArrayList<Double> numeratorData = new ArrayList<Double>();

    Analysis(String selectedAnalysis,ArrayList<String> countries ){
        this.selectedAnalysis = selectedAnalysis;
        this.countries = countries;
    }
    public ArrayList<Double> getAnalysisData(){
        if (selectedAnalysis == "Total Confirmed Cases per Country"){
            RetrieveData analysisData = new RetrieveData();
            for (int i = 0; i < countries.size(); i++) {
                numeratorData.add(analysisData.getTotalConfirmedCases(countries.get(i)));
                System.out.println(countries.get(i) + ":" + numeratorData.get(i));
            }
        }
        else if (selectedAnalysis == "Total Deaths per Country"){
            RetrieveData analysisData = new RetrieveData();
            for (int i = 0; i < countries.size(); i++) {
                numeratorData.add(analysisData.getTotalDeathCases(countries.get(i)));
                System.out.println(countries.get(i) + ":" + numeratorData.get(i));
            }
        }
        return numeratorData;
    }
}
