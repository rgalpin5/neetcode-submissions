func topKFrequent(nums []int, k int) []int {
    ans := make([]int, k)
    freqs := make(map[int]int)
    for _, num := range nums {
        freqs[num]++
    }
    buckets := make([][]int, len(nums) + 1)
    for num, count := range freqs {
        buckets[count] = append(buckets[count], num)
    }

    bucketIndex := len(buckets) - 1
    ansIndex := 0
    for ansIndex < k {
        if len(buckets[bucketIndex]) != 0 {
            for _, num := range buckets[bucketIndex] {
                if ansIndex < k {
                    ans[ansIndex] = num
                    ansIndex++
                }
            }
        }
        bucketIndex--
    }
    return ans

}
