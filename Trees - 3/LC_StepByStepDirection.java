class LC_StepByStepDirection {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startingPath = new StringBuilder();
        StringBuilder endingPath = new StringBuilder();

        depthTraversal(root, startValue, startingPath);
        depthTraversal(root, destValue, endingPath);

        while (startingPath.length() > 0 && endingPath.length() > 0 &&
                startingPath.charAt(startingPath.length() - 1) ==
                        endingPath.charAt(endingPath.length() - 1)) {
            startingPath.setLength(startingPath.length() - 1);
            endingPath.setLength(endingPath.length() - 1);
        }

        return "U".repeat(startingPath.length()) + endingPath.reverse().toString();
    }

    private boolean depthTraversal(TreeNode root, int val, StringBuilder currPath) {
        if (root.val == val)
            return true;
        if (root.left != null && depthTraversal(root.left, val, currPath))
            currPath.append("L");
        else if (root.right != null && depthTraversal(root.right, val, currPath))
            currPath.append("R");
        return currPath.length() > 0;
    }
}