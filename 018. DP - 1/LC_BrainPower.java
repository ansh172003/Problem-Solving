import java.util.Arrays;

public class LC_BrainPower {
    public long memoApproach(int[][] questions){
        int n = questions.length;
        long[] memo = new long[n+1];
        for(int i = 0; i<=n; i++) memo[i] = -1;
        return memoApproachHelp(questions, 0, memo);
    }
    public long memoApproachHelp(int[][] questions, int index, long[] memo){
        if(index > questions.length - 1) return 0;
        if(memo[index] == -1){
            long take = memoApproachHelp(questions, index + questions[index][1] + 1, memo);
            take += questions[index][0];
            long notTake = memoApproachHelp(questions, index + 1, memo);
            memo[index] = Math.max(take, notTake);
        }
        return memo[index];
    }

    public long dpApproach(int[][] questions){
        long[] cache = new long[questions.length+1];
        for(int i = questions.length - 1; i >= 0; i--){
            int points = questions[i][0];
            cache[i] = points;
            int ques = questions[i][1];
            if(i+ques < questions.length) cache[i] += cache[i+1+ques];
            cache[i] = Math.max(cache[i],cache[i+1]);
        }
        return cache[0];
    }

    public long recursiveApproach(int[][] questions, int index){
        int n = questions.length;
        if(index > n - 1) return 0;
        long pick = recursiveApproach(questions, index + questions[index][1] + 1);
        pick += questions[index][0];
        long notPick = recursiveApproach(questions, index + 1);
        return Math.max(pick, notPick);
    }
    public long mostPoints(int[][] questions) {
        return dpApproach(questions);

    }
}
