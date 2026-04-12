class Solution {
    /**
     * @param {string} s1
     * @param {string} s2
     * @return {boolean}
     */
    checkInclusion(s1, s2) {
        const n = s1.length
        if (s2.length < n) return false

        const window1 = Array(26).fill(0)
        const window2 = Array(26).fill(0)

        const getIndex = (c) => c.charCodeAt(0) - 97 // 97 = 'a'.charCodeAt(0)
        /** 
         * @params {Array} arrS1 - s1 char freq
         * @params {Array} arrS2 - s2 char freq
          */
        const checkSameStr = (arrS1, arrS2) => {
            for (let i = 0; i<26; i++) {
                if (arrS1[i] != arrS2[i]) return false
            }
            return true
        }

        // Build window
        for (let i = 0; i < n; i++) {
            window1[getIndex(s1[i])]++
            window2[getIndex(s2[i])]++
        }
        if (checkSameStr(window1, window2)) {
            return true
        }

        for (let i = n; i < s2.length; i++) {
            window2[getIndex(s2[i-n])]--
            window2[getIndex(s2[i])]++
            if (checkSameStr(window1, window2)) {
                return true
            }
        }

        return false
    }
}
