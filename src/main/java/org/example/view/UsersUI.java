package org.example.view;

import org.example.controller.UsersController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.utils.UserTableModel;
public class UsersUI extends JFrame {
    private UsersController usersController;
    private JFrame frame;
    private JTable usersTable;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton profilButton;

public UsersUI() {
        this.usersController = new UsersController();
        initializeUI();
    }

    private void initializeUI(){

    JFrame frame = new JFrame();
    frame = new JFrame("Gestion des Utilisateurs");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);

    usersTable = new JTable();
    refreshTable();

    addButton = new JButton("Ajouter");
    updateButton = new JButton("Modifier");
    deleteButton = new JButton("Supprimer");
    profilButton = new JButton("Profil");

    addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           // openAjoutDialog();
            InsertDialog insertDialog = new InsertDialog();
            insertDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            insertDialog.setSize(400, 300);
            insertDialog.setLocationRelativeTo(null);
            insertDialog.setVisible(true);

        }

    });

    updateButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           // openModificationDialog();
            UpdateDialog updateDialog = new UpdateDialog();
            updateDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            updateDialog.setSize(400, 300);
            updateDialog.setLocationRelativeTo(null);
            updateDialog.setVisible(true);

        }
    });

    deleteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //openSuppressionDialog();
            DeleteDialog deleteDialog = new DeleteDialog();
            deleteDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            deleteDialog.setSize(400, 300);
            deleteDialog.setLocationRelativeTo(null);
            deleteDialog.setVisible(true);
        }
    });

    profilButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //openProfilDialog();
            Profil profilDialog = new Profil();



        }
    });

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addButton);
    buttonPanel.add(updateButton);
    buttonPanel.add(deleteButton);
    buttonPanel.add(profilButton);

    frame.setLayout(new BorderLayout());
    frame.add(new JScrollPane(usersTable), BorderLayout.CENTER);
    frame.add(buttonPanel, BorderLayout.SOUTH);

    frame.setVisible(true);


    }

    private void refreshTable() {
        UserTableModel userTableModel = new UserTableModel(usersController.getAllUsers());
        usersTable.setModel(userTableModel);

    }

    }







