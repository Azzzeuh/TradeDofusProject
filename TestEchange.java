import java.util.ArrayList;

public class TestEchange {
    public static void main(String[] args) {

        ListeEchange list = new ListeEchange("Achats Banque");
        ArrayList<String> listType = new ArrayList<>();
        listType = list.getListType();

        list.ajouterEchange(new Echange(10000, 20000, 18000, "Consommable"));
        list.ajouterEchange(new Echange(5000, 18000, 15000, "Ressource"));
        list.ajouterEchange(new Echange(8000, 14000, 12000, "Ressource"));

        System.out.println(list.getLibelle());
        System.out.println('\n');
        System.out.println(list.toString());

        System.out.print("Coût total des échanges : ");
        System.out.println(list.totalDepense());
        System.out.print("Estimé total des échanges : ");
        System.out.println(list.totalEstime());
        System.out.print("Total revenu des échanges : ");
        System.out.println(list.totalRevenu());

        System.err.println('\n');
        System.out.println("Test ajustement estime échange 1");
        list.getEchange(0).modifierEstime(18000);
        System.err.println(list.getEchange(0));

        System.err.println('\n');
        System.out.println("Test ajustement revenu échange 2");
        list.getEchange(1).modifierRevenu(17000);
        System.err.println(list.getEchange(1));

        System.err.println('\n');
        System.out.println("Test ajustement type échange 3");
        list.getEchange(2).modifierType("Equipement", listType);
        System.err.println(list.getEchange(2));

        list.ajouterType("abcd");
        listType = list.getListType();

        System.err.println('\n');
        System.out.println("Test ajustement type échange 3");
        list.getEchange(2).modifierType("abcd", listType);
        System.err.println(list.getEchange(2));

        for(int i = 0; i < listType.size(); i++)
            System.out.println(listType.get(i));


    }
}
