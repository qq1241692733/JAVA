import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/31
 * Time: 11:07
 */
class Card implements Comparable{ public int rank; // 数值
     public String suit; // 花色
     public Card(int rank, String suit) {
         this.rank = rank;
         this.suit = suit;
     }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank &&
                Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}
public class TestDemo {
    public static void main(String[] args) {
        PriorityQueue<Card> pq = new PriorityQueue<>();
        pq.offer(new Card(1, "♠"));
        pq.offer(new Card(2, "♠"));
        System.out.println(pq);
        System.out.println(pq.comparator());
        System.out.println();

    }
}
