import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    
    public MainConsole() { 
        System.out.println("------------");
        readFile();
        System.out.println("------------");
        // convertJsonToList();
    }
    
    public void readFile() { 
        try {
            tryReadFile();
        } catch (FileNotFoundException e) {
           System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
         }
    }

    public void tryReadFile() throws FileNotFoundException, IOException { 
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File("horgaszhelyek.json");
        Scanner sc = new Scanner(file, "UTF-8");

        JsonReader jsonReader = new JsonReader(new FileReader(file));

        jsonReader.beginObject();
        jsonReader.nextName();
        // jsonReader.nextString();
        jsonReader.beginArray();
        jsonReader.beginObject();

        System.out.println(jsonReader.nextName());
        // while(jsonReader.hasNext()) { 
        //     System.out.println("hely");
        // }
        System.out.println(jsonReader.getPath());
        System.out.println(jsonReader.peek());
        
        sc.close();
    }

    public void convertJsonToList() { 
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        JsonObject jsonObject = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        jsonObject.add("fishingspots", jsonArray);
        jsonArray.add(jsonObject.getAsJsonArray("fishingspots"));

        List<JsonElement> list = jsonArray.asList();

        System.out.println(jsonArray.get(1));
        


        FishingSpot[] spots = gson.fromJson(jsonArray, FishingSpot[].class);

        ArrayList<FishingSpot> spotList =
            new ArrayList<>(Arrays.asList(spots));

        System.out.println(spots);

        for (FishingSpot spot : spotList) { 
            System.out.println(spot.name);
        }
    }
}
