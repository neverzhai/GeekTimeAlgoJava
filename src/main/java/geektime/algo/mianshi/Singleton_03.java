package geektime.algo.mianshi;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-17 08:54
 * @description:
 */
public class Singleton_03 {
    // 饿汉模式
    private static Singleton_03 instance = new Singleton_03();

    public static Singleton_03 getInstance() {
        return instance;
    }
}