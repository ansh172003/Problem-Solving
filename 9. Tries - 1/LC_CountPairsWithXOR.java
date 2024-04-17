class trienode {
    public trienode[] children = new trienode[2];
    public int count = 0;
}

class LC_CountPairsWithXOR {
    int kHeight = 14;
    trienode root = new trienode();
    public int countPairs(int[] nums, int low, int high) {
        int res = 0;
        for (int num : nums) {
            res += getCount(num, high + 1) - getCount(num, low);
            insert(num);
        }
        return res;
    }
    void insert(int num) {
        trienode node = root;
        for (int i = kHeight; i >= 0; --i) {
            int bit = num >> i & 1;
            if (node.children[bit] == null)
                node.children[bit] = new trienode();
            node = node.children[bit];
            ++node.count;
        }
    }

    int getCount(int num, int limit) {
        int count = 0;
        trienode node = root;
        for (int i = kHeight; i >= 0; --i) {
            int val = num >> i & 1;
            int lim = ((limit >> i) & 1);
            if (lim == 1) {
                if (node.children[val] != null)
                    count += node.children[val].count;
                node = node.children[val ^ 1];
            } else {
                node = node.children[val];
            }
            if (node == null)
                break;
        }
        return count;
    }
}

//https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/description/
//https://www.geeksforgeeks.org/problems/search-query-auto-complete/1
//https://www.geeksforgeeks.org/problems/phone-directory4628/1
