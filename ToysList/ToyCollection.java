package ToysList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ToyCollection {
    public ArrayList<Toy> Toys;
    Path path;
    String file = "\\ToysList\\Toys.csv";
    int nextFreeID;

    public ToyCollection(){
        path = Paths.get(System.getProperty("user.dir") + file);
        try {
            ReadCollectionFile();
        }
        catch (IOException e){
            
        }
    }

    public void ReadCollectionFile() throws IOException{
        Toys = new ArrayList<>();
        
        BufferedReader file = Files.newBufferedReader(path);
        String line = file.readLine();
        nextFreeID = Integer.parseInt(line);
        line = file.readLine();

        while (line != null) {
            Toys.add(new Toy(line));
            line = file.readLine();
        }
        file.close();
    }

    public void UpdateFile() {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString()));
            writer.write(nextFreeID + "");
            for (Toy toy : Toys){
                writer.newLine();
                writer.write(toy.ID() + ";" + toy.Name());
            }
            writer.close();
        } catch (Exception e) {

        }
    }

    public void AddToy(String newToyName){
        Toy newToy = new Toy(newToyName, nextFreeID);
        Toys.add(newToy);
        nextFreeID++;
        UpdateFile();
    }

    public boolean ExistID(int ID){
        for (Toy toy : Toys)
            if (toy.ID() == ID)
                return true;
        return false;
    }

    public void RenameToy(int ID, String newName){
        GetToy(ID).Rename(newName);
        UpdateFile();
    }

    public Toy GetToy(int ID){
        for (Toy toy : Toys)
            if (toy.ID() == ID)
                return toy;
        return null;
    }

    public void RemoveToy(int ID){
        Toys.remove(GetToy(ID));
        UpdateFile();
    }
}