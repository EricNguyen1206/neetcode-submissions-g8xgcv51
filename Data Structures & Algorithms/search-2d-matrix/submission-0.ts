class Solution {
    /**
     * @param {number[][]} matrix
     * @param {number} target
     * @return {boolean}
     */
    searchMatrix(matrix: number[][], target: number): boolean {
        const rows = matrix.length
        const cols = matrix[0].length

        let l = 0
        let r = rows * cols - 1

        while (l <= r) {
            const m = l + Math.floor((r - l) / 2)

            const row = Math.floor(m/cols)
            const col = Math.floor(m%cols)

            if (target > matrix[row][col]) {
                l = m+1
            } else if (target < matrix[row][col]) {
                r = m-1
            } else {
                return true
            }
        }
        return false
    }
}
