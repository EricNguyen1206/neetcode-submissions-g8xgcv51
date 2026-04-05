class Solution {
    /**
     * @param {number} n
     * @return {number[]}
     */
    countBits(n) {
        function countSetBits(n) {
            let count = 0;
            while (n !== 0) {
                count += (n & 1); // incrs 1 if last bit is 1
                n >>>= 1;         // unsigned shift
            }
            return count;
        }

        const res = []

        for (let i =0; i<=n; i++) {
            const cntBit = countSetBits(i)
            res.push(cntBit)
        }

        return res
    }
}
