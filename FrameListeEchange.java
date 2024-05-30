import java.awt.*;
import javax.swing.*;

public class FrameListeEchange extends JFrame 
{
    private int     numEch;
    private int     coutEch;
    private int     estimeEch;
    private int     revenuEch;
    private String  typeEch;
    private String[] nomColonne = { "Numéro", "Coût", "Valeur", "Revenu", "Type" };
    private JLabel nomCol;

    public FrameListeEchange(ListeEchange list) 
    {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Liste des échanges");

        // Initialisation GridBagLayout
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        for(int i = 0; i < 5; i++)
        {
            nomCol = new JLabel(nomColonne[i]);
            nomCol.setFont(new Font("Arial", Font.PLAIN, 30));
            gbc.gridx = i;
            gbc.gridy = 0;
            this.add(nomCol, gbc);
        }

        for(int y = 0; y < list.getTaille(); y++)
        {
                numEch = list.getEchange(y).getNumEchange();
                coutEch = list.getEchange(y).getCoutEchange();
                estimeEch = list.getEchange(y).getEstimeEchange();
                revenuEch = list.getEchange(y).getRevenuEstime();
                typeEch = list.getEchange(y).getTypeEch();

                gbc.gridx = 0;
                gbc.gridy = y + 1;
                this.add(new JLabel(numEch + ""), gbc);

                gbc.gridx = 1;
                gbc.gridy = y + 1;
                this.add(new JLabel(coutEch + ""), gbc);

                gbc.gridx = 2;
                gbc.gridy = y + 1;
                this.add(new JLabel(estimeEch + ""), gbc);

                gbc.gridx = 3;
                gbc.gridy = y + 1;
                this.add(new JLabel(revenuEch + ""), gbc);

                gbc.gridx = 4;
                gbc.gridy = y + 1;
                this.add(new JLabel(typeEch), gbc);
        }


        // this.addComponentListener(new gereFrame());

        this.pack();
        this.setVisible(true);
    }

    // public class gereFrame extends ComponentAdapter
    // {
    //     public void ComponentMoved(ComponentEvent e)
    //     {
    //         Point p = new Point();
    //         p = FrameListeEchange.this.getLocation();
    //         FrameListeEchange.this.connexion.deplacerFEchange(p);
    //     }
    // }
}

