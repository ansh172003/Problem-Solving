import java.util.*;

public class LC_CourseScheduleI {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int n = prerequisites.length;
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(int j : adj.get(i)) inDegree[j]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0) q.add(i);
        }

        List<Integer> topologySort = new ArrayList<>();
        while (!q.isEmpty()){
            int top = q.peek();
            q.remove();
            topologySort.add(top);

            for(int i : adj.get(top)){
                inDegree[i]--;
                if(inDegree[i] == 0)q.add(i);
            }
        }
        return topologySort.size() == numCourses;
    }
}
