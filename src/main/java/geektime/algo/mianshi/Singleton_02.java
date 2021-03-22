package geektime.algo.mianshi;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-17 08:52
 * @description:
 */
public class Singleton_02 {
    // 懒汉模式 -- 线程安全
    private static Singleton_02 instance;

    public static synchronized Singleton_02 getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new Singleton_02();
        return instance;
    }
}