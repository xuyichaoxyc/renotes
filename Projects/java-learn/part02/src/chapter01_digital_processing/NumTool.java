package chapter01_digital_processing;

import java.util.regex.Pattern;

/**
 * @author ：xuyichao
 * @description：判断一个字符串是否是数字
 * @date ：2021/6/21 12:21
 */
public class NumTool {
    public static boolean isNum(String s){
        for(int i = s.length(); --i >= 0;){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean isNumByRegex(String s){
        // 编译正则表达式
        Pattern p = Pattern.compile("[0-9]*");
        return p.matcher(s).matches();
    }

    public static boolean isNumByAacii(String s){
        for(int i = s.length(); --i >= 0; ){
            int c = s.charAt(i);
            if(c < 48 || c > 57){
                return false;
            }
        }
        return true;
    }

    public static boolean isNumByException(String s){
        try{
            Integer.parseInt(s);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "789";
        System.out.println(s1 + " 是数字吗：" + isNum(s1));
        String s2 = "676";
        System.out.println(s2 + " 是数字吗：" + isNumByRegex(s2));

        String s3 = "567";
        System.out.println(s3 + " 是数字吗：" + isNumByAacii(s3));

        String s4 = "abc";
        System.out.println(s4 + " 是数字吗：" + isNum(s4));
        System.out.println(s4 + " 是数字吗：" + isNumByRegex(s4));
        System.out.println(s4 + " 是数字吗：" + isNumByAacii(s4));
        System.out.println(s4 + " 是数字吗：" + isNumByException(s4));
    }
}
