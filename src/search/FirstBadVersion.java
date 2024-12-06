package search;

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int start = 0;
        int end = n;
        while (start <= end) {
            int mid = end + (start-end)/2;
            boolean bad = isBadVersion(mid);
            if (bad) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return start;
    }

    //This is a mock method; the value should be returned by the LeetCode platform.
    //Returning true prevents a compile error.
    private boolean isBadVersion(int val) {
        return true;
    }
}
