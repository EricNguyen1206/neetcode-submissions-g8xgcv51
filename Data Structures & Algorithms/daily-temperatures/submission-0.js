class Solution {
    /**
     * @param {number[]} temperatures
     * @return {number[]}
     */
    dailyTemperatures(temperatures) {
        const stack = []
        const n = temperatures.length
        const res = Array(n).fill(0)

        for (let i = 0; i<n; i++) {
            const curT = temperatures[i]
            while (stack.length && temperatures[stack[stack.length-1]] < curT) {
                const lastIdx = stack.pop()
                res[lastIdx] = i - lastIdx
            }
            stack.push(i)
        }
        return res
    }
}
