package org.example.view;


import javax.swing.*;
import java.awt.*;



public class Profil extends JFrame {

    private JFrame frame;
    private JPanel panel1;

    private JTextField textFieldName;
    private JLabel label1;

    private JTextField textFieldPrenom;
    private JLabel label2;

    private JTextField textFieldEmail;
    private JLabel label3;
    private JLabel label4;

    private JPanel panelImage;

    private JButton buttonForPicture;






    public Profil()  {


        frame = new JFrame("Profil");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        panel1 = new JPanel();
        panel1.setLayout(null);

        panelImage = new JPanel();
//        Image icon = Toolkit.getDefaultToolkit().getImage("src/main/resources/images/user.png");
//        frame.setIconImage(icon);
        JButton buttonForPicture = new JButton(" une image");
        buttonForPicture.setBounds(50, 50, 100, 100);
        buttonForPicture.setBackground(Color.WHITE);
        buttonForPicture.add(new JLabel(new ImageIcon("src/main/resources/images/user.png")));
        panelImage.setBounds(50, 50, 100, 100);
        panelImage.setBackground(Color.WHITE);
        //panelImage.add(new JLabel(new ImageIcon("src/main/resources/images/user.png")));
        panelImage.add(buttonForPicture);
        panel1.add(panelImage);


        label1 = new JLabel("Profil");
        label1.setBounds(350, 50, 150, 30);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        panel1.add(label1);

        label2 = new JLabel("Nom :");
        label2.setBounds(200, 100, 150, 30);
        panel1.add(label2);

        textFieldName = new JTextField();
        textFieldName.setBounds(300, 100, 150, 30);
        textFieldName.setEditable(false);
        panel1.add(textFieldName);


        label3 = new JLabel("Prenom :");
        label3.setBounds(200, 150, 100, 30);
        panel1.add(label3);

        textFieldPrenom = new JTextField();
        textFieldPrenom.setBounds(300, 150, 100, 30);
        textFieldPrenom.setEditable(false);
        panel1.add(textFieldPrenom);

        label4 = new JLabel("Email :");
        label4.setBounds(200, 200, 100, 30);
        panel1.add(label4);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(300, 200, 100, 30);
        textFieldEmail.setEditable(false);
        panel1.add(textFieldEmail);




        frame.add(panel1);
        frame.setVisible(true);
    }



}
