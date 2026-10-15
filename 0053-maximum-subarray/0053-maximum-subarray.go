package main
import ( "math")

func maxSubArray(nums []int) int {

    n := len(nums)
    maxSum := math.MinInt
    currSum := 0

    for i := 0 ; i < n ; i++ {

        currSum += nums[i]

        maxSum = max(nums[i], max(currSum, maxSum))

        if currSum < 0 {
            currSum = 0;
        }

    }
    return maxSum
}