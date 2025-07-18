//Time Complexity : O(n*k)
//Space Complexity : O(n)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
      int[] dp = new int [arr.length];
      dp[0] = arr[0];
      for(int i=1; i<arr.length; i++){
        int max = arr[i];
        for(int j =1; j<=k && i-j +1 >=0;j++){
            int curr = arr[i-j+1];
            max = Math.max(max, curr);
            if(i - j >= 0){
                dp[i] = Math.max(dp[i], max*j+dp[i-j]);
            }else{
                dp[i]= Math.max(dp[i], max*j);
            }
        }
      }   
      return dp[arr.length-1];
    }
}
