package org.example.view;

import org.example.controller.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import org.example.dao.CommentDAO;
import org.example.model.Comment;
import org.example.utils.UserTableModel;
public class UsersUI extends JFrame {
    private UserService userService;
    private JFrame frame;
    private JTable usersTable;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;




public UsersUI() {
        this.userService = new UserService();
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


    addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           // openAjoutDialog();
            InsertDialog insertDialog = new InsertDialog();
            insertDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            insertDialog.setSize(400, 300);
            insertDialog.setLocationRelativeTo(null);
            insertDialog.setVisible(true);
            refreshTable();

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


        CommentDAO commentDAO=new CommentDAO();
        commentDAO.insertComment(new Comment(0,10,"salut test commentaire"));
        commentDAO.insertComment(new Comment(1,8,"salut test commentaire2"));

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addButton);
    buttonPanel.add(updateButton);
    buttonPanel.add(deleteButton);


    frame.setLayout(new BorderLayout());
    frame.add(new JScrollPane(usersTable), BorderLayout.CENTER);
    frame.add(buttonPanel, BorderLayout.SOUTH);

    frame.setVisible(true);
        usersTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                row = userService.getAllUsers().get(table.convertRowIndexToModel(row)).getId();
                CommentDAO commentDAO=new CommentDAO();
                List<Comment> comments = commentDAO.getCommentByTripId(row);
                //commentDAO.deleteAllComments();
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    // your valueChanged overridden method
                    Profil profilDialog = new Profil(row, comments);
                }
            }
        });


    }

    public void refreshTable() {
        UserTableModel userTableModel = new UserTableModel(userService.getAllUsers());
        userTableModel.fireTableDataChanged();
        usersTable.setModel(userTableModel);

    }

    }







