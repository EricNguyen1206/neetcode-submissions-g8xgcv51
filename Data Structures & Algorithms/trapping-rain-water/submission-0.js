class Solution {
    /**
     * @param {number[]} height
     * @return {number}
     */
    trap(height) {
        let left = 0, right = height.length - 1
        let maxLeftSofar = height[left], maxRightSofar = height[right]
        let trappedWater = 0

        while (left < right) {
            const curL = height[left], curR = height[right]
            if (curL < curR) {

                if (curL >= maxLeftSofar) {
                    maxLeftSofar = curL
                } else {
                    trappedWater += maxLeftSofar - curL
                }

                left++
            } else {

                if (curR >= maxRightSofar) {
                    maxRightSofar = curR
                } else {
                    trappedWater += maxRightSofar - curR
                }

                right--
            }
        }

        return trappedWater
    }

}
