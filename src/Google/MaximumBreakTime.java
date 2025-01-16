package Google;

import java.util.*;

public class MaximumBreakTime {

    public int findMaximumBreakTime(int[] start, int[] finish, int t, int k) {
        int n = start.length;

        // 1. 首先计算没有移动任何会议时的空闲时间
        // 将会议按开始时间排序
        List<int[]> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new int[]{start[i], finish[i]});
        }

        // 按照开始时间排序
        Collections.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // 计算初始的空闲时间
        int totalBreakTime = 0;
        int prevEndTime = 0; // 活动开始时，前一个会议的结束时间
        List<Integer> breakTimes = new ArrayList<>(); // 存储每个空闲时间段的长度

        for (int[] meeting : meetings) {
            int startTime = meeting[0];
            int endTime = meeting[1];

            // 如果会议的开始时间大于前一个会议的结束时间，表示有空闲时间
            if (startTime > prevEndTime) {
                int breakTime = startTime - prevEndTime;
                totalBreakTime += breakTime; // 累加空闲时间
                breakTimes.add(breakTime); // 记录每段空闲时间
            }

            // 更新前一个会议的结束时间
            prevEndTime = Math.max(prevEndTime, endTime);
        }

        // 2. 计算可以调整的空闲时间
        // 我们需要找到可以调整的最大空闲时间
        // 我们将寻找调整会议后能增加的最大空闲时间
        List<Integer> possibleBreaks = new ArrayList<>();

        // 计算如果移动会议时空闲时间的变化
        for (int i = 0; i < n; i++) {
            int breakTimeBefore = 0, breakTimeAfter = 0;

            // 会议i之前的空闲时间
            if (i == 0) breakTimeBefore = meetings.get(i)[0];  // 会议的开始时间到活动开始的时间
            else breakTimeBefore = meetings.get(i)[0] - meetings.get(i-1)[1];  // 当前会议的开始时间与前一个会议结束时间之间的空闲时间

            // 会议i之后的空闲时间
            if (i == n - 1) breakTimeAfter = t - meetings.get(i)[1];  // 最后一个会议之后的空闲时间
            else breakTimeAfter = meetings.get(i + 1)[0] - meetings.get(i)[1]; // 当前会议的结束时间与下一个会议的开始时间之间的空闲时间

            // 如果将会议i挪动，使得它与它前后的会议能更好的衔接，能够创造出更大的空闲时间，计算这个增量
            possibleBreaks.add(Math.max(breakTimeBefore, breakTimeAfter));
        }

        // 3. 选择k个能带来最大增益的调整
        Collections.sort(possibleBreaks, Collections.reverseOrder());  // 从大到小排序

        // 4. 计算通过移动最多k个会议可以获得的最大空闲时间
        for (int i = 0; i < k && i < possibleBreaks.size(); i++) {
            totalBreakTime += possibleBreaks.get(i);
        }

        return totalBreakTime;
    }

    public static void main(String[] args) {
        MaximumBreakTime solution = new MaximumBreakTime();
        int[] start = {4, 6, 7, 10};
        int[] finish = {5, 7, 8, 11};
        int t = 15;
        int k = 2;
        System.out.println(solution.findMaximumBreakTime(start, finish, t, k));  // Output: 6
    }
}
