package thread_0502;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/2
 * Time: 9:38
 */
public class ThreadDemo1 {
    public static void main(String[] args) throws InterruptedException {
        String content = "这世上每个人的说话方式都如此拐弯抹角、闪烁其词，如此不负责任、如此微妙复杂。" +
                "他们总是徒劳无功地严加防范，无时无刻不费尽心机，这让我困惑不解，最终只得随波逐流，" +
                "用搞笑的办法蒙混过关，抑或默默颔首，任凭对方行事，即采取败北者的消极态度。";
        for (char item: content.toCharArray()) {
            System.out.print(item);
            Thread.sleep(250);
        }
    }
}
