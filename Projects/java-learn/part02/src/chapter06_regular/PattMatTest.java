package chapter06_regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：xuyichao
 * @description：正则表达式使用示例
 * @date ：2021/6/25 9:38
 */
public class PattMatTest {
    public static void main(String[] args) {
        // 定义一个正则表达式和被匹配的字符串
        String patternStr = "(0?[1-9]|1[0-2]):([0-5]\\d)([a|p]m)";
        String matcherStr = "现在的时间是 11:15am，这里的营业时间是每天的8:30am至5:30pm";

        // 生成 Pattern 对象和 Matcher 对象
        Pattern pa = Pattern.compile(patternStr);
        Matcher ma = pa.matcher(matcherStr);

        // 创建一个目标字符串缓冲区
        StringBuffer sb = new StringBuffer();

        // 定义一个计数器
        int count = 0;

        // 打印初始字符串
        System.out.println("初始字符串是：");
        System.out.println(matcherStr);

        // 使用 while 循环进行匹配检查
        while(ma.find())
        {
            System.out.println(ma.group(0));
            System.out.println(ma.group(1));
            System.out.println(ma.group(2));
            System.out.println(ma.group(3));

            // 创建一个临时字符串的缓冲区
            StringBuffer temp = new StringBuffer();
            if (ma.group(3).equals("am")) {
                // 如果时间为 am，则进行替换
                // 设置时间格式
                temp.append(ma.group(1));
                temp.append(":");
                temp.append(ma.group(2));
            } else {
                // 设置时间为 pm 的替换
                // 对时间进行提取
                int time = Integer.parseInt(ma.group(1));
                time = time + 12;
                // 设置新的时间格式
                temp.append(time + ":" + ma.group(2));
            }

            // 进行替换并将结果放置到目标字符串缓冲区当中
            ma.appendReplacement(sb, temp.toString());
            // 打印每次替换的情况
            System.out.println("[" + (++count) + "]将" + ma.group(0) + "替换为" + temp.toString());
        }

        // 将最后一次替换后所剩余的字符串添加到目标字符串缓冲区
        ma.appendTail(sb);

        // 打印最后的结果
        System.out.println("最后的结果是：");
        System.out.println(sb.toString());
    }
}
