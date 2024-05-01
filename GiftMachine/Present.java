package GiftMachine;

import ToysList.Toy;

public class Present {
    GiftMachine m;
    View v;
    boolean loop;

    public Present(){
        v = new View();
        m = new GiftMachine();
        loop = true;
        Run();
    }

    public void Run(){
        int id, c;
        while (loop) {
            v.ShowCommand();
            int com = v.GetCommand();
            switch (com) {
                case 1:
                    v.Log("Toys in Machine:");
                    for (ToyGroup g : m.toyGroups) {
                        v.Log(g.GetInfo());
                    }
                    break;
                case 2:
                    v.Log("Toys in List:");
                    for (Toy t : m.toys) {
                        v.Log(t.GetInfo());
                    }
                    break;
                case 3:
                    id = GetRealToy();
                    c = v.GetCount();
                    m.LoadToys(id, c);
                    break;
                case 4:
                    id = GetRealToyInM();
                    c = v.GetCount();
                    while (!m.UnloadToys(id, c)){
                        v.Log("Entered value is bigger than toy count in machine");
                        c = v.GetCount();
                    }

                    break;
                case 5:
                    id = GetRealToyInM();
                    c = v.SetWeight(m.GetToy(id).Name());
                    m.SetWeight(id, c);
                    break;
                case 6:
                    String s = "Gifted toy: " + m.ClaimToy().Name();
                    v.Log(s);
                    break;
                case 7:
                    loop = false;
                    v.Log("Return to Main Menu");
                    break;
            }
        }
    }

    private int GetRealToy(){
        int id = v.GetID("Toy in List");
        Toy t = m.GetToy(id);
        while (t == null){
            id = v.GetID("Toy in List");
            t = m.GetToy(id);
        }
        return id;
    }
    
    private int GetRealToyInM(){
        int id = v.GetID("Toy in List");
        Toy t = m.GetToyInM(id);
        while (t == null){
            id = v.GetID("Toy in List");
            t = m.GetToyInM(id);
        }
        return id;
    }
}