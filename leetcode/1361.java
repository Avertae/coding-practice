class Solution {

    boolean[] v;
    boolean result;
    int[] ll, rr;
    int amt;

    void dfs(int i) {
        if (v[i]) {
            result = false;
            return;
        }
        //dbg(v, i);
        v[i] = true;
        amt++;
        if (ll[i] != -1) dfs(ll[i]);
        if (rr[i] != -1) dfs(rr[i]);
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        
        // exactly 1 node without parent
        // no cycles
        // all nodes reachable from root

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1 || rightChild[i] != -1) {
            }
            if (leftChild[i] != -1) {
                if (parent[leftChild[i]] >= 0) return false;
                parent[leftChild[i]] = i;
                count++;
            }
            if (rightChild[i] != -1) {
                if (parent[rightChild[i]] >= 0) return false;
                parent[rightChild[i]] = i;
                count++;
            }
        }

        int root = -1;
        for (int i = 0; i < n; i++) 
            if (parent[i] == -1) {
                root = i;
                break;
            }

        if (count != n - 1) return false;

        amt = 0;
        v = new boolean[n];
        result = true;
        ll = leftChild;
        rr = rightChild;
        dfs(root);
        //dbg(count, parent);
        return result ? amt == n : false;
    }

}