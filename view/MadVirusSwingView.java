package view;

import model.MadVirusModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;

public class MadVirusSwingView extends JFrame {
    private int level;
    private int supervirus;
    private long time = 60000;
    private JFrame input;
    private JPanel frame;
    private JLabel naamField;
    private JLabel beurtField;
    private JLabel tijdField;
    private JButton redButton;
    private JButton yellowButton;
    private JButton greenButton;
    private JButton blueButton;
    private JButton purpleButton;
    private JButton orangeButton;
    private JButton pinkButton;
    private JButton brownButton;
    private JFrame startmenu = new JFrame("Start menu");
    private MadVirusModel spel;

    public MadVirusSwingView(MadVirusModel spel) {
        super("Mad Virus");
        naamframe();
        this.spel = spel;
        this.spel.reset(false, 0);
    }

    private void menuKeuze(int keuze){
        if (keuze == 0) {
            supervirus = maakframe();
            spel.setModus(supervirus);
            maakComponenten();
            voegListenersToe();
            maakLayout();
            toonFrame();
        }

        else if (keuze == 1){
            try{
                FileInputStream fstream = new FileInputStream(spel.getNaam()+".scr");
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String strLine;
                String text = "***HIGHSCORES***\n";
                while ((strLine = br.readLine()) != null)   {
                    text += strLine + "\n";
                }
                text += "***----------***\n";
                JOptionPane.showMessageDialog(null, text, "Highscores", JOptionPane.INFORMATION_MESSAGE);
                in.close();
                menuKeuze(maakMenu());
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "Geen Highscore gevonden!", "Highscores", JOptionPane.WARNING_MESSAGE);
            }
        }

        else if (keuze == 2) {
            JOptionPane.showMessageDialog(null, spel.getUitleg(), "uitleg", JOptionPane.INFORMATION_MESSAGE);
            menuKeuze(maakMenu());
        }

        else{

        }
    }

    private void maakComponenten() {
        naamField = new JLabel(spel.getNaam());
        beurtField = new JLabel("Beurt: " + spel.getBeurt());
        tijdField = new JLabel("");
        BufferedImage labelicon = null;
        try {
            labelicon = ImageIO.read(getClass().getResourceAsStream("./pics/button_red.png"));
            Image thumbnail = labelicon.getScaledInstance(100, -1, Image.SCALE_SMOOTH);
            redButton = new JButton(new ImageIcon(thumbnail));
            redButton.setBorder(BorderFactory.createEmptyBorder());
            redButton.setContentAreaFilled(false);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try {
            labelicon = ImageIO.read(getClass().getResourceAsStream("./pics/button_blue.png"));
            Image thumbnail = labelicon.getScaledInstance(100, -1, Image.SCALE_SMOOTH);
            blueButton = new JButton(new ImageIcon(thumbnail));
            blueButton.setBorder(BorderFactory.createEmptyBorder());
            blueButton.setContentAreaFilled(false);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try {
            labelicon = ImageIO.read(getClass().getResourceAsStream("./pics/button_yellow.png"));
            Image thumbnail = labelicon.getScaledInstance(100, -1, Image.SCALE_SMOOTH);
            yellowButton = new JButton(new ImageIcon(thumbnail));
            yellowButton.setBorder(BorderFactory.createEmptyBorder());
            yellowButton.setContentAreaFilled(false);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try {
            labelicon = ImageIO.read(getClass().getResourceAsStream("./pics/button_green.png"));
            Image thumbnail = labelicon.getScaledInstance(100, -1, Image.SCALE_SMOOTH);
            greenButton = new JButton(new ImageIcon(thumbnail));
            greenButton.setBorder(BorderFactory.createEmptyBorder());
            greenButton.setContentAreaFilled(false);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }try {
            labelicon = ImageIO.read(getClass().getResourceAsStream("./pics/button_purple.png"));
            Image thumbnail = labelicon.getScaledInstance(100, -1, Image.SCALE_SMOOTH);
            purpleButton = new JButton(new ImageIcon(thumbnail));
            purpleButton.setBorder(BorderFactory.createEmptyBorder());
            purpleButton.setContentAreaFilled(false);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void voegListenersToe() {
        final Timer t = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (time > 0) {
                    time -= 1000;
                    tijdField.setText(Long.toString(time/1000));

                }
                else {
                    gameOver();
                }
            }
        });
        t.start();

        redButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                spel.zoekVirus(1);
                beurtField.setText("Beurt: " + spel.getBeurt());
                updateFrame();
                if(spel.veldVol()){
                    endGame();
                    verhooglevel(supervirus);
                }
                else {

                }
            }
        });

        yellowButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                spel.zoekVirus(2);
                beurtField.setText("Beurt: " + spel.getBeurt());
                updateFrame();
                if(spel.veldVol()){
                    endGame();
                    verhooglevel(supervirus);
                }
                else {

                }
            }
        });

        purpleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                spel.zoekVirus(3);
                beurtField.setText("Beurt: " + spel.getBeurt());
                updateFrame();
                if(spel.veldVol()){
                    endGame();
                    verhooglevel(supervirus);
                }
                else {

                }
            }
        });

        blueButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                spel.zoekVirus(4);
                beurtField.setText("Beurt: " + spel.getBeurt());
                updateFrame();
                if(spel.veldVol()){
                    endGame();
                    verhooglevel(supervirus);
                }
                else {

                }
            }
        });

        greenButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                spel.zoekVirus(5);
                beurtField.setText("Beurt: " + spel.getBeurt());
                updateFrame();
                if(spel.veldVol()){
                    endGame();
                    verhooglevel(supervirus);
                }
                else {

                }

            }
        });
        /*
        orangeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                spel.setKeuzekleur(6);
            }
        });

        pinkButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                spel.setKeuzekleur(7);
            }
        });

        brownButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                spel.setKeuzekleur(8);
            }
        });
        **/
    }

    private void maakLayout() {
        frame = new JPanel(new GridLayout(spel.getBreedte(), spel.getHoogte()));
        frame.setBackground(Color.black);
        for (int i = 0; i<spel.getBreedte(); i++){
            for(int j =0; j<spel.getHoogte(); j++){
                String path = "";
                switch (spel.getKleur(j,i)){
                    case 1: path = "./pics/gem_red.png";break;
                    case 2: path = "./pics/gem_yellow.png";break;
                    case 3: path = "./pics/gem_purple.png";break;
                    case 4: path = "./pics/gem_blue.png";break;
                    case 5: path = "./pics/gem_green.png";break;
                    case 6: path = "./pics/gem_orange.png";break;
                    case 7: path = "./pics/gem_pink.png";break;
                    case 8: path = "./pics/gem_brown.png";break;
                    case 0: path = "./pics/virus.png";break;
                    default: path = " ";break;
                }
                BufferedImage labelicon = null;
                try {
                    labelicon = ImageIO.read(getClass().getResourceAsStream(path));
                    Image thumbnail = labelicon.getScaledInstance(40, -1, Image.SCALE_SMOOTH);
                    frame.add(new JLabel(new ImageIcon(thumbnail)));

                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }

        // invoervelden naam+ lengte in Grid
        JPanel fieldPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        fieldPanel.setBackground(Color.black);
        naamField.setForeground(Color.white);
        fieldPanel.add(naamField);

        // aantal beurten en tijd in Grid
        beurtField.setForeground(Color.white);
        fieldPanel.add(beurtField);
        tijdField.setForeground(Color.white);
        fieldPanel.add(tijdField);


        //totaal labels +invoer naam+lengte
        JPanel invoerPanel = new JPanel(new BorderLayout(10, 10));
        invoerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        invoerPanel.setBackground(Color.black);
        invoerPanel.add(fieldPanel, BorderLayout.CENTER);
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(10, 10));

        //knoppen kleuren in Flow
        JPanel knoppenPanel = new JPanel(new GridLayout(0,1,5,5));
        knoppenPanel.add(redButton);
        knoppenPanel.add(blueButton);
        knoppenPanel.add(yellowButton);
        knoppenPanel.add(greenButton);
        knoppenPanel.add(purpleButton);
        knoppenPanel.setBackground(Color.black);

        //Alle panels toevoegen
        pane.add(invoerPanel, BorderLayout.NORTH);
        pane.add(frame, BorderLayout.CENTER);
        pane.add(knoppenPanel, BorderLayout.WEST);
    }

    private void toonFrame() {
        setLocation(400, 400);
        getContentPane().setBackground(Color.black);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void updateFrame(){
        frame = new JPanel(new GridLayout(spel.getBreedte(), spel.getHoogte()));
        frame.setBackground(Color.black);
        frame.removeAll();
        frame.updateUI();
        for (int i = 0; i<spel.getBreedte(); i++){
            for(int j =0; j<spel.getHoogte(); j++){
                String path = "";
                switch (spel.getKleur(j,i)){
                    case 1: path = "./pics/gem_red.png";break;
                    case 2: path = "./pics/gem_yellow.png";break;
                    case 3: path = "./pics/gem_purple.png";break;
                    case 4: path = "./pics/gem_blue.png";break;
                    case 5: path = "./pics/gem_green.png";break;
                    case 6: path = "./pics/gem_orange.png";break;
                    case 7: path = "./pics/gem_pink.png";break;
                    case 8: path = "./pics/gem_brown.png";break;
                    case 0: path = "./pics/virus.png";break;
                    default: path = " ";break;
                }
                BufferedImage labelicon = null;
                try {
                    labelicon = ImageIO.read(getClass().getResourceAsStream(path));
                    Image thumbnail = labelicon.getScaledInstance(40, -1, Image.SCALE_SMOOTH);
                    frame.add(new JLabel(new ImageIcon(thumbnail)));

                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
        Container pane = getContentPane();
        pane.add(frame, BorderLayout.CENTER);
    }



    private int maakframe(){
        Object[] options = {"Mad Virus",
                "Super Virus"
        };
        int n = JOptionPane.showOptionDialog(startmenu,
                "welke modus wilt u graag spelen?",
                "Keuze spel",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        return n;
    }

    private void gameOver(){
        JOptionPane.showMessageDialog(startmenu, "GAME OVER");
        System.exit(1);
    }

    private void endGame(){
        try{
            FileWriter fstream = new FileWriter(spel.getNaam() + ".scr", true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(spel.getNaam()+ ": level "+ (level + 1) +" in "+ spel.getBeurt() + " beurten, " + (60 - (time/1000)) + " sec. Mode: "+ spel.getModus() +"\n");
            out.close();
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
        JOptionPane.showMessageDialog(startmenu, "Proficiat! U heeft de level uitgespeeld.");
    }

    public void verhooglevel(int virus){
        level++;
        if (level < 3){
            if (virus == 0){
                spel.reset(false,level);
                time = 60000;
            }
            else if (virus == 1){
                spel.reset(true,level);
                time = 60000;
            }
            maakLayout();
        }
        else {
            JOptionPane.showMessageDialog(startmenu, "Proficiat! U heeft Mad Virus uitgespeeld.");
            System.exit(1);
        }
    }

    private int maakMenu(){
        Object[] options = {"Nieuw Spel", "Highscores", "Uitleg"
        };
        int n = JOptionPane.showOptionDialog(startmenu,
                "Maak uw keuze",
                "Mad Virus",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        return n;
    }

    private void naamframe(){
        input = new JFrame("Mad Virus");
        JPanel mid = new JPanel(new BorderLayout());
        JPanel onder = new JPanel(new FlowLayout());
        JLabel invul2 = new JLabel("geef je naam in, aub?");
        final JTextArea invul = new JTextArea(1,5);
        JButton inorde = new JButton("Ok");
        inorde.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String name = invul.getText();
                if(name != null){
                    spel.setNaam(name);
                    input.dispose();
                    menuKeuze(maakMenu());
                }else{
                    JOptionPane.showMessageDialog(input,"gelieve een naam in te vullen", "verkeerde Input", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        onder.add(invul2,BorderLayout.WEST);
        onder.add(invul, BorderLayout.EAST);
        onder.add(inorde, BorderLayout.SOUTH);
        BufferedImage splashicon = null;
        try {
            splashicon = ImageIO.read(getClass().getResourceAsStream("./pics/splashscreen.png"));
            Image thumbnail = splashicon.getScaledInstance(400, -1, Image.SCALE_SMOOTH);
            mid.add(new JLabel(new ImageIcon(thumbnail)));

        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        input.add(mid, BorderLayout.CENTER);
        input.add(onder, BorderLayout.SOUTH);
        input.setLocation(400, 400);
        input.getContentPane().setBackground(Color.black);
        input.pack();
        input.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        input.setVisible(true);
    }
}