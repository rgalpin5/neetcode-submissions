func hasDuplicate(nums []int) bool {
    seen := make(map[int]struct{} )
    for num := range nums {
        if _, ok := seen[nums[num]]; ok{
            return true
        } else {
            seen[nums[num]] = struct{}{}
        }
    }
    return false
}
