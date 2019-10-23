package geektime.algo.trees;
/*
  堆是一个完全二叉树（可以用数组进行存储）
  堆中每一个节点的值都必须大于等于（或小于等于）其子树中每个节点的值
 */
public class Heap {

//    //插入
////    public void Insert(int data){
////
////    }
////
////    //删除堆顶
////    public void DeleteHeapTop(){
////
////    }
    public void Arrange(String s){
        char[] chars = s.toCharArray();
        ArrangeSort(chars, 0, chars.length-1);
    }

    public void ArrangeSort(char[] chars, int start, int end){
        if(end <= 1){
            return;
        }
        if(start == end) {
           System.out.println(chars);
        } else {
            for(int i = start; i <= end; i++){
                Swap(chars, i, start);
                ArrangeSort(chars, start+1, end);
                Swap(chars, start, i);
            }
        }
    }

    private void Swap(char[] chars, int start, int i) {
        char temp = chars[i];
        chars[i] = chars[start];
        chars[start] = temp;
    }


}
