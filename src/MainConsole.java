import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class MainConsole {

    ArrayList<FishingSpot> fishingSpotArray;
    
    public MainConsole() { 
        consumeJsonFile();
        test();
    }
    
    public void consumeJsonFile() { 
        try {
            tryConsumeJsonFile();
        } catch (FileNotFoundException e) {
           System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
         }
    }

    public void tryConsumeJsonFile() throws FileNotFoundException, IOException { 
        File file = new File("horgaszhelyek.json");
        JsonReader jsonReader = new JsonReader(new FileReader(file));

        this.fishingSpotArray = new ArrayList<>();


        jsonReader.beginObject(); // {
        jsonReader.nextName(); // "fishingspots"
        jsonReader.beginArray(); // [

        while (jsonReader.hasNext()) {
            jsonReader.beginObject(); // { 
            jsonReader.nextName();
            int id = jsonReader.nextInt();
            jsonReader.nextName();

            String name = jsonReader.nextString();
            jsonReader.nextName();

            int spot = jsonReader.nextInt();
            jsonReader.nextName();

            LocalDate date = LocalDate.parse(jsonReader.nextString()); //toLocalDate
            jsonReader.nextName();

            int rods = jsonReader.nextInt();
            jsonReader.nextName();

            boolean paid = jsonReader.nextBoolean();
            jsonReader.endObject();

            FishingSpot fishingSpot = new FishingSpot(
                id, 
                name, 
                spot, 
                date, 
                rods, 
                paid);

            this.fishingSpotArray.add(fishingSpot);

        }


    }

    public void test() { 
        
        for (FishingSpot spot : fishingSpotArray) { 
            System.out.println(spot.name);
        }
    }
}
