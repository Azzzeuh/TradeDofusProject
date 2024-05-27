import java.util.ArrayList;

public class ListeEchange {

    private ArrayList<Echange> listEchanges;
    private String libelle;

    public ListeEchange(String libelle)
    {
        this.libelle = libelle;
        this.listEchanges = new ArrayList<>();
    }

    public void ajouterEchange(Echange e)
    {
        this.listEchanges.add(e);
    }

    // ACCESSEUR 
    public Echange getEchange(int numEchange) { return this.listEchanges.get(numEchange); }
    public int     getTaille ()               { return this.listEchanges.size(); }
    public String  getLibelle()               { return this.libelle; }

    // Total de chaque attributs
    public int totalDepense() {
        int totalDepense = 0;
        for (Echange echange : this.listEchanges)
            totalDepense += echange.getCoutEchange();
        return totalDepense;
    }

    public int totalEstime() {
        int totalEstime = 0;
        for (Echange echange : this.listEchanges)
            totalEstime += echange.getEstimeEchange();
        return totalEstime;
    }

    public int totalRevenu() {
        int totalRevenu = 0;
        for (Echange echange : this.listEchanges)
            totalRevenu += echange.getRevenuEstime();
        return totalRevenu;
    }

    public String toString()
    {
        String sList = "";

        for(int i = 0; i < this.listEchanges.size(); i++)
            sList += this.listEchanges.get(i).toString();

        return sList;
    }
}