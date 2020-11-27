import java.util.ArrayList;

//STRATEGY PATTERN - CONTEXT CLASS
public class Context {
    private Analysis analysis;

    public Context (Analysis analysis){
        this.analysis = analysis;
    }

    public ArrayList<Double> executeAnalysis(ArrayList<String> countries){
        ArrayList<Double> results;
        analysis.setCountries(countries);
        results = analysis.getAnalysisData();

        return results;
    }

}
