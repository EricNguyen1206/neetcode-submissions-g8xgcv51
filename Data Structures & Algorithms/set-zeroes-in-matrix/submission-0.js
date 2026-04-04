class Solution {
    /**
     * @param {number[][]} matrix
     * @return {void}
     */
    setZeroes(matrix) {
        const zeroPos = []
        const rows = matrix.length, cols = matrix[0].length

        for (let i = 0; i<rows; i++) {
            for (let j = 0; j<cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroPos.push({x: i, y: j})
                }
            }
        }

        for (let i = 0; i<zeroPos.length; i++) {
            for (let r = 0; r<rows; r++) {
                matrix[r][zeroPos[i].y] = 0
            }
            for (let c = 0; c<cols; c++) {
                matrix[zeroPos[i].x][c] = 0
            }
        }
    }
}
