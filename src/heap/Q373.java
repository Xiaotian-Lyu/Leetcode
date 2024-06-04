package heap;

import java.util.*;

public class Q373 {
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> result = new ArrayList<>();

            // 定义一个最小堆，并使用元素和作为比较标准
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> (nums1[a[0]] + nums2[a[1]])));

            // 将第一个数组的每个元素 与 第二个数组的第一个元素组合，放入最小堆中
            // 或者将第二组中的每个元素 与 第一组的第一个元素组合 也可以 目的是确保一方和另一方的最小值之和都存在了 以便后面比较
            for (int i = 0; i < nums1.length && i < k; i++) {
                minHeap.offer(new int[]{i, 0});
            }

            // 从最小堆中取出元素，直到达到K对或者其中一个数组遍历完
            // k-- > 0 表示循环会在 k 减到 0 之前会一直执行 同时要保证 minheap非空 有的时候k 的数量 > 所有的情况 如example2
            while (k-- > 0 && !minHeap.isEmpty()) {
                int[] minIndex = minHeap.poll();
                result.add(Arrays.asList(nums1[minIndex[0]], nums2[minIndex[1]]));//asList：array 转化为 ArrayList

                // 另外一种可能性的最小值加入heap ，minheap自动排序
                // 判断一下minIndex + 1 的范围
                if (minIndex[1] + 1 < nums2.length) {
                    minHeap.offer(new int[]{minIndex[0], minIndex[1] + 1});
                }
            }
            return result;
        }
    }


    //更好理解solution2 版
    class Solution2 {
        class Indexes {
            int index1; // nums1 index
            int index2; // nums2 index

            Indexes(int index1, int index2) {
                this.index1 = index1;
                this.index2 = index2;
            }
        }
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;//需要写吗？

            // 定义一个最小堆，并使用元素和作为比较标准
            PriorityQueue<Indexes> minHeap = new PriorityQueue<>((a, b) -> {
                int sum1 = nums1[a.index1] + nums2[a.index2];
                int sum2 = nums1[b.index1] + nums2[b.index2];
                return sum1 - sum2;
            });

            // 将第一个数组的每个元素与第二个数组的第一个元素组合，放入最小堆中
            for (int i = 0; i < nums1.length && i < k; i++) {
                minHeap.offer(new Indexes(i, 0));
            }

            // 从最小堆中取出元素，直到达到K对或者其中一个数组遍历完
            //k-- > 0 表示循环会在 k 减到 0 之前继续执行
            while (k-- > 0 && !minHeap.isEmpty()) {
                Indexes currentMinIndexes = minHeap.poll();
//                List<Integer> list = new ArrayList<>();
//                list.add(nums1[currentMinIndexes.index1]);
//                list.add(nums2[currentMinIndexes.index2]);
//                result.add(list);
                result.add(Arrays.asList(nums1[currentMinIndexes.index1], nums2[currentMinIndexes.index2]));

                // 如果第二个数组还有元素，则将下一个元素与当前来自第一个数组的元素组合，放入最小堆中
                // 接下来 可能最小的组合是 (index1 + 1, index2), (index1, index2 + 1)
                if (currentMinIndexes.index2 < nums2.length - 1) {
                    minHeap.offer(new Indexes(currentMinIndexes.index1, currentMinIndexes.index2 + 1));
                }
            }
            return result;
        }
    }

}
