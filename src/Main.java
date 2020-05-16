import List.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> lista = new SortedArrayList<Integer>();

        /*for(int i = 0; i<50; i++){
            lista.Add((int)(Math.random()*100));
            System.out.println(lista.ToString());
        }*/

        lista.Add(26);
        lista.Add(98);
        lista.Add(70);
        lista.Add(26);
        lista.Add(6);
        lista.Add(12);
        lista.Add(21);
        lista.Add(93);
        lista.Add(89);
        lista.Add(48);
        lista.Add(40);
        lista.Add(90);
        lista.Add(40);

        System.out.println(lista.ToString());

    }
}
