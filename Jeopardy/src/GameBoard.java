import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.*;

public class GameBoard{
    private java.util.List<Button> assemblyQs = new ArrayList<>();
    private java.util.List<Button> javaQs = new ArrayList<>();
    private java.util.List<Button> cQs = new ArrayList<>();
    private java.util.List<Button> pythonQs = new ArrayList<>();
    private List<Button> javascriptQs = new ArrayList<>();
    protected int score = 0;
    private JLabel gameScore = new JLabel();
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JPanel gameScreen;

    GameBoard() {
        initializeGui();
    }

    public final void initializeGui() {

        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        JLabel scoreBoard = new JLabel("Score");
        scoreBoard.setFont(new Font("Ariel", Font.BOLD, 20));
        tools.add(scoreBoard);
        tools.addSeparator();
        gameScore.setText(Integer.toString(score));
        gameScore.setFont(new Font("Ariel", Font.BOLD, 20));
        tools.add(gameScore);

        gui.add(new JLabel("?"), BorderLayout.LINE_START);

        gameScreen = new JPanel(new GridLayout(0, 5));
        gameScreen.setBorder(new LineBorder(Color.BLACK));
        gui.add(gameScreen);

        createCategories();

        createButtons();

        // Adds the buttons in order to the game screen
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                gameScreen.add(assemblyQs.get(j).getButton());
                gameScreen.add(javaQs.get(j).getButton());
                gameScreen.add(cQs.get(j).getButton());
                gameScreen.add(pythonQs.get(j).getButton());
                gameScreen.add(javascriptQs.get(j).getButton());
            }
        }
    }

    public void createCategories() {
        JLabel firstCat = new JLabel("Assembly");
        firstCat.setFont(new Font("Ariel", Font.BOLD, 30));
        gameScreen.add(firstCat);

        JLabel secondCat = new JLabel("Java");
        secondCat.setFont(new Font("Ariel", Font.BOLD, 30));
        gameScreen.add(secondCat);

        JLabel thirdCat = new JLabel("C++");
        thirdCat.setFont(new Font("Ariel", Font.BOLD, 30));
        gameScreen.add(thirdCat);

        JLabel fourthCat = new JLabel("Python");
        fourthCat.setFont(new Font("Ariel", Font.BOLD, 30));
        gameScreen.add(fourthCat);

        JLabel fifthCat = new JLabel("Javascript");
        fifthCat.setFont(new Font("Ariel", Font.BOLD, 30));
        gameScreen.add(fifthCat);
    }

    public void createButtons() {

        // Assembly Questions
        Button a1 = new Button(200, "How many bits are in a byte?", "8");
        Button a2 = new Button(400, "Fetch, Decode, and ______", "Execute");
        Button a3 = new Button(600, "'ALU' stands for: ", "Arithmetic Logic Unit");
        Button a4 = new Button(800, "Is a 'DWORD' signed or unsigned?", "Unsigned");
        Button a5 = new Button(1000, "This flag will become '1' if a value is too large for its register", "Carry Flag");
        assemblyQs.add(a1);
        assemblyQs.add(a2);
        assemblyQs.add(a3);
        assemblyQs.add(a4);
        assemblyQs.add(a5);

        // Does not give buttons scoring functionality
        /* for (int i = 0; i < assemblyQs.size(); i++) {
            int finalI = i;
            assemblyQs.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (assemblyQs.get(finalI).getAnswered() == true) {
                        if (assemblyQs.get(finalI).getRight() == true) {
                            score = assemblyQs.get(finalI).getPointVal() + score;
                            gameScore.setText(Integer.toString(score));
                        } else {
                            score = score - assemblyQs.get(finalI).getPointVal();
                            gameScore.setText(Integer.toString(score));
                        }
                    }
                }
            }); */

            // Java Questions
            Button j1 = new Button(200, "Will 'System.out.println(String s)' will print a new line?", "Yes");
            Button j2 = new Button(400, "This class in java.util will scan text", "Scanner");
            Button j3 = new Button(600, "Using the word 'implements' while declaring a class will implement a(n) ______", "Interface");
            Button j4 = new Button(800, "'Integer.parseInt(String s)' will turn string s into a(n) ____", "Integer");
            Button j5 = new Button(1000, "This is a collection of classes and interfaces that provide a high level layer of access protection and namespace management", "Package");
            javaQs.add(j1);
            javaQs.add(j2);
            javaQs.add(j3);
            javaQs.add(j4);
            javaQs.add(j5);

            // C++ Questions
            Button c1 = new Button(200, "What library uses 'cin' and 'cout'?", "Iostream");
            Button c2 = new Button(400, "what key word is used to indicate that a function does not have a return value?", "Void");
            Button c3 = new Button(600, "If you want to assign a value to a variable, you use this many equal signs", "1");
            Button c4 = new Button(800, "Dynamic memory allocation is specified using what keyword?", "new");
            Button c5 = new Button(1000, "Is 'void fooMutate( int &x )' Pass-by-value or Pass-by-reference?", "Pass-by-reference");
            cQs.add(c1);
            cQs.add(c2);
            cQs.add(c3);
            cQs.add(c4);
            cQs.add(c5);

            // Python Questions
            Button p1 = new Button(200, "What is the output of print = 'Hello'", "Hello");
            Button p2 = new Button(400, "Is String a supported data type in python?", "Yes");
            Button p3 = new Button(600, "Is LIST or TUPLES faster?", "TUPLES");
            Button p4 = new Button(800, "Suppose list1 is [2, 33, 222, 14, 25], What is list1[-1] ?", "25");
            Button p5 = new Button(1000, "Can True = False be possible in Python?", "No");
            pythonQs.add(p1);
            pythonQs.add(p2);
            pythonQs.add(p3);
            pythonQs.add(p4);
            pythonQs.add(p5);

            // Javascript Questions
            Button js1 = new Button(200, "Are Java and JavaScript different?", "Yes");
            Button js2 = new Button(400, "What would be the result of 3+2+'7'?", "57");
            Button js3 = new Button(600, "Is there a difference between 'undefine' and 'NULL'?", "Yes");
            Button js4 = new Button(800, "What does DOM stands for?", "Document Object Model");
            Button js5 = new Button(1000, "What does BOM Stans for?", "Browder Object Model");
            javascriptQs.add(js1);
            javascriptQs.add(js2);
            javascriptQs.add(js3);
            javascriptQs.add(js4);
            javascriptQs.add(js5);
    }


    public final JComponent getGui() {
        return gui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                GameBoard gb = new GameBoard();

                JFrame f = new JFrame("Jeopardy");
                f.add(gb.getGui());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();

                // ensures the minimum size is enforced.
                f.setMaximumSize(f.getSize());
                f.setVisible(true);

                // Creates sound
                try {
                    // Open an audio input stream.
                    File soundFile = new File("energy.wav"); //you could also get the sound file with an URL
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

                    // Get a sound clip resource.
                    Clip clip = AudioSystem.getClip();

                    // Open audio clip and load samples from the audio input stream.
                    clip.open(audioIn);
                    clip.start();

                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        };
        SwingUtilities.invokeLater(r);
    }
}
