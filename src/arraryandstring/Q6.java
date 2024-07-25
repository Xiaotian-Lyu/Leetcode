package arraryandstring;

import java.util.ArrayList;
import java.util.List;

public class Q6 {
    class Solution {
        public String convert(String s, int numRows) {
            if(numRows == 1) return s;

            List<StringBuilder> rows = new ArrayList<>();//这里是放StringBuilder
            for(int i = 0; i < Math.min(numRows, s.length()); i++){
                rows.add(new StringBuilder());
            }

            //initial row and direction
            int curRow = 0;
            boolean goDown = false;

            for(char c : s.toCharArray()){
                rows.get(curRow).append(c);

                if(curRow == 0 || curRow == rows.size() - 1){//每次append 的时候只需要判断一次 不是while
                    goDown = !goDown;
                }

                if(goDown) curRow += 1;
                else curRow -= 1;
            }

            StringBuilder result = new StringBuilder();
            for(StringBuilder row : rows){
                result.append(row);
            }

            return result.toString();

        }
    }
}
