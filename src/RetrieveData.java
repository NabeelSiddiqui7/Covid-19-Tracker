import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class RetrieveData {
    RetrieveData(){
        System.out.print("Attempting to retrieve data.\n");
    }
    public double getTotalConfirmedCases(String country) {
        String urlString = String.format("https://api.covid19api.com/total/dayone/country/%s/status/confirmed", country);
        //System.out.println(urlString);
        int cases = 0;
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();
            if (responsecode == 200) {
                String inline = "";
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    inline += sc.nextLine();
                }
                sc.close();
                JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
                int size = jsonArray.size();
                cases = jsonArray.get(size - 1).getAsJsonObject().get("Cases").getAsInt();
                //System.out.println("Cases: " + cases);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cases;
    }
    public double getTotalDeathCases(String country) {
        String urlString = String.format("https://api.covid19api.com/total/dayone/country/%s/status/deaths", country);
        //System.out.println(urlString);
        int deaths = 0;
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();
            if (responsecode == 200) {
                String inline = "";
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    inline += sc.nextLine();
                }
                sc.close();
                JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
                int size = jsonArray.size();
                deaths = jsonArray.get(size - 1).getAsJsonObject().get("Cases").getAsInt();
                //System.out.println("Cases: " + cases);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return deaths;
    }
}
