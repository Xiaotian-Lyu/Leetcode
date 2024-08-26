import java.util.*;

public class CardPackets {
    public static int cardPackets(int[] cardTypes) {
        // 找到最大卡片数量
        int maxCard = cardTypes[0];
        for (int i = 1; i < cardTypes.length; i++) {
            if (cardTypes[i] > maxCard) {
                maxCard = cardTypes[i];
            }
        }

        int additionalCards = Integer.MAX_VALUE;

        // 尝试以2到最大卡片数之间的所有可能卡包数来分配卡片
        for (int target = 2; target <= maxCard; target++) {
            int res = 0;
            for (int cardType : cardTypes) {
                if (cardType % target != 0) {
                    res += target - (cardType % target);
                }
            }
            additionalCards = Math.min(additionalCards, res);
        }

        return additionalCards;
    }

    public static void main(String[] args) {

        int[] cardTypes = {4, 7, 5, 11, 15};
        System.out.println(cardPackets(cardTypes));  // 输出应为4
    }
}