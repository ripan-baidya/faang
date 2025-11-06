package recursion.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 06/11/25
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParenthesis {
    // *************** Approach 1: Backtracking ***************
    /**
     * <p> We use backtracking to generate all possible combinations of well-formed parentheses. We keep track of the
     * count of open and close parentheses and add them to the result list when we have n pairs of parentheses.
     *
     * <p> there are two choices at each step: add an open or close parenthesis. We add an open parenthesis if the count
     * of open parentheses is less than n. We add a close parenthesis if the count of close parentheses is less than
     * the count of open parentheses.
     *
     * <p> Base Case: Whenever we have n pairs of parentheses, we add the current combination to the result list.
     *
     * <p>
     * Time Complexity: O(4ⁿ / √n), the number of valid combinations is 4ⁿ / √n.
     * Space Complexity: O(n), the maximum depth of the recursion tree is n.
     *
     * @param n number of pairs of parentheses
     * @return list of all combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(0, 0, n, res, new StringBuilder());
        return res;
    }

    private void dfs(int cntOpen, int cntClose, int n, List<String> res, StringBuilder sb) {
        if (cntOpen == n && cntClose == n) {
            res.add(sb.toString());
            return;
        }
        // add open parenthesis
        if (cntOpen < n) {
            sb.append("(");
            dfs(cntOpen+1, cntClose, n, res, sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if (cntClose < cntOpen) {
            sb.append(")");
            dfs(cntOpen, cntClose+1, n, res, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    // main
    static void main() {
        var obj = new GenerateParenthesis();

        int n = 3;
        List<String> res = obj.generateParenthesis(n); // [((())), (()()), (())(), ()(()), ()()()]

        System.out.println(res);
    }
}
