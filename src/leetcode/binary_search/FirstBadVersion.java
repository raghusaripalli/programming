package leetcode.binary_search;

public class FirstBadVersion {

    private final boolean[] versions;

    FirstBadVersion(int n) {
        versions = new boolean[n+1];
        for (int i = 4; i < 6; i++) {
            versions[i] = true;
        }
    }

    private boolean isBadVersion(int n) {
        return versions[n];
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FirstBadVersion fbv = new FirstBadVersion(5);
        System.out.println(fbv.firstBadVersion(5));
    }
}
