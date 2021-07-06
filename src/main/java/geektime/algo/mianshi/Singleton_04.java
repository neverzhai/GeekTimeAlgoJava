package geektime.algo.mianshi;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-17 08:56
 * @description:
 */
public class Singleton_04 {

    // 双重锁校验
    // 关键是使用volatile修饰
    private static volatile Singleton_04 instance;

    public static Singleton_04 getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (Singleton_04.class) {
            if (instance == null) {
                instance = new Singleton_04();
            }
        }
        return instance;
    }
}