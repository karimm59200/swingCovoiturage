package org.example.view;




import org.example.controller.UserService;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtId;

    private UserService userService = new UserService();


    public static void main(String[] args) {
        try {
            DeleteDialog dialog = new DeleteDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public DeleteDialog() {
        // Définit le titre de la boîte de dialogue "Delete Contact"
        setTitle("Delete user");

// Définit la position et la taille de la boîte de dialogue
        setBounds(100, 100, 350, 200);

// Utilise un layout BorderLayout pour le contenu de la boîte de dialogue
        getContentPane().setLayout(new BorderLayout());

// Crée un panneau de contenu avec une bordure vide
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

// Utilise un layout nul (absolu) pour le panneau de contenu
        contentPanel.setLayout(null);

// Crée une étiquette "ID" pour indiquer le champ d'identification
        JLabel lblId = new JLabel("ID");
        lblId.setBounds(22, 14, 27, 14);
        contentPanel.add(lblId);

// Crée un champ de texte pour saisir l'ID du contact à supprimer
        txtId = new JTextField();
        txtId.setBounds(54, 11, 86, 20);
        txtId.setColumns(10);
        contentPanel.add(txtId);

// Crée un panneau de boutons en bas de la boîte de dialogue
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        {
            // Crée un bouton "OK"
            JButton okButton = new JButton("OK");

            // Ajoute un écouteur d'action au bouton "OK"
            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Récupère l'ID à partir du champ de texte txtId
                    int id = Integer.parseInt(txtId.getText());

                    // Crée une instance de ContactDAO pour gérer les opérations sur les contacts
                   // ContactDAO cDAO = new ContactDAO()

                    // Appelle la méthode de suppression du contact dans la base de données
                   // int count = cDAO.deleteContact(id);
                    int count = userService.deleteUser(id);

                    // Affiche le résultat de la suppression dans la console
                    System.out.println("Result : " + count);

                    // Affiche un message à l'utilisateur en fonction du résultat de la suppression
                    if (count > 0) {
                        JOptionPane.showMessageDialog(null, "Record Deleted Successfully!!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Record Can't Deleted !!!");
                    }

                    // Ferme la boîte de dialogue après avoir effectué l'opération
                    dispose();
                    UsersUI usersUI = new UsersUI();
                    usersUI.refreshTable();

                }
            });

            // Définit l'action associée au bouton "OK"
            okButton.setActionCommand("OK");

            // Ajoute le bouton "OK" au panneau de boutons
            buttonPane.add(okButton);

            // Définit le bouton "OK" comme bouton par défaut de la boîte de dialogue
            getRootPane().setDefaultButton(okButton);
        }


        {
            // Crée un bouton "Cancel"
            JButton cancelButton = new JButton("Cancel");

            // Ajoute un écouteur d'action au bouton "Cancel"
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    // Ferme la boîte de dialogue lorsque le bouton "Cancel" est cliqué
                    dispose();
                }
            });

            // Définit l'action associée au bouton "Cancel"
            cancelButton.setActionCommand("Cancel");

            // Ajoute le bouton "Cancel" au panneau de boutons
            buttonPane.add(cancelButton);
        }

    }
}


