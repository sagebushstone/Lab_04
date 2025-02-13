import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    JPanel mainPnl;
    JPanel topPnl;
    JPanel midPnl;
    JPanel bottomPnl;

    JLabel titleLbl = new JLabel("Fortune Teller");
    ImageIcon icon;

    JButton quitBtn;
    JButton newFortune;

    JTextArea displayTA;
    JScrollPane scroller;
    JScrollPane outerScroller;

    ArrayList<String> fortunes = new ArrayList<>();
    int prevFortune = -1;

    public FortuneTellerFrame(){
        addFortunes();
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        createTopPanel();
        createMidPanel();
        createBottomPanel();

        mainPnl.add(topPnl, BorderLayout.NORTH);
        mainPnl.add(midPnl, BorderLayout.CENTER);
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        outerScroller = new JScrollPane(mainPnl);

        setSize(500, 700);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);


        setTitle("Fortune Teller Bushstone");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(outerScroller);
        setVisible(true);
    }

    private void addFortunes() {
        fortunes.add("The Force is strong with this one.");
        fortunes.add("Do or do not, there is no try.");
        fortunes.add("Curiosity is a choice.");
        fortunes.add("No one is immune from failure.");
        fortunes.add("Fear is the path to the dark side.");
        fortunes.add("Your focus determines your reality.");
        fortunes.add("Train yourself to let go of everything you fear to lose.");
        fortunes.add("You are one with the Force, and the Force is with you.");
        fortunes.add("Authority can be given, but leadership must be earned.");
        fortunes.add("Rebellions are built on hope.");
        fortunes.add("Failure to act always brings consequences.");
        fortunes.add("One may learn a great deal of a people by the stories they tell of others.");
        fortunes.add("There is no such thing as luck.");
    }

    private void createTopPanel(){
        topPnl = new JPanel();
        icon = new ImageIcon("src/fortune_teller.jpg");
        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLbl.setFont(new Font("Serif", Font.PLAIN, 30));
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        topPnl.add(titleLbl);
    }

    private void createMidPanel(){
        midPnl = new JPanel();

        displayTA = new JTextArea(15, 40);
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);


        midPnl.add(scroller);
    }

    private void createBottomPanel(){
        bottomPnl = new JPanel();
        bottomPnl.setLayout(new GridLayout(1, 2));

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        newFortune = new JButton("Read My Fortune!");
        newFortune.addActionListener((ActionEvent ae) -> {
            int currFortune;
            do {
                Random rand = new Random();
                currFortune = rand.nextInt(fortunes.size());
            } while (currFortune == prevFortune);

            prevFortune = currFortune;
            displayTA.append(fortunes.get(currFortune) + "\n");
        });

        bottomPnl.add(newFortune);
        bottomPnl.add(quitBtn);
    }
}
