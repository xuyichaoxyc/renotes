import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/5 16:04
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("abc");
        words.add("白日依山尽，黄河入海流。欲穷千里目，更上一层楼。");
        words.add("天不生我李淳罡，剑道万古如长夜。");
        words.add("魑魅魍魉");
        words.add("手握日月摘星辰，世间无我这般人！");

        // 迭代
        int count = 0;
        for (String word : words) {
            if (word.length() > 12) {
                count++;
            }
        }
        System.out.println("迭代查找长句子：" + count);

        // 流操作（Stream）
        long count1 = words.stream()
                .filter(w -> w.length() > 12)
                .count();
        System.out.println("流操作查找长句子：" + count1);

        long count2 = words.parallelStream()
                .filter(w -> w.length() > 12)
                .count();
        System.out.println("并行流操作查找长句子：" + count1);
    }
}
