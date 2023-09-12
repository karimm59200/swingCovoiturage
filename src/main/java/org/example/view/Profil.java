package org.example.view;


import org.example.controller.UserService;
import org.example.model.Comment;
import org.example.model.User;
import org.example.utils.CommentTableModel;
import org.example.utils.UserTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class Profil extends JFrame {

    private JFrame frame;
    private JPanel panel1;

    private JTextField textFieldName;

    private JLabel labelProfil;

    private JTextField textFieldPrenom;
    private JLabel labelName;

    private JTextField textFieldEmail;
    private JLabel labelFirstName;
    private JLabel labelEmail;

    private JPanel panelImage;

    private UserService userService = new UserService();

    private JButton backButton;
    private JTable commentsTable;



    public Profil(int id, List<Comment> commentList)  {

        User user = userService.getUserById(id);


        frame = new JFrame("Profil");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        panel1 = new JPanel();
        panel1.setLayout(null);

        panelImage = new JPanel();
//        Image icon = Toolkit.getDefaultToolkit().getImage("src/main/resources/images/user.png");
//        frame.setIconImage(icon);
//

        panelImage.setBounds(20, 20, 100, 100);
        panelImage.setBackground(Color.WHITE);
        //panelImage.add(new JLabel(new ImageIcon("src/main/resources/images/user.png")));
//        panelImage.add();
        panel1.add(panelImage);


        labelProfil = new JLabel("Profil");
        labelProfil.setBounds(350, 50, 150, 30);
        labelProfil.setFont(new Font("Arial", Font.BOLD, 20));
        panel1.add(labelProfil);

        labelName = new JLabel("Nom :");
        labelName.setBounds(200, 100, 150, 30);
        panel1.add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(300, 100, 150, 30);
        textFieldName.getText();
        textFieldName.setEditable(false);
        textFieldName.setText(user.getName());
        panel1.add(textFieldName);


        labelFirstName = new JLabel("Conducteur :");
        labelFirstName.setBounds(200, 150, 100, 30);
        panel1.add( labelFirstName);

        textFieldPrenom = new JTextField();
        textFieldPrenom.setBounds(300, 150, 100, 30);
        textFieldPrenom.setEditable(false);
        textFieldPrenom.setText(String.valueOf(user.isDriver()));
        panel1.add(textFieldPrenom);

        labelEmail = new JLabel("Email :");
        labelEmail.setBounds(200, 200, 100, 30);
        panel1.add(labelEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(300, 200, 100, 30);
        textFieldEmail.setEditable(false);
        textFieldEmail.setText(user.getEmail());
        panel1.add(textFieldEmail);

        commentsTable = new JTable();
        CommentTableModel commentTableModel = new CommentTableModel(commentList);
        commentTableModel.fireTableDataChanged();
        commentsTable.setModel(commentTableModel);


        backButton = new JButton("Retour");
        backButton.setBounds(300, 250, 100, 30);
        panel1.add(backButton);

        JPanel tabelPanel= new JPanel();
        tabelPanel.add(new JScrollPane(commentsTable),BorderLayout.SOUTH);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // retour vers UsersUI
            UsersUI usersUI = new UsersUI();
            dispose();
            }
        });
// create a separator
        JSeparator s = new JSeparator();
        JSplitPane pane = new JSplitPane( JSplitPane.VERTICAL_SPLIT,
                panel1, tabelPanel );
        // set layout as vertical
        frame.add(pane, BorderLayout.CENTER);
        frame.setVisible(true);
    }



}
