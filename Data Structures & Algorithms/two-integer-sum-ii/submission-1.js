class Solution {
    /**
     * @param {number[]} numbers
     * @param {number} target
     * @return {number[]}
     */
    twoSum(numbers, target) {
        let first = 0, last = numbers.length - 1

        while (first != last) {
            const total = numbers[first] + numbers[last]
            if (total == target) {
                return [first+1, last+1]
            }
            if (total < target) {
                first++
            } else {
                last--
            }
        }

        return [first+1, last+1]
    }
}
