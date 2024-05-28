import java.util.ArrayList;

public class ListeEchange {

    private ArrayList<Echange> listEchanges;
    private static ArrayList<String> listType;
    private String libelle;

    public ListeEchange(String libelle)
    {
        this.libelle = libelle;
        this.listEchanges = new ArrayList<>();
        listType = new ArrayList<>();
        initListType();
        
    }

    // Initialisation liste type d'échange
    public static void initListType()
    {
        listType.add("Ressource");
        listType.add("Equipement");
        listType.add("Consommable");
        listType.add("Cosmétique");
    }

    // Méthode d'ajout
    public void ajouterEchange(Echange e)
    {
        this.listEchanges.add(e);
    }

    public void ajouterType(String type)
    {
        if(type != null)
            listType.add(type);
    }


    // ACCESSEUR 
    public Echange getEchange(int numEchange) { return this.listEchanges.get(numEchange); }
    public int     getTaille ()               { return this.listEchanges.size(); }
    public String  getLibelle()               { return this.libelle; }
    public ArrayList<String> getListType ()   { return listType; }


    // Total de chaque attributs
    public int totalDepense() {
        int totalDepense = 0;
        for (Echange echange : this.listEchanges) {
            totalDepense += echange.getCoutEchange();
        }
        return totalDepense;
    }
    
    public int totalEstime() {
        int totalEstime = 0;
        for (Echange echange : this.listEchanges) {
            totalEstime += echange.getEstimeEchange();
        }
        return totalEstime;
    }
    
    public int totalRevenu() {
        int totalRevenu = 0;
        for (Echange echange : this.listEchanges) {
            totalRevenu += echange.getRevenuEstime();
        }
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