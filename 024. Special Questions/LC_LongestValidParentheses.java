import java.util.Stack;

public class LC_LongestValidParentheses {
    // Stack Approach
    public static int[] longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        st.push(-1);

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') st.push(i);
            else {
                st.pop();
                if(st.isEmpty()) st.push(i);
                else {
                    int l = i - st.peek();
                    res = Math.max(res, l);

                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        String s = "(()";
        System.out.println(longestValidParentheses(s));
    }
}
