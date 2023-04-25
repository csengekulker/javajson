import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class MainConsole {

    ArrayList<FishingSpot> fishingSpotArray;
    
    public MainConsole() { 
        readJsonStream();
        writeJsonStream();
    }
    
    public void readJsonStream() { 
        try {
            tryReadJsonStream();
        } catch (FileNotFoundException e) {
           System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
         }
    }

    public void tryReadJsonStream() throws FileNotFoundException, IOException { 
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

    public void writeJsonStream() {
        try {
            tryWriteJsonStream();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void tryWriteJsonStream() throws IOException { 
        JsonWriter jsonWriter = new JsonWriter(new FileWriter("fizetetlen.json", false));
        jsonWriter.setIndent("  ");
        writeSpotsArray(jsonWriter, fishingSpotArray);
        jsonWriter.close();
        

    }

    public void writeSpotsArray(JsonWriter writer, ArrayList<FishingSpot> spots) throws IOException {
        writer.beginArray();

        for (FishingSpot spot : fishingSpotArray) { 
            if (!spot.paid) {
                writeSpot(writer, spot);
            }
        }

        writer.endArray();

    }

    public void writeSpot(JsonWriter writer, FishingSpot spot) throws IOException {
        writer.beginObject();
        writer.name("id").value(spot.getId());
        writer.name("name").value(spot.getName());
        writer.name("spot").value(spot.getSpot());
        writer.name("date").value(spot.getDate().toString());
        writer.name("rods").value(spot.getRods());
        writer.name("paid").value(spot.isPaid());
        
        writer.endObject();

    } 
}
