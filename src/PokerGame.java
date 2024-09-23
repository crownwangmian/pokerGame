import java.util.*;

public class PokerGame {

    // we do not need to sore the card, we only need build corrsponding number
    private static final HashMap<Integer, String> POKER_MAP = new HashMap<>();
    private static final ArrayList<Integer> LIST = new ArrayList<>();

    // perpare poker cards
    static {
        //扑克牌四个花色
        String[] colors = {"红桃", "黑桃", "方片", "梅花"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        int sericalNumber = 0;
        for (String number : numbers) {
            for (String color : colors) {
                POKER_MAP.put(sericalNumber, color + number);
                LIST.add(sericalNumber);
                sericalNumber++;
            }
        }
        POKER_MAP.put(sericalNumber, "小王");
        LIST.add(sericalNumber);
        sericalNumber++;
        POKER_MAP.put(sericalNumber, "大王");
        LIST.add(sericalNumber);
    }

    public PokerGame() {
        // shuffle
        Collections.shuffle(LIST);
        // deal
        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();
        for (int i = 0; i < LIST.size(); i++) {
            if (i <= 2) {
                lord.add(LIST.get(i));
            } else if (i % 3 == 0) {
                player1.add(LIST.get(i));
            } else if (i % 3 == 1) {
                player2.add(LIST.get(i));
            } else {
                player3.add(LIST.get(i));
            }

        }
        lookCards(lord, "地主");
        lookCards(player1, "玩家1");
        lookCards(player2, "玩家2");
        lookCards(player3, "玩家3");


    }


    private static void lookCards(Collection<Integer> cards, String player) {
        System.out.print(player + ": ");
        for (Integer card : cards) {
            System.out.print(POKER_MAP.get(card) + " ");
        }
        System.out.println();
    }
}
