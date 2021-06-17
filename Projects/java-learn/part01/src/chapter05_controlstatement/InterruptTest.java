package chapter05_controlstatement;

/**
 * @author ：xuyichao
 * @description：中断控制
 * @date ：2021/6/17 14:57
 */
public class InterruptTest {

    public static boolean returnTest(int i){
        if(i > 2){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        /**
         * continue：中断程序流程，在当前循环中，可以用于中断当前循环，进入下一循环
         *
         * 外层第0层循环
         * ===================
         * 内层第0层循环
         * 内层第1层循环
         * 内层第3层循环
         * 内层第4层循环
         * ===================
         * 外层第1层循环
         * ===================
         * 内层第0层循环
         * 内层第1层循环
         * 内层第3层循环
         * 内层第4层循环
         * ===================
         * 外层第2层循环
         * ===================
         * 内层第0层循环
         * 内层第1层循环
         * 内层第3层循环
         * 内层第4层循环
         * ===================
         * 外层第4层循环
         * ===================
         * 内层第0层循环
         * 内层第1层循环
         * 内层第3层循环
         * 内层第4层循环
         * ===================
         *
         */

        for(int i = 0; i < 5; i++){
            if(i == 3){
                continue;
            }
            System.out.println("外层第" + i + "层循环");
            System.out.println("===================");
            for(int j = 0; j < 5; j++){
                if (j == 2){
                    continue;
                }
                System.out.println("内层第" + j + "层循环");
            }
            System.out.println("===================");
        }
        System.out.println("++++++++++_____________++++++++++++++");

        /**
         * break：用于结束switch语句，跳出循环
         *
         * 外层第0层循环
         * ===================
         * 内层第0层循环
         * 内层第1层循环
         * ===================
         * 外层第1层循环
         * ===================
         * 内层第0层循环
         * 内层第1层循环
         * ===================
         * 外层第2层循环
         * ===================
         * 内层第0层循环
         * 内层第1层循环
         * ===================
         *
         */
        for(int i = 0; i < 5; i++){
            if(i == 3){
                break;
            }
            System.out.println("外层第" + i + "层循环");
            System.out.println("===================");
            for(int j = 0; j < 5; j++){
                if (j == 2){
                    break;
                }
                System.out.println("内层第" + j + "层循环");
            }
            System.out.println("===================");
        }
        System.out.println("++++++++++_____________++++++++++++++");

        /**
         * return：结束当前的方法，并且返回到调用该方法的位置
         *
         * 外层第0false层循环
         * ===================
         * 内层第0false层循环
         * 内层第1false层循环
         * 内层第2false层循环
         * 内层第3true层循环
         * 内层第4true层循环
         * ===================
         * 外层第1false层循环
         * ===================
         * 内层第0false层循环
         * 内层第1false层循环
         * 内层第2false层循环
         * 内层第3true层循环
         * 内层第4true层循环
         * ===================
         * 外层第2false层循环
         * ===================
         * 内层第0false层循环
         * 内层第1false层循环
         * 内层第2false层循环
         * 内层第3true层循环
         * 内层第4true层循环
         * ===================
         * 外层第3true层循环
         * ===================
         * 内层第0false层循环
         * 内层第1false层循环
         * 内层第2false层循环
         * 内层第3true层循环
         * 内层第4true层循环
         * ===================
         * 外层第4true层循环
         * ===================
         * 内层第0false层循环
         * 内层第1false层循环
         * 内层第2false层循环
         * 内层第3true层循环
         * 内层第4true层循环
         * ===================
         */
        for(int i = 0; i < 5; i++){
            System.out.println("外层第" + i + returnTest(i) + "层循环");
            System.out.println("===================");
            for(int j = 0; j < 5; j++){
                System.out.println("内层第" + j + returnTest(j) + "层循环");
            }
            System.out.println("===================");
        }
    }
}
