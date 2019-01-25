/*
 * Java
 * Katherinne Cruz
 * Janterm 2019
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class Login {

    private JFrame frame;
    private JTextField UsernameTxt;
    private JPasswordField PasswordTxt;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Login()
    {
        initialize();
    }


    /**
     * Initialize the contents of the frame.
     * size of fame and it makes it visual
     * all buttons and user input are here
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Tamil Sangam MN", Font.PLAIN, 14));
        frame.setBounds(200, 200, 550, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Final Project");
        lblTitle.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 25));
        lblTitle.setBounds(148, 6, 162, 26);
        frame.getContentPane().add(lblTitle);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Tamil Sangam MN", Font.PLAIN, 14));
        lblUsername.setBounds(35, 78, 74, 16);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tamil Sangam MN", Font.PLAIN, 14));
        lblPassword.setBounds(35, 144, 74, 16);
        frame.getContentPane().add(lblPassword);

        UsernameTxt = new JTextField();
        UsernameTxt.setBounds(132, 73, 206, 26);
        frame.getContentPane().add(UsernameTxt);
        UsernameTxt.setColumns(10);

        PasswordTxt = new JPasswordField();
        PasswordTxt.setBounds(132, 140, 206, 21);
        frame.getContentPane().add(PasswordTxt);

        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Tamil Sangam MN", Font.PLAIN, 20));

        //there are 3 logins to sign in
        //Checks if the password and username are correct if not it will output login error
        btnLogin.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String Password = PasswordTxt.getText();
                String Username = UsernameTxt.getText();

                if (Password.contains("bob1") && Username.contains("Bob"))
                {
                    PasswordTxt.setText(null);
                    UsernameTxt.setText(null);
                }
                else if (Password.contains("pete1") && Username.contains("Pete"))
                {
                    PasswordTxt.setText(null);
                    UsernameTxt.setText(null);
                }
                else if (Password.contains("tucker1") && Username.contains("Tucker"))
                {
                    PasswordTxt.setText(null);
                    UsernameTxt.setText(null);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid login, Please try again", "login Error", JOptionPane.ERROR_MESSAGE);
                    PasswordTxt.setText(null);
                    UsernameTxt.setText(null);
                }

            }
        });
        btnLogin.setBounds(175, 219, 126, 49);
        frame.getContentPane().add(btnLogin);

        JSeparator separator = new JSeparator();
        separator.setBounds(6, 203, 438, 16);
        frame.getContentPane().add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(6, 34, 438, 12);
        frame.getContentPane().add(separator_1);

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Tamil Sangam MN", Font.PLAIN, 13));
        btnClear.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                UsernameTxt.setText(null);
                PasswordTxt.setText(null);
            }
        });
        btnClear.setBounds(16, 230, 93, 29);
        frame.getContentPane().add(btnClear);
    }
}
