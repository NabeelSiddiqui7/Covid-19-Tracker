//FACADE DESIGN PATTERN - FACADE CLASS
public class RetrieveData {
    private Data confirmedCases;
    private Data deathCases;
    private Data countryPopulation;

    public RetrieveData(){
        confirmedCases = new RetrieveTotalConfirmedCases();
        deathCases = new RetrieveTotalDeathCases();
        countryPopulation = new RetrieveCountryPopulation();
    }

    public double getConfirmedCases(String countries){
        return confirmedCases.getData(countries);
    }

    public double getDeathCases(String countries){
        return deathCases.getData(countries);
    }

    public double getPopulation(String countries){
        return countryPopulation.getData(countries);
    }

}
