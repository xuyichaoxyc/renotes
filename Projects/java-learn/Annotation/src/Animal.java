/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/6 10:24
 */
public class Animal {
    @AnimalName(value = "狗")
    private String animalName;

    @AnimalColor(animalColor = AnimalColor.Color.黑色)
    private String animalColor;

    @AnimalMaster(id = 1, name = "小明", address = "浙江省杭州市xxx")
    private String animalMaster;
}
