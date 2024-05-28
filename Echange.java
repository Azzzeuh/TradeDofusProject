import java.util.ArrayList;

public class Echange {

    private int coutEchange;
    private int estimeEchange;
    private int revenuEstime;
    private String typeEch = "";
    private int numEchange = 0;
    private static int nbEchange = 0;


    public Echange(int coutEchange, int estimeEchange, int revenuEstime, String typeEch)
    {
        if(coutEchange >= 0 && estimeEchange > 0 && revenuEstime > 0 && typeEch != null)
        {
            this.coutEchange = coutEchange;
            this.estimeEchange = estimeEchange;
            this.revenuEstime = revenuEstime;
            this.typeEch = typeEch;
            this.numEchange = ++nbEchange;
        }
        else 
        {            
            System.out.println("ERREUR : l'un des champs n'est pas correctement rempli");
        }    
    }

    // ACCESSEURS 
    public int getCoutEchange       () { return this.coutEchange; }
    public int getEstimeEchange     () { return this.estimeEchange; }
    public int getRevenuEstime      () { return this.revenuEstime; }
    public int getNumEchange        () { return this.numEchange; }
    public static int getNbEchange  () { return nbEchange; }
    public String getTypeEch        () { return this.typeEch; }

    // Méthode pour modifier certains paramètres des échanges, en cas d'erreur
    public boolean modifierCout(int cout)
    {
        if(cout >= 0)
        {
            this.coutEchange = cout;
            return true;
        }
        return false;    
    }

    public boolean modifierEstime(int estime)
    {
        if(estime > 0)
        {
            this.estimeEchange = estime;
            return true;
        }
        return false;
    }
    
    public boolean modifierRevenu(int revenu)
    {
        if(revenu >= 0)
        {
            this.revenuEstime = revenu;
            return true;
        }
        return false;
    }

    public boolean modifierType(String type, ArrayList<String> list)
    {
        if (list.contains(type))
        {
            this.typeEch = type;
            return true;
        }
        return false;
    }

    public String toString()
    {
        String sEch = "";

        sEch += "Échange n°"                + getNumEchange()    + '\n' + '\t' +
                "Type d'échange : "         + getTypeEch()       + '\n' + '\t' +
                "Argent dépensé : "         + getCoutEchange()   + '\n' + '\t' +
                "Prix estimé ressources : " + getEstimeEchange() + '\n' + '\t' +
                "Revenus estimés : "        + getRevenuEstime()  + '\n';

        return sEch;
    }
}
