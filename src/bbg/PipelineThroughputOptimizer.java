package bbg;

public class PipelineThroughputOptimizer {

    /**
     * 计算在给定预算下，能够实现的最大吞吐量
     *
     * @param throughput    每个服务的初始吞吐量
     * @param scaling_cost  每次扩展每个服务的成本
     * @param budget        总预算
     * @return              最大可实现的吞吐量
     */
    public static int getMaximumThroughput(int[] throughput, int[] scaling_cost, int budget) {
        int n = throughput.length;
        // 初始最小吞吐量为所有服务的初始吞吐量的最小值
        int left = 1;
        // 最大可能的吞吐量假设为初始吞吐量加上预算分配到最慢的服务
        int right = Integer.MAX_VALUE / 2; // 避免溢出

        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(throughput, scaling_cost, budget, mid)) {
                result = mid; // 如果可以实现，尝试更大的吞吐量
                left = mid + 1;
            } else {
                right = mid - 1; // 否则，尝试更小的吞吐量
            }
        }

        return result;
    }

    /**
     * 判断是否可以在预算内达到目标吞吐量
     *
     * @param throughput    每个服务的初始吞吐量
     * @param scaling_cost  每次扩展每个服务的成本
     * @param budget        总预算
     * @param target        目标吞吐量
     * @return              如果可以实现，返回true；否则，返回false
     */
    private static boolean isPossible(int[] throughput, int[] scaling_cost, int budget, int target) {
        long totalCost = 0;

        for (int i = 0; i < throughput.length; i++) {
            if (throughput[i] >= target) {
                continue; // 如果当前服务的吞吐量已经达到目标，无需扩展
            }

            // 计算需要扩展的次数 x，使得 throughput[i] * (1 + x) >= target
            // 即 x >= ceil(target / throughput[i] - 1)
            int requiredX = (int) Math.ceil((double) target / throughput[i] - 1);

            if (requiredX < 0) {
                requiredX = 0;
            }

            // 计算扩展该服务所需的总成本
            long cost = (long) requiredX * scaling_cost[i];
            totalCost += cost;

            if (totalCost > budget) {
                return false; // 如果成本已经超过预算，直接返回false
            }
        }

        return totalCost <= budget;
    }

    // 示例测试
    public static void main(String[] args) {
        int[] throughput = {4, 2, 7};
        int[] scaling_cost = {3, 5, 6};
        int budget = 32;

        int maxThroughput = getMaximumThroughput(throughput, scaling_cost, budget);
        System.out.println("最大可实现的吞吐量: " + maxThroughput); // 输出应为10
    }
}
