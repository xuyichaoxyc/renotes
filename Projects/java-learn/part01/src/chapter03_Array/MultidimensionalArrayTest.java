package chapter03_Array;

/**
 * @author ：xuyichao
 * @description：多维数组
 * @date ：2021/6/17 11:22
 */
public class MultidimensionalArrayTest {
    public static void main(String[] args) {
        int[][] mArr1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] mArr2 = new int[][]{
                {1, 3, 5},
                {2, 4, 6},
                {7, 8, 9}
        };

        int[][] mArr3 = new int[3][3];
        int k = 10;
        for(int i = 0; i < mArr3.length; i++){
            for(int j = 0; j < mArr3[i].length; j++){
                mArr3[i][j] = k++;
            }
        }

        // 不规则多维数组
        int[][] mArr4 = new int[3][];
        mArr4[0] = new int[1];
        mArr4[1] = new int[2];
        mArr4[2] = new int[3];

        System.out.println("mArr1值：");
        for(int i = 0; i < mArr1.length; i++){
            for(int j = 0; j < mArr1[i].length; j++){
                System.out.print(mArr1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("mArr2值：");
        for(int i = 0; i < mArr2.length; i++){
            for(int j = 0; j < mArr2[i].length; j++){
                System.out.print(mArr2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("mArr3值：");
        for(int i = 0; i < mArr3.length; i++){
            for(int j = 0; j < mArr3[i].length; j++){
                System.out.print(mArr3[i][j] + " ");
            }
            System.out.println();
        }


        // 不规则多维数组的初始化
        for(int i = 0; i < mArr4.length; i++)
        {
            for(int j = 0; j < mArr4[i].length; j++){
                mArr4[i][j] = k++;
            }
        }
        System.out.println("mArr4值：");
        for(int i = 0; i < mArr4.length; i++){
            for(int j = 0; j < mArr4[i].length; j++){
                System.out.print(mArr4[i][j] + " ");
            }
            System.out.println();
        }

    }
}
