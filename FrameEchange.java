import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class FrameEchange extends JFrame {

    private ListeEchange list = new ListeEchange("Achats Banque");
    private ArrayList<String> listType = list.getListType();

    private JTextField coutTextField;
    private JTextField estimeTextField; 
    private JTextField revenuTextField;
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

        // Initialisation de la liste des types avec un modèle de liste
        listModel = new DefaultListModel<>();
        for (String type : listType) {
            listModel.addElement(type);
        }
        typeJList = new JList<>(listModel);

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Ajout des composants avec GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(coutTextField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(estimeTextField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        this.add(revenuTextField, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        this.add(new JScrollPane(typeJList), gbc);  // Ajout d'un JScrollPane pour la JList

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FrameEchange();
    }
}

