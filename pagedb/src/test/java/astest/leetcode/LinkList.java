package astest.leetcode;

import com.fasterxml.jackson.databind.util.LinkedNode;
import org.junit.jupiter.api.Test;

public class LinkList {
        @Test
        public void swapPairs(LinkedNode head) {
                String str = new String("ddsada");
                int m = str.length();
                int[] num1 = new int[] {1,2,3,4,5};
                int n = num1.length;
        }
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
                int m = nums1.length;
                int n = nums2.length;
                int left = (m+n+1)/2;
                int right = (m+n+2)/2;
                return (findKth(nums1,0,nums2,0,left)+findKth(nums1,0,nums2,0,right))/2;

        }
        public int findKth(int[] nums1,int i ,int[] nums2,int j,int k){
                if( i >= nums1.length) return nums2[j+k-1];
                if( j >= nums2.length) return nums1[j+k-1];
                if(k==1) return Math.min(nums1[i],nums2[j]);
                int midVal1 = (i+k /2-1<nums1.length )? nums1[i+k/2 - 1]:Integer.MAX_VALUE;
                int midVal2 = (j+k/2-1 < nums2.length)? nums2[j+k/2 - 1]:Integer.MAX_VALUE;
                if(midVal1 < midVal2){
                        return findKth(nums1,i+k/2,nums2,j,k-k/2);
                }else{
                        return findKth(nums1,i,nums2,j+k/2,k-k/2);
                }
        }
}
