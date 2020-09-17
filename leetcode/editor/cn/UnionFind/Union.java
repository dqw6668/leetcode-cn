package editor.cn.UnionFind;

/**
 * Created by Five on 2020/9/17 15:46
 */
class Union {
    int[] union;

    public Union(int n) {
        union = new int[n];
        for (int i = 0; i < n; i++) {
            union[i] = i;
        }
    }

    public void union(int n1, int n2) {
        union[find(n1)] = find(n2);
    }

    public int find(int child) {
        if (union[child] != child) {
            int root = find(union[child]);
            union[child] = root;
        }
        return union[child];
    }

    public boolean connect(int n1, int n2) {
        return find(n1) == find(n2);
    }
}
