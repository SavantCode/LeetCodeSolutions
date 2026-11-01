package main

import (
    "math"
)

func minMoves(nums []int) int {
    n := len(nums)
    operations := 0

    //Find the minimum value in the slice
    minValue := math.MaxInt32
    for i := 0 ; i < n; i++ {
        if nums[i] < minValue {
            minValue = nums[i]
        }
    }

    //calculate total operations needed

    for i := 0; i < n; i++ {
        diff := nums[i] - minValue
        if diff < 0 {
            diff = - diff
        }
        operations += diff
    }
    return operations


}