import java.awt.*;
import javax.swing.*;

public class FrameEchange extends JFrame {
    private JTextField coutTextField;
    private JTextField estimeTextField; 
    private JTextField revenuTextField;
    private JTextField typeTextField;

    public FrameEchange() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Gestion d'échanges");
        this.setLocation(50, 50);

        // Initialisation des champs de texte
        coutTextField = new JTextField(20);
        estimeTextField = new JTextField(20);
        revenuTextField = new JTextField(20);
        typeTextField = new JTextField(20);

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
        this.add(typeTextField, gbc);

        // Autres composants peuvent être ajoutés ici

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FrameEchange();
    }
}
