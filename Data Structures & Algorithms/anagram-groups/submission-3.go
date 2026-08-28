func groupAnagrams(strs []string) [][]string {
    freqmap := make(map[[26]int][]string)
    for _, str := range strs {
        var charfreq [26]int 
        for _, char := range str {
            charfreq[char - 'a']++
        }
        freqmap[charfreq] = append(freqmap[charfreq], str)
    }
    result := make([][]string, 0, len(freqmap))
    for _, group := range freqmap {
        result = append(result, group)
    }
    return result
}
