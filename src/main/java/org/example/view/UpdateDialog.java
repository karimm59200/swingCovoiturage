package org.example.view;




import org.example.controller.UserService;
import org.example.model.User;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtEmail;

	private JCheckBox checkBoxDriver;
	private JTextField txtId;

	private UserService userService = new UserService();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			UpdateDialog dialog = new UpdateDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public UpdateDialog() {

		setTitle("Update user"); // Définit le titre de la boîte de dialogue
		setBounds(100, 100, 350, 200); // Définit la position et la taille de la boîte de dialogue

// Configuration du contenu de la boîte de dialogue
		getContentPane().setLayout(new BorderLayout()); // Utilise un layout BorderLayout pour organiser le contenu
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // Définit une marge vide autour du contenu
		getContentPane().add(contentPanel, BorderLayout.CENTER); // Ajoute le panneau de contenu au centre
		contentPanel.setLayout(null); // Utilise un layout nul (absolu) pour positionner les composants

// Création des composants graphiques de la boîte de dialogue

// Étiquette pour le champ "Name"
		JLabel lblName = new JLabel("Name");
		lblName.setEnabled(false); // Désactive l'étiquette (non cliquable)
		lblName.setBounds(10, 42, 46, 14); // Position et taille de l'étiquette
		contentPanel.add(lblName); // Ajoute l'étiquette au panneau de contenu

// Champ de texte pour le nom
		txtName = new JTextField();
		txtName.setEnabled(false); // Désactive le champ de texte (non modifiable)
		txtName.setColumns(10); // Définit la largeur du champ de texte
		txtName.setBounds(85, 39, 86, 20); // Position et taille du champ de texte
		contentPanel.add(txtName); // Ajoute le champ de texte au panneau de contenu

// Étiquette pour le champ "Number"
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setEnabled(false); // Désactive l'étiquette
		lblEmail.setBounds(10, 72, 46, 14); // Position et taille de l'étiquette
		contentPanel.add(lblEmail); // Ajoute l'étiquette au panneau de contenu

// Champ de texte pour le email
		txtEmail = new JTextField();
		txtEmail .setEnabled(false); // Désactive le champ de texte
		txtEmail .setColumns(10); // Définit la largeur du champ de texte
		txtEmail .setBounds(85, 69, 86, 20); // Position et taille du champ de texte
		contentPanel.add(txtEmail ); // Ajoute le champ de texte au panneau de contenu

// Étiquette pour le champ "ID"
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 14, 46, 14); // Position et taille de l'étiquette
		contentPanel.add(lblId); // Ajoute l'étiquette au panneau de contenu

// Champ de texte pour l'ID
		txtId = new JTextField();
		txtId.setColumns(10); // Définit la largeur du champ de texte
		txtId.setBounds(85, 11, 86, 20); // Position et taille du champ de texte
		contentPanel.add(txtId); // Ajoute le champ de texte au panneau de contenu

		JLabel lblDriver = new JLabel("Driver");
		lblDriver.setEnabled(false);
		lblDriver.setBounds(10, 104, 46, 14);
		contentPanel.add(lblDriver);

		checkBoxDriver = new JCheckBox("Driver");
		checkBoxDriver.setBounds(85, 100, 97, 23);
		checkBoxDriver.setEnabled(false);
		contentPanel.add(checkBoxDriver);



		// Crée un bouton "Search" avec le libellé "Search"
		JButton btnSearch = new JButton("Search");

// Ajoute un écouteur d'événements au bouton "Search"
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtName.setEnabled(true);
				txtEmail.setEnabled(true);
				checkBoxDriver.setEnabled(true);
				// Crée une instance de ContactDAO pour interagir avec la base de données
				//ContactDAO cDAO = new ContactDAO();
				// Récupère l'ID saisi dans le champ de texte "txtId" et le convertit en entier
				int id = Integer.parseInt(txtId.getText());

				// Recherche le contact correspondant à l'ID dans la base de données
				//Contact contact = cDAO.searchContact(id);
				User user = userService.getUserById(id);

				// Vérifie si le contact a été trouvé
				if (user != null) {
					// Met à jour les champs de texte avec les détails du contact
					txtName.setText(user.getName());
					txtEmail.setText(user.getEmail());
					checkBoxDriver.setSelected(user.isDriver());



					// Active les champs de texte pour le nom et le numéro
//					txtName.setEnabled(true);
//					txtEmail.setEnabled(true);
//					checkBoxDriver.setEnabled(true);

					//txtNumber.setEnabled(true);

					// Active l'étiquette "Name"
					lblName.setEnabled(true);
					lblEmail.setEnabled(true);
					lblDriver.setEnabled(true);

					// Désactive l'étiquette "Number"
					//lblNumber.setEnabled(false);
					lblName.setEnabled(false);
					lblEmail.setEnabled(false);
					lblDriver.setEnabled(false);

					// Désactive le champ de texte pour l'ID
					txtId.setEnabled(false);
				} else {
					// Affiche un message d'erreur si aucun enregistrement n'a été trouvé pour l'ID donné
					JOptionPane.showMessageDialog(null, "Record Not Found For Given ID!!!");
				}
			}
		});

// Définit la position et la taille du bouton "Search"
		btnSearch.setBounds(181, 10, 89, 23);

		// Ajoute le bouton "Search" au panneau de contenu de la boîte de dialogue
		contentPanel.add(btnSearch);

// Crée un nouveau panneau pour les boutons en bas de la boîte de dialogue
		JPanel buttonPane = new JPanel();

// Définit le layout du panneau de boutons comme un FlowLayout aligné à droite
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

// Ajoute le panneau de boutons en bas de la boîte de dialogue, en utilisant le layout BorderLayout
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

// Crée un bouton "OK" pour valider les modifications du contact
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Crée une instance de Contact avec les informations saisies dans les champs de texte
//				Contact contact = new Contact();
//				contact.setId(Integer.parseInt(txtId.getText()));
//				contact.setName(txtName.getText());
//				contact.setNumber(txtNumber.getText());



				User user = new User();
				user.setId(Integer.parseInt(txtId.getText()));
				user.setName(txtName.getText());
				user.setEmail(txtEmail.getText());
				user.setDriver(checkBoxDriver.isSelected());

				// Crée une instance de ContactDAO pour interagir avec la base de données
				//ContactDAO cDAO = new ContactDAO();

				// Met à jour le contact dans la base de données et récupère le nombre de lignes modifiées
				//int count = cDAO.updateContact(contact);
				int count = userService.updateUser(user);

				// Vérifie si la mise à jour a été effectuée avec succès
				if (count >= 0) {
					JOptionPane.showMessageDialog(null, "Record Updated Successfully!!!");
				} else {
					JOptionPane.showMessageDialog(null, "Record Can't Updated !!!");
				}

				// Ferme la boîte de dialogue après la mise à jour
				dispose();
			}
		});
		okButton.setActionCommand("OK");

// Ajoute le bouton "OK" au panneau de boutons
		buttonPane.add(okButton);

// Définit le bouton "OK" comme bouton par défaut (appuyer sur Entrée équivaut à cliquer sur "OK")
		getRootPane().setDefaultButton(okButton);

// Crée un bouton "Cancel" pour annuler la mise à jour et fermer la boîte de dialogue
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ferme la boîte de dialogue sans effectuer de mise à jour
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");

// Ajoute le bouton "Cancel" au panneau de boutons
		buttonPane.add(cancelButton);

	}
}