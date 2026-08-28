func isAnagram(s string, t string) bool {
    frequencies := make(map[string]int)
    if len(s) != len(t) {
        return false
    }
    for i := range(len(s)) {
        frequencies[string(s[i])] += 1
    }
    for i := range(len(s)) {
        frequencies[string(t[i])] -= 1
    }
    for i := range(len(s)) {
        if frequencies[string(s[i])] != 0 {
            return false
        }
    }
    return true
}
