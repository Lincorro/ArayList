import GB_collections.GbList;
import GB_collections.Lists.GbArayList;
import GB_collections.Lists.GbLincelList;

public class Main {
    public static void main(String[] args) {
        GbLincelList<Integer> list = new GbLincelList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.prinList(list);
        System.out.println("\n");
        list.add(4,6);
        list.prinList(list);



    }
}