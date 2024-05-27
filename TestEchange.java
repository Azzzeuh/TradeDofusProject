public class TestEchange {
    public static void main(String[] args) {

        ListeEchange list = new ListeEchange("Achats Banque");

        list.ajouterEchange(new Echange(10000, 20000, 18000, "Consommables"));
        list.ajouterEchange(new Echange(5000, 18000, 15000, "Ressource"));
        list.ajouterEchange(new Echange(8000, 14000, 12000, "Ressource"));

        System.out.println(list.getLibelle());
        System.out.println('\n');
        System.out.println(list.toString());

        System.out.print("Coût total des échanges : ");
        System.out.println(list.totalDepense() + '\n');
        System.out.print("Estimé total des échanges : ");
        System.out.println(list.totalEstime() + '\n');
        System.out.print("Total revenu des échanges : ");
        System.out.println(list.totalRevenu() + '\n');
    }
}
