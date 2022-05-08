/**
 * @ClassName: solution
 * @Author: yzh
 * @Description:
 * @Date: 2022/4/10 19:30
 * @Version: 1.0
 */


import java.util.*;

/**
 * 输入一串单词，将其翻译，并且输出不同个数
 */
public class solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,2,2,2,3};
        System.out.println(majorityElement(arr));
    }

    //合并升序链表
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) map.put(num,1);
            else map.put(num,map.get(num)+1);
        }
        TreeMap<Integer, Integer> result = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.put(entry.getValue(),entry.getKey());
        }
        return result.get(result.lastKey());
    }
}
