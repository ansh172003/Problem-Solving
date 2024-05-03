import java.util.*;

public class LC_CourseScheduleII {
    public int[] canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(int j : adj.get(i)) inDegree[j]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0) q.add(i);
        }

        int[] topo = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()){
            int top = q.peek();
            q.remove();
            topo[idx++] = top;

            for(int i : adj.get(top)){
                inDegree[i]--;
                if(inDegree[i] == 0)q.add(i);
            }
        }
        if(idx == numCourses) return topo;
        return new int[0];
    }
}
