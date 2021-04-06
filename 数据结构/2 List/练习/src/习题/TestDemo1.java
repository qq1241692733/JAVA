package 习题;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/22
 * Time: 9:14
 */
class Card {
    String suit;
    int rank;
    public Card(String suit, int rank) {
        this.suit = suit; //花色
        this.rank = rank;
    }
}
class DeckCard {
    public static final String[] suits= {"♥","♠","♦","♣"};
    public List<Card> buyCard() {
        List<Card> cardList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                String suit = suits[i];
                int rank = j;
                Card card = new Card(suit, rank);
                cardList.add(card);
            }
        }
        return cardList;
    }

    public void swap(List<Card> cardList, int i, int j) {
        Card tmp = cardList.get(i);

    }
    public void washCard(List<Card> cardList) {
        for (int i = cardList.size(); i > 0; i--) {
            Random random = new Random();

        }
    }
}
public class TestDemo1 {
    public static List<Character> func(String str1, String str2) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (!str2.contains(ch+"")) {
                list.add(ch);
            }
        }
         return list;
    }
    public static void main(String[] args) {
        String str1 = "welcome to bit";
        String str2 = "come";
        List<Character> list = new ArrayList<>();
        list = func(str1, str2);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }

}
