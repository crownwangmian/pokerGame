import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {
    static ArrayList<String> list = new ArrayList<>();
    // perpare poker cards
    static {
        //扑克牌四个花色
        String[] colors = {"红桃", "黑桃", "方片", "梅花"};
        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String color : colors) {
            for (String number : numbers) {
                list.add(color + number);
            }
        }
        list.add("大王");
        list.add("小王");

    }
    public  PokerGame() {
        //shuffle
        Collections.shuffle(list);
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i <= 2) {
                lord.add(list.get(i));
                continue;
            }
            if (i % 3 == 0) {
                player1.add(list.get(i));
            } else if (i % 3 == 1) {
                player2.add(list.get(i));
            } else {
                player3.add(list.get(i));
            }
        }
        lookPoker("lord", lord);
        lookPoker("player1", player1);
        lookPoker("player2", player2);
        lookPoker("player3", player3);
    }

    public void lookPoker(String player, ArrayList<String> list) {
        System.out.println(player + ": ");
        for (String poker : list) {
            System.out.print(poker + " ");
        }
        System.out.println();
    }


}
