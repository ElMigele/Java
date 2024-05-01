package GiftMachine;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

import ToysList.Toy;

public class GiftMachine {
    public ArrayList<ToyGroup> toyGroups;
    public ArrayList<Toy> toys;
    String toyPath ="\\ToysList\\Toys.csv";
    String MachinePath = "\\GiftMachine\\ToysInMachine.csv";
    Path mp;

    private int weightSize;

    public GiftMachine(){
        weightSize = 0;
        LoadToyData();
        LoadMachineData();
        
        CalculateWeights();
    }

    public void LoadToyData(){
        Path p = Paths.get(System.getProperty("user.dir") + toyPath);
        toys = new ArrayList<>();
        try {
            BufferedReader file = Files.newBufferedReader(p);
            String line = file.readLine();
            line = file.readLine();
            while (line != null) {
                toys.add(new Toy(line));
                line = file.readLine();
            }
            file.close();    
        } catch (Exception e) {
        }
    }

    public void LoadMachineData(){
        mp = Paths.get(System.getProperty("user.dir") + MachinePath);
        toyGroups = new ArrayList<>();
        try {
            BufferedReader file = Files.newBufferedReader(mp);
            String line = file.readLine();
            while (line != null) {
                String[] blocks = line.split(";");
                Toy t = GetToy(Integer.parseInt(blocks[0]));
                if (t != null){
                    toyGroups.add(new ToyGroup(t,
                        Integer.parseInt(blocks[1]),
                        Integer.parseInt(blocks[2])));
                } else {
                    // сказать что игрушка которая тут была удалена из перечня и не мб добавлена
                }
                line = file.readLine();
            }
            file.close();    
        } catch (Exception e) {
        }
    }

    public Toy GetToy(int id){
        for (Toy t : toys)
            if (t.ID() == id)
                return t;
        return null;
    }

    public Toy GetToyInM(int id){
        for (ToyGroup g : toyGroups)
            if (g.Toy().ID() == (id))
                return g.Toy();
        return null;
    }

    public Toy ClaimToy(){
        Random r = new Random();
        int rnd = r.nextInt(weightSize) + 1;
        Toy res;

        int id = FindToyGroupByWeight(rnd);
        ToyGroup g = GetToyGroup(id);
        res = g.Toy();
        if (g.RemoveToy()){
            toyGroups.remove(g);
            if (toyGroups.size() != 0){
                CalculateWeights();
            } else {
                // сказать что игрушки кончились
            }
        }
        UpdateFile();
        return res;
    }

    public void SetWeight(int id, int newWeight){
        GetToyGroup(id).SetWeight(newWeight);
        CalculateWeights();
        UpdateFile();
    }

    public void LoadToys(int id, int count){
        ToyGroup g = GetToyGroup(id);
        if (g == null){
            toyGroups.add(new ToyGroup(GetToy(id), count));
            CalculateWeights();
        } else {
            g.ChangeCount(count);
        }
        UpdateFile();
    }

    public boolean UnloadToys(int id, int count){
        ToyGroup g = GetToyGroup(id);
        if (g.Count() < count)
            return false;
        
        g.ChangeCount(-count);

        if (g.Count() == 0){
            toyGroups.remove(g);
            CalculateWeights();
        }
        UpdateFile();

        return true;
    }

    public void UpdateFile(){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(mp.toString()));
            for (ToyGroup g: toyGroups){
                writer.write(g.Toy().ID() + ";" + g.Count() + ";" + g.Weight());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
        }
    }

    private void CalculateWeights(){
        weightSize = 0;
        for (ToyGroup g : toyGroups){
            weightSize += g.Weight();
            g.UpdateWeight(weightSize);
        }
    }

    private ToyGroup GetToyGroup(int id){
        for (ToyGroup g : toyGroups)
            if (g.Toy().ID() == id)
                return g;
        return null;
    }

    private int FindToyGroupByWeight(int rnd) {
        for (ToyGroup g : toyGroups){
            if (rnd <= g.MyWeight()){
                return g.Toy().ID();
            }
        }
        return -1;
    }
}