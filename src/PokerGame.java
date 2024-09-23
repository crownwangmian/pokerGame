import java.util.*;

public class PokerGame {

    // we do not need to sore the card, we only need build corrsponding number
    private static final HashMap<String, Integer> VALUE = new HashMap<>();
    private static final ArrayList<String> POKER_CARDS = new ArrayList<>();

    // perpare poker cards
    static {
        //扑克牌四个花色
        String[] colors = {"红桃", "黑桃", "方片", "梅花"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        for (String color : colors) {
            for (String number : numbers) {
                POKER_CARDS.add(color + number);
            }
        }
        POKER_CARDS.add("  小王");
        POKER_CARDS.add("  大王");
        // point cards value
        VALUE.put("J", 11);
        VALUE.put("Q", 12);
        VALUE.put("K", 13);
        VALUE.put("A", 14);
        VALUE.put("2", 15);
        VALUE.put("小王", 50);
        VALUE.put("大王", 100);
    }


    public PokerGame() {
        Collections.shuffle(POKER_CARDS);
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();


        for (int i = 0; i < POKER_CARDS.size(); i++) {
            String card = POKER_CARDS.get(i);
            if (i <= 2) {
                lord.add(card);
            } else if (i % 3 == 0) {
                player1.add(card);
            } else if (i % 3 == 1) {
                player2.add(card);
            } else {
                player3.add(card);
            }
        }

        sort(lord);
        sort(player1);
        sort(player2);
        sort(player3);

        System.out.println("lord: " + lord);
        System.out.println("1: " + player1);
        System.out.println("2: " + player2);
        System.out.println("3: " + player3);

    }

    public void sort(ArrayList<String> list) {
        Collections.sort(list, (o1, o2) -> {
            String color1 = o1.substring(0, 1); //colours
            String color2 = o2.substring(0, 1);
            return getValue(o1) - getValue(o2) == 0 ? color1.compareTo(color2) : getValue(o1) - getValue(o2);
        });

    }

    public int getValue(String poker) {
        String number = poker.substring(2);// number of cards orJQK of cards
        if (VALUE.containsKey(number)) {
            return VALUE.get(number);
        } else {
            return Integer.parseInt(number);
        }
    }


}




