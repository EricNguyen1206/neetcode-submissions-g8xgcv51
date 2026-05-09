class Solution {
    /**
     * @param {number[]} heights
     * @return {number}
     */
    largestRectangleArea(heights) {
      const idxStack = [] // stack of index have no-desc heights
      let maxArea = 0
      const h = [...heights, 0] // add sentinel value, avoid mutate input

      for (let i = 0; i < h.length; i++) {
        // if current h < top stack height
        //  -> it's the right corner of rectanle
        //  -> remove all higher histogram to calc Area
        while (
          idxStack.length > 0 && 
          h[idxStack.at(-1)] > h[i]
        ) {
          const height = h[idxStack.pop()]
          const width = idxStack.length > 0 
          ? i - idxStack.at(-1) - 1
          : i
          const newArea = width * height
          maxArea = Math.max(maxArea, newArea)
        }

        idxStack.push(i)
      }

      return maxArea
    }
}
