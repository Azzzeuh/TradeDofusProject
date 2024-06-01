import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class FrameListeEchange extends JFrame {
    private String[] nomColonne = { "Numéro", "Coût", "Valeur", "Revenu", "Type" };

    public FrameListeEchange(ListeEchange list) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Liste des échanges");

        // Initialisation du tableau des échanges
        String[][] data = new String[list.getTaille()][5];
        for (int y = 0; y < list.getTaille(); y++) {
            Echange echange = list.getEchange(y);
            data[y][0] = String.valueOf(echange.getNumEchange());
            data[y][1] = String.valueOf(echange.getCoutEchange());
            data[y][2] = String.valueOf(echange.getEstimeEchange());
            data[y][3] = String.valueOf(echange.getRevenuEstime());
            data[y][4] = echange.getTypeEch();
        }

        JTable table = new JTable(data, nomColonne);
        table.setFont(new Font("Arial", Font.PLAIN, 15));
        table.setRowHeight(20);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane scrollPane = new JScrollPane(table);

        this.add(scrollPane, BorderLayout.CENTER);

        this.pack();

        adjustLastColumnWidth(table, scrollPane.getViewport().getWidth());
        
        this.setVisible(true);
    }

    private void adjustLastColumnWidth(JTable table, int viewportWidth) {
        TableColumnModel columnModel = table.getColumnModel();
        int lastColumnIndex = columnModel.getColumnCount() - 1;
        int width = 15; // Min width
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer renderer = table.getCellRenderer(row, lastColumnIndex);
            Component comp = table.prepareRenderer(renderer, row, lastColumnIndex);
            width = Math.max(comp.getPreferredSize().width + 1, width);
        }
        columnModel.getColumn(lastColumnIndex).setPreferredWidth(width);

        // Ajuster les autres colonnes pour occuper l'espace restant
        int remainingWidth = viewportWidth - width;
        int numColumns = columnModel.getColumnCount() - 1;

        for (int i = 0; i < numColumns; i++) {
            columnModel.getColumn(i).setPreferredWidth(remainingWidth / numColumns);
        }
    }

}
