import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.ArrayList;

public class FrameEchange extends JFrame implements ActionListener{

    private ListeEchange list = new ListeEchange("Achats Banque");
    private ArrayList<String> listType = list.getListType();

    private JTextField coutTextField;
    private JTextField estimeTextField; 
    private JTextField revenuTextField;

    private JLabel coutLabel;
    private JLabel estimeLabel;
    private JLabel revenuLabel;

    private JFileChooser imageJFileChooser;

    private int coutEch;
    private int estimeEch;
    private int revenuEch;
    private String typeEch;

    private JButton ajouterImageJButton;
    private JButton ajouterButton;
    private JButton afficherListe;

    private JList<String> typeJList;
    private DefaultListModel<String> listModel;

    public FrameEchange() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Gestion d'échanges");
        this.setLocation(100, 100);

        // Initialisation des champs de texte
        coutTextField = new JTextField(10);
        estimeTextField = new JTextField(10);
        revenuTextField = new JTextField(10);
        this.coutTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        this.estimeTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        this.revenuTextField.setFont(new Font("Arial", Font.PLAIN, 18));

        // Initialisation label des champs de texte
        coutLabel   = new JLabel("Coût : ");
        estimeLabel = new JLabel("Valeur : ");
        revenuLabel = new JLabel("Revenu : ");
        this.coutLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        this.estimeLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        this.revenuLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        
        // Initialisation fileChooser
        imageJFileChooser = new JFileChooser();

        // Initialisation bouton 
        ajouterButton = new JButton("Ajouter échange");
        ajouterImageJButton  = new JButton("Ajouter image");
        afficherListe = new JButton("Afficher liste");

        // Initialisation de la liste des types avec un modèle de liste
        listModel = new DefaultListModel<>();
        for (String type : listType) {
            listModel.addElement(type);
        }
        typeJList = new JList<>(listModel);
        typeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Initialisation GridBagLayout
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        Insets insets = new Insets(1, 1, 1, 1);

        // Ajout des composants coût 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = insets;
        this.add(coutLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = insets;
        this.add(coutTextField, gbc);

        // Ajout des composants valeur estimé
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = insets;
        this.add(estimeLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = insets;
        this.add(estimeTextField, gbc);

        // Ajout des composants revenus 
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = insets;
        this.add(revenuLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = insets;
        this.add(revenuTextField, gbc);

        // Ajout de la liste des types
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(1, 5, 1, 1);
        this.add(new JScrollPane(typeJList), gbc);

        // Ajout d'un bouton pour ajouter l'échange à la liste
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.insets = new Insets(10, 50, 10, 20);
        this.add(ajouterButton, gbc);

        // Ajout d'un bouton pour afficher la liste des échanges
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.insets = new Insets(10, 20, 10, 20);
        this.add(afficherListe, gbc);

        // Ajout d'un bouton pour ajouter image
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(ajouterImageJButton, gbc);

        this.ajouterButton.addActionListener( this );
        this.afficherListe.addActionListener( this );
        this.ajouterImageJButton.addActionListener( this );

        this.pack();
        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == this.ajouterButton)
        {
            coutEch = Integer.parseInt(coutTextField.getText());
            estimeEch = Integer.parseInt(estimeTextField.getText());
            revenuEch = Integer.parseInt(revenuTextField.getText());
            typeEch = typeJList.getSelectedValue();
            this.list.ajouterEchange(new Echange(coutEch, estimeEch, revenuEch, typeEch));
        }

        if(e.getSource() == this.ajouterImageJButton)
        {
            new ImageFileChooser();
        }

        if(e.getSource() == this.afficherListe)
        {
            new FrameListeEchange(this.list).setLocation(100 + this.getWidth(), 100);
        } 
    }

    public static void main(String[] args) {
        new FrameEchange();
    }
}


