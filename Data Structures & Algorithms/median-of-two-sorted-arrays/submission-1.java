class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m= nums2.length;
        //assuming that nums2 is smaller array than nums1
        int total = (n+m);
        if (total % 2 !=0){
            int ele = -1;
            int cnt = (total)/2;
            int i=0,j=0;
            while(i<n && j<m){
                if (nums1[i]<=nums2[j]){
                    if (cnt==0){
                        ele = nums1[i];
                    }
                    i++;
                }
                else {
                    if (cnt==0){
                        ele = nums2[j];
                    }
                    j++;
                }
                cnt--;
            }
            while(i<n){
                if (cnt==0){
                    ele = nums1[i];
                    // break;
                }
                cnt--;
                i++;
            }
            while(j<m){
                if (cnt==0){
                    ele = nums2[j];
                    // break;
                }
                cnt--;
                j++;
            }
            return (double)ele;
        }
        int ele1 = -1, ele2= -1, cnt1=total/2, cnt2 = (total/2)-1;
        int i = 0,j=0;
        while(i<n && j<m){
            if (nums1[i] <= nums2[j]){
                if (cnt1==0)
                    ele1 = nums1[i];
                if (cnt2==0)
                    ele2 = nums1[i];
                i++;
            }
            else {
                if (cnt1==0)
                    ele1 = nums2[j];
                if (cnt2==0)
                    ele2 = nums2[j];
                j++;
            }
            cnt1--;
            cnt2--;
        }
        while(i<n){
            if (cnt1==0)
                ele1 = nums1[i];
            if (cnt2==0)
                ele2 = nums1[i];
            cnt1--;
            cnt2--;
            i++;
        }
        while(j<m){
            if (cnt1==0)
                ele1 = nums2[j];
            if (cnt2==0)
                ele2 = nums2[j];
            cnt1--;
            cnt2--;
            j++;
        }
        return (ele1 + ele2) / 2.0;
    }
}
