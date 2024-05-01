package General;

public class Present {
    Model m;
    View v;
    boolean loop;

    ToysList.Present tlp;
    GiftMachine.Present gmp;

    public Present(){
        m = new Model();
        v = new View();
        loop = true;
        Run();
    }

    private void Run(){
        while (loop) {
            v.ShowCommands();
            int com = v.GetCommand();
            switch (com) {
                case 1:
                    tlp = new ToysList.Present();
                    break;
                case 2:
                    gmp = new GiftMachine.Present();
                    break;
                case 3:
                    loop = false;
                    v.ShutDown();
                    break;
            }
        }
    }
}