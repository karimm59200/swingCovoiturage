package org.example.view;

import org.example.model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogingUI extends JFrame {

    private final JPanel contentPanel = new JPanel();
    private JTextField userName;
    private JTextField password;

    public LogingUI() {

        JFrame frame = new JFrame();
        frame = new JFrame("Login admin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);


        JLabel loginLabel = new JLabel("Login");
        loginLabel.setBounds(10, 42, 46, 14);
        contentPanel.add(loginLabel);


        userName = new JTextField();
        userName.setColumns(10);
        userName.setBounds(150, 39, 86, 20);
        contentPanel.add(userName);


        JLabel passowrdLabel = new JLabel("Password");
        passowrdLabel.setBounds(10, 72, 100, 14);
        contentPanel.add(passowrdLabel);


        password = new JTextField();
        password .setColumns(10);
        password .setBounds(150, 69, 86, 20);
        contentPanel.add(password );

        JButton buttonLogin = new JButton("Login");
        buttonLogin.setVisible(true);
        buttonLogin.setBounds(80,100,75,25);

        JButton canLogin = new JButton("Cancel2");
        canLogin.setVisible(true);
        canLogin.setBounds(170,100,80,25);

        frame.add(buttonLogin);
        frame.add(canLogin);


        frame.add(contentPanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel buttonPane = new JPanel();


        getContentPane().add(buttonPane, BorderLayout.SOUTH);

;
        JFrame finalFrame = frame;
        finalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(userName.getText().toLowerCase().equals("karim") &&
                        password.getText().toLowerCase().equals("karim")){
                    JOptionPane.showMessageDialog(null, "Login Successfully!!!");
                    finalFrame.dispose();
                    new UsersUI();
                }else{
                    JOptionPane.showMessageDialog(null, "Wrong Login !!!");
                }
                dispose();

            }
        });
        buttonLogin.setActionCommand("OK");

;
        canLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                finalFrame.dispose();
            }
        });
        canLogin.setActionCommand("Cancel");

    }

}
