import java.util.ArrayList;

//STRATEGY DESIGN PATTERN - BASE CLASS
abstract class Analysis {
    protected ArrayList<String> countries = new ArrayList<String>();
    protected ArrayList<Double> resultData = new ArrayList<Double>();

    Analysis(){}

    public void setCountries(ArrayList<String> countries ){
        this.countries = countries;
    }

    public abstract ArrayList<Double> getAnalysisData();
}
