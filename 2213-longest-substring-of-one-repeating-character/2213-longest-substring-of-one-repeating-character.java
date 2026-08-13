class Solution {

    class Node {
        char left, right;
        int prefix, suffix, max, len;

        Node(char left, char right, int prefix, int suffix, int max, int len) {
            this.left = left;
            this.right = right;
            this.prefix = prefix;
            this.suffix = suffix;
            this.max = max;
            this.len = len;
        }
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {

        arr = s.toCharArray();
        int n = arr.length;

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];
            arr[index] = queryCharacters.charAt(i);

            update(1, 0, n - 1, index);

            ans[i] = tree[1].max;
        }

        return ans;
    }

    void build(int node, int start, int end) {

        if (start == end) {
            tree[node] = new Node(
                arr[start], arr[start],
                1, 1, 1, 1
            );
            return;
        }

        int mid = (start + end) / 2;

        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int start, int end, int index) {

        if (start == end) {
            tree[node] = new Node(
                arr[index], arr[index],
                1, 1, 1, 1
            );
            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, end, index);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node merge(Node a, Node b) {

        Node res = new Node(
            a.left,
            b.right,
            a.prefix,
            b.suffix,
            Math.max(a.max, b.max),
            a.len + b.len
        );

        if (a.right == b.left) {

            // Join suffix of left + prefix of right
            res.max = Math.max(
                res.max,
                a.suffix + b.prefix
            );

            // Entire left part has same character
            if (a.prefix == a.len) {
                res.prefix = a.len + b.prefix;
            }

            // Entire right part has same character
            if (b.suffix == b.len) {
                res.suffix = b.len + a.suffix;
            }
        }

        return res;
    }
}