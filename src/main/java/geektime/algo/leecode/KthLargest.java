package geektime.algo.leecode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-14 09:02
 * @description: 703. 数据流中的第 K 大元素
 */
public class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public static void main(String[] args) {
        LinkedList<Object> stack = new LinkedList<>();

        stack.push(1);
        stack.push(2);

        Object peek = stack.peek();
        System.out.println("stack" + peek);

        Object pop = stack.pop();
        System.out.println("stack" + pop);


        Object pop1 = stack.pop();
        System.out.println("stack" + pop1);

        LinkedList<Object> queue = new LinkedList<>();
        queue.offer(3);
        queue.offer(4);

        Object poeek = queue.peek();
        System.out.println("queue" + poeek);

        Object poll = queue.poll();
        System.out.println("queue" + poll);

        Object poll1 = queue.poll();
        System.out.println("queue" + poll1);

    }

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        for (int x : nums) {
            add(x);
        }
    }


    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
