func minMoves(nums []int) int {
    n := len(nums)

    if n == 0 {
        return 0
    }

    max := nums[0]
    for i := 0; i < n; i++ {
        if nums[i] > max {
            max = nums[i]
        }
    }

    operations := 0
    for i := 0; i < n; i++ {
        op := max - nums[i]
        if op < 0 {
            op = -op
        }
        operations += op
    }

    return operations
}