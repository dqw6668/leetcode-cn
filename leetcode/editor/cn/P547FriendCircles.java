//班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 
//的朋友。所谓的朋友圈，是指所有朋友的集合。 
//
// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你
//必须输出所有学生中的已知的朋友圈总数。 
//
// 
//
// 示例 1： 
//
// 输入：
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//输出：2 
//解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。
//第2个学生自己在一个朋友圈。所以返回 2 。
// 
//
// 示例 2： 
//
// 输入：
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//输出：1
//解释：已知学生 0 和学生 1 互为朋友，学生 1 和学生 2 互为朋友，所以学生 0 和学生 2 也是朋友，所以他们三个在一个朋友圈，返回 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 200 
// M[i][i] == 1 
// M[i][j] == M[j][i] 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 309 👎 0


package editor.cn;
//Java：朋友圈
public class P547FriendCircles{
    public static void main(String[] args) {
        Solution solution = new P547FriendCircles().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCircleNum(int[][] M) {
            int len = M.length;
            int[] union = new int[len];
            for (int i = 0; i < len; i++) {
                // 每个人先自成一派
                union[i] = i;
            }
            // 建立关系
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (i != j && M[i][j] == 1) {
                        int a = findRoot(union, i);
                        int b = findRoot(union, j);
                        if (a != b) {
                            union[a] = b;
                        }
                    }
                }
            }
            int res = 0;
            for (int i  = 0; i < len; i++) {
                if (union[i] == i)
                    res++;
            }
            return res;
        }

        private int findRoot(int[] union, int child) {
            if (union[child] != child) {
                int root = findRoot(union, union[child]);
                union[child] = root;
                return root;
            }
            return child;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}