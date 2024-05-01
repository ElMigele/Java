package ToysList;

public class Present {
    View v;
    ToyCollection m;

    boolean loop;
    int id;

    public Present(){
        v = new View();
        m = new ToyCollection();
        Run();
    }

    public void Run(){
        loop = true;
        while (loop) {
            v.ShowCommands();
            int i = v.GetCommand();
            switch (i) {
                case 1:
                    v.Log("Toys in List");
                    for (Toy t : m.Toys)
                        v.PrintToy(t);
                    break;
                case 2:
                    m.AddToy(v.GetName());
                    break;
                case 3:
                    if (m.Toys.size() == 0)
                        break;
                    
                    id = v.GetID();
                    while (!m.ExistID(id))
                        id = v.GetID();
                    String s = "";
                    s += v.GetName(m.GetToy(id).Name());
                    m.RenameToy(id, s);
                    break;
                case 4:
                    if (m.Toys.size() == 0)
                        break;
                
                    id = v.GetID();
                    while (!m.ExistID(id))
                        id = v.GetID();
                    m.RemoveToy(id);
                    break;
                case 5:
                    loop = false;
                    break;
            }            
        }
    }
}
