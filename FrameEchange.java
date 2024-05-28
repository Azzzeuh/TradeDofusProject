import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class FrameEchange extends JFrame {

    private ListeEchange list = new ListeEchange("Achats Banque");
    private ArrayList<String> listType = list.getListType();

    private JTextField coutTextField;
    private JTextField estimeTextField; 
    private JTextField revenuTextField;
    private JLabel coutLabel;
    private JLabel estimeLabel;
    private JLabel revenuLabel;

    private JButton ajouterButton;

    private JList<String> typeJList;
    private DefaultListModel<String> listModel;

    public FrameEchange() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Gestion d'échanges");
        this.setLocation(50, 50);
        this.setSize(900, 700); 

        // Initialisation des champs de texte
        coutTextField = new JTextField(10);
        estimeTextField = new JTextField(10);
        revenuTextField = new JTextField(10);

        // Initialisation label des champs de texte
        coutLabel   = new JLabel("Coût : ");
        estimeLabel = new JLabel("Valeur : ");
        revenuLabel = new JLabel("Revenu : ");

        // Initialisation bouton ajouter un échange
        ajouterButton = new JButton(" Ajouter ");

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
        

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FrameEchange();
    }
}

