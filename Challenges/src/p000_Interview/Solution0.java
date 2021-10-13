package p000_Interview;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/12 11:18
 */

class Solution2 {

    public int getKthElement(int[] a, int[] b, int k) {
        if (k > a.length + b.length) {
            return -1;
        }
        if (a.length == 0) {
            return b[k - 1];
        }
        if (b.length == 0) {
            return a[k - 1];
        }
        if (a.length > b.length) {
            return getKthElement(b, a, k);
        }

        int indexA = 0, indexB = 0;
        while (k > 1) {
            int mid = k / 2;
            if (indexA + mid > a.length) {
                if (a[a.length - 1] < b[indexB + mid]) {
                    return b[k - a.length - 1];
                } else {
                    indexB = indexB + mid;
                }
            } else {
                if (a[indexA + mid] < b[indexB + mid]) {
                    indexA = indexA + mid;
                } else {
                    indexB = indexB + mid;
                }
            }
            k -= mid;
        }

        if (a[indexA] <= b[indexB]) {
            return a[indexA];
        } else {
            return b[indexB];
        }
    }


}

class Solution3 {

    public int getKthElement(int[] a, int[] b, int k) {
        if (k > a.length + b.length) {
            return -1;
        }
        if (a.length == 0) {
            return b[k - 1];
        }
        if (b.length == 0) {
            return a[k - 1];
        }
        if (a.length > b.length) {
            return getKthElement(b, a, k);
        }

        int indexA = 0, indexB = 0;
        while (k > 1) {
            int mid = Math.min(k / 2, Math.min(a.length - 1 - indexA, b.length - 1 - indexB));
            if (a[indexA + mid] < b[indexB + mid]) {
                indexA = indexA + mid;
            } else {
                indexB = indexB + mid;
            }
            k -= mid;
        }
        if (indexA >= a.length) {
            return b[indexB];
        } else if (indexB >= b.length) {
            return a[indexA];
        }
        if (a[indexA] <= b[indexB]) {
            return a[indexA];
        } else {
            return b[indexB];
        }
    }


}
