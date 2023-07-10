package com.teclogi.app.Services;

import com.teclogi.app.Models.MoneyStolen;

public class robServices {


    public MoneyStolen rob(int[] nums){

        MoneyStolen resultObject = new MoneyStolen();

        int n = nums.length;
        if (n == 0) {
            resultObject.setMoneyStolen(0);
            return resultObject;
        }
        if (n == 1) {
            resultObject.setMoneyStolen(nums[0]);
            return resultObject;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        resultObject.setMoneyStolen(dp[n-1]);
        return resultObject;
    }

    


}
