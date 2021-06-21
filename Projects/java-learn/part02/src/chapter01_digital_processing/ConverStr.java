package chapter01_digital_processing;

/**
 * @author ：xuyichao
 * @description：字符串转数字
 * @date ：2021/6/21 16:58
 */
public class ConverStr {
    public static int converInt(String s){
        try
        {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static long convertLong(String s){
        try{
            return Long.parseLong(s);
        }catch (NumberFormatException e){
            return 0l;
        }
    }

    public static Double convertDouble(String s){
        try {
            return Double.parseDouble(s);
        }catch (NumberFormatException e){
            return 0d;
        }
    }

    public static int[] convertIntArray(String[] as){
        if(as ==  null){
            return new int[0];
        }

        int[] ia = new int[as.length];
        for(int i = 0; i < as.length; i++){
            ia[i] = converInt(as[i]);
        }

        return ia;
    }
}
