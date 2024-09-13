package eshaan.learning.dsa.array;

public class MergeKSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;//2
        int j=n-1;//2
        for(int k=nums1.length-1; k>=0; k--){//k=5->
            if(j<0){
                break;
            }
            if(i>=0 && nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                i--;
            }else{
                nums1[k]=nums2[j];
                j--;
            }
        }


    }
}
