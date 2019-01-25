import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton{
    private int pointVal;
    private String question;
    private String answer;
    private boolean answered;
    private boolean right;
    private JButton b1;

    public Button() {
        pointVal = 0;
        question = "";
        answer = "";
        answered = false;
        right = false;
    }

    public Button(int _pointVal, String _question, String _answer) {
        pointVal = _pointVal;
        question = _question;
        answer = _answer;
        answered = false;
        right = false;

        b1 = new JButton(Integer.toString(this.getPointVal()));
        b1.setFont(new Font("Ariel", Font.BOLD, 40));
        b1.setForeground(Color.YELLOW);
        b1.setBackground(Color.BLUE);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (answered == false) {
                    String userAnswer = JOptionPane.showInputDialog(null, getQuestion(), null);
                    if (userAnswer.equals(getAnswer())) {
                        answered = true;
                        JOptionPane.showMessageDialog(null, "Correct!");
                        b1.setText("");
                        right = true;
                    } else {
                        answered = true;
                        JOptionPane.showMessageDialog(null, "Wrong. The correct answer was: \n" + getAnswer());
                        b1.setText("");
                        right = false;
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Please pick an unanswered question.");
            }
        });
    }

    public int getPointVal() {
        return pointVal;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public JButton getButton() {
        return b1;
    }

    public boolean getAnswered() {
        return answered;
    }

    public void setAnswered () {
        answered = true;
    }

    public boolean getRight() {
        return right;
    }
}