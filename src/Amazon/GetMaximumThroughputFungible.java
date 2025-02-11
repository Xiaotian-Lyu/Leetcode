package Amazon;

import java.util.Arrays;
public class GetMaximumThroughputFungible {
    /**
     * Input:  host_throughput = [4, 6, 3, 5, 4, 5]
     * Output: 9
     * Here, n = 6, and the host throughput is given by host_throughput = [4, 6, 3, 5, 4, 5].
     * The maximum number of clusters that can be formed is 2.
     * One possible way to form the clusters is to select the 1st, 2nd,
     * and 3rd host servers for the first cluster, and the 4th, 5th,
     * and 6th host servers for the second cluster.
     * The cluster_throughput of the first cluster [4, 6, 3] will be 4 (the median),
     * and the cluster_throughput of the second cluster [5, 4, 5] will be 5 (the median).
     * Thus, the system_throughput will be 4 + 5 = 9.
     *
     */
    public static long getMaxThroughput(int[] hostThroughput) {
        Arrays.sort(hostThroughput); // 升序排序
        int n = hostThroughput.length;
        long systemThroughput = 0;

        int left = 0; // 左指针，用于取最小元素
        int right = n - 1; // 右指针，用于取最大元素

        while (right - left + 1 >= 3) { // 剩余元素足够组成一个集群
            // 取两个最大的和一个最小的元素
            systemThroughput += hostThroughput[right - 1]; // 中位数为次大的元素
            right -= 2; // 消耗两个大的元素
            left += 1; // 消耗一个小的元素
        }

        return systemThroughput;
    }

    public static void main(String[] args) {
        int[] example1 = {4, 6, 3, 5, 4, 5};
        System.out.println(getMaxThroughput(example1)); // 输出: 9

        int[] example2 = {2, 3, 4, 3, 4};
        System.out.println(getMaxThroughput(example2)); // 输出: 4

        int[] example3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(getMaxThroughput(example3)); // 输出: 18 (8 + 6 + 4)
    }
}
