import java.awt.Image;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ImageFileChooser extends JFrame {

    private JFileChooser imgJFileChooser;

    public ImageFileChooser()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Ajout image");

        imgJFileChooser = new JFileChooser();
        this.add(imgJFileChooser);

        this.pack();
        this.setVisible(true);
    }

    public File getImage()
    {
        return this.imgJFileChooser.getSelectedFile();
    }
}
