
public class MyAnswer {
	
    public static int MaxGap(int[] A, int i, int k) {
        if (k == 1) {
            return 0;
        }
        int m = i + (k / 2);
        int leftGap = MaxGap(A, i, m - i);
        int rightGap = MaxGap(A, m, i + k - m);
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        int minLeft = Integer.MAX_VALUE;
        int minRight = Integer.MAX_VALUE;

        for (int j = i; j < m; j++) {
            maxLeft = Math.max(maxLeft, A[j]);
            minLeft = Math.min(minLeft, A[j]);
        }

        for (int j = m; j < i + k; j++) {
            maxRight = Math.max(maxRight, A[j]);
            minRight = Math.min(minRight, A[j]);
        }

        return Math.max(leftGap, Math.max(rightGap, Math.max(maxLeft - minRight, maxRight - minLeft)));
    }
    
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        int i = 0;
        int k = 5;

        int maxGap = MaxGap(A, i, k);

        System.out.println("Max gap within A[" + i + "] to A[" + (i + k) + "] = " + maxGap);
    }

}
