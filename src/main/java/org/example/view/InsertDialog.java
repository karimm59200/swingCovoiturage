package org.example.view;



import org.example.model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.dao.UsersDAO;

public class InsertDialog extends JDialog {

    private JPanel contentPanel;
    private JTextField txtName;
    private JTextField txtEmail;

    private JCheckBox checkBoxDriver;
    private JTextField txtPassword;


    public static void main(String[] args) {
        InsertDialog dialog = new InsertDialog();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    public InsertDialog() {
contentPanel = new JPanel();
        setTitle("AJOUT UTILISATEUR");
        setBounds(100,100, 350,300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        txtEmail = new JTextField();
        txtEmail.setBounds(80, 50,80, 20);
        contentPanel.add(txtEmail);
        txtEmail.setColumns(10);

        txtName = new JTextField();
        txtName.setBounds(80, 20,80, 20);
        contentPanel.add(txtName);
        txtName.setColumns(10);

        checkBoxDriver = new JCheckBox("Driver");
        checkBoxDriver.setBounds(80, 80,80, 20);
        contentPanel.add(checkBoxDriver);

        txtPassword = new JTextField();

        txtPassword.setBounds(80, 110,80, 20);
        contentPanel.add(txtPassword);
        txtPassword.setColumns(10);




        JLabel labelName = new JLabel("Name");
        labelName.setBounds(10,20,50,15);
        contentPanel.add(labelName);

        JLabel labelNumber = new JLabel("Email");
        labelNumber.setBounds(10,50,50,15);
        contentPanel.add(labelNumber);

        JLabel labelDriver = new JLabel("Driver");
        labelDriver.setBounds(10,80,50,15);
        contentPanel.add(labelDriver);

        JLabel labelPassword = new JLabel("Pwd");
        labelPassword.setBounds(10,110,50,15);
        contentPanel.add(labelPassword);


        JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(jPanelButton, BorderLayout.SOUTH);

        JButton jButtonOK = new JButton("OK");
        jButtonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                User user = new User();
                user.setName(txtName.getText());
                user.setEmail(txtEmail.getText());
                if(checkBoxDriver.isSelected()) {
                    user.setDriver(true);
                } else {
                    user.setDriver(false);
                }
                user.setPassword(txtPassword.getText());
                UsersDAO userDao = new UsersDAO();

               int count = userDao.addUser(user);
                if(count>0){
                    JOptionPane.showConfirmDialog(null, "Add operation success");

                }else{
                    JOptionPane.showConfirmDialog(null, "Error Record");
                }
                dispose();
            }
        });
        jPanelButton.add(jButtonOK);

        JButton jButtonCancel = new JButton("Cancel");
       // contentPanel.add(jButtonCancel);
        jPanelButton.add(jButtonCancel);
        jButtonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });



    }
}
