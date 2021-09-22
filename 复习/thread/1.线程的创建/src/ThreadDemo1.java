/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/21
 * Time: 15:01
 */
public class ThreadDemo1 {
    public static void main(String[] args) throws InterruptedException {
        int count = 40;
//        String content = "这世上每个人的说话方式都如此拐弯抹角、闪烁其词，如此不负责任、如此微妙复杂。" +
//                "他们总是徒劳无功地严加防范，无时无刻不费尽心机，这让我困惑不解，最终只得随波逐流，" +
//                "用搞笑的办法蒙混过关，抑或默默颔首，任凭对方行事，即采取败北者的消极态度。";
        String content = "中秋节快乐！";
        for (char item : content.toCharArray()) {
            count--;
            if (count == 0) {
                System.out.println();
                count = 40;
            }
            System.out.print(item);
            Thread.sleep(250);
        }
    }
}
