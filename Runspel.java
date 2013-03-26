import view.MadVirusSwingView;
import view.MadVirusView;
import model.MadVirusModel;

public class Runspel {
    public static void main(String[] args) {
        MadVirusModel model = new MadVirusModel();
        MadVirusView view = new MadVirusView(model);
        MadVirusSwingView sview = new MadVirusSwingView(model);
        //view.startSpel();
    }
}