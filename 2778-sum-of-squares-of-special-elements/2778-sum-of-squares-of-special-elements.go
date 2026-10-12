package main

import "fmt"

func sumOfSquares( nums []int ) int {
    n := len(nums)
    sum := 0

    for i:= 0; i < n; i++ {
        x := i +1
        if n % x == 0 {
            fmt.Printf("%d", x);
            sum += nums[i] * nums[i];
        }
    }
    return sum
}