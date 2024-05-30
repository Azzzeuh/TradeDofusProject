import java.awt.*;
import javax.swing.*;

public class FrameListeEchange extends JFrame{

    public FrameListeEchange() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Liste des échanges");
        this.setLocation(50, 50);      

        // Initialisation GridBagLayout
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

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

