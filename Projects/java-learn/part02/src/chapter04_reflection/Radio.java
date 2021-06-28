package chapter04_reflection;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/23 15:09
 */
public class Radio {
    private String brand(){
        System.out.println("A famous brand : YongSheng");
        return "YongSheng";
    }

    protected void turnOn(){
        System.out.println("The Radio is turned on.");
    }

    protected void turnOff(){
        System.out.println("The Radio is turned off");
    }

    public void play(String music){
        System.out.println("The Radio is playing " + music + ".");
    }

    public void play(String singer, String music)
    {
        System.out.println("The Radio is playing " + music + " of" + singer + ".");
    }

    public static void furnish(){
        System.out.println("This is a Radio.");
    }
}
