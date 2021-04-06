package geektime.algo.mianshi;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-17 08:46
 * @description: https://bugstack.cn/itstack-demo-design/2020/05/31/%E9%87%8D%E5%AD%A6-Java-%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F-%E5%AE%9E%E6%88%98%E5%8D%95%E4%BE%8B%E6%A8%A1%E5%BC%8F.html
 */
public class Singleton_01 {
// 懒汉模式 --线程非安全

    private static Singleton_01 instance;

    public static Singleton_01 getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new Singleton_01();
        return instance;
    }

}