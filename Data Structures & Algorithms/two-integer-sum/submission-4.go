func twoSum(nums []int, target int) []int {
    complements := make(map[int]int)
    for index, num := range nums {
        complement := target - num
        if val, found := complements[complement]; found{
            return []int{val, index}
        } else {
            complements[num] = index
        }
    }
    return nil
}
