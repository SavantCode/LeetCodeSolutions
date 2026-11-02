import (
	"sort"
)

func minMoves2(nums []int) int {
	sort.Ints(nums)
	n := len(nums)
	
	median := nums[n/2]
	operations := 0

	for i := 0; i < n; i++ {
		diff := nums[i] - median // Fixed: declare diff

		if diff < 0 { // Fixed: check diff instead of operations
			diff = -diff
		}
		operations += diff
	}
	
	return operations
}