class GFG_CheckOneChild {

    boolean checkOneChild(int pre[], int size) {
        int nextDiff, lastDiff;

        for (int i = 0; i < size - 1; i++) {
            nextDiff = pre[i] - pre[i + 1];
            lastDiff = pre[i] - pre[size - 1];
            if (nextDiff * lastDiff < 0) {
                return false;
            };
        }
        return true;
    }

    public static void main(String[] args) {
        GFG_CheckOneChild tree = new GFG_CheckOneChild();
        int pre[] = new int[]{8, 3, 5, 7, 6};
        int size = pre.length;
        if (tree.checkOneChild(pre, size)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

// This code has been contributed by Mayank Jaiswal
