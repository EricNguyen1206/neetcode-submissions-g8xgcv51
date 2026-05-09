func largestRectangleArea(heights []int) int {
  var idxStack []int
  maxArea := 0
  h := append(heights, 0)

  for i := 0; i < len(h); i++ {
    for len(idxStack) > 0 && 
      h[i] < h[idxStack[len(idxStack) - 1]] {
      // Pop height
      height := h[idxStack[len(idxStack) - 1]]
      idxStack = idxStack[:len(idxStack) - 1]

      // Calc width
      width := i
      if len(idxStack) > 0 {
        width = i - idxStack[len(idxStack) - 1] - 1
      }
      // Update max area
      if width * height > maxArea {
        maxArea = width * height
      }
    }

    idxStack = append(idxStack, i)
  }

  return maxArea
}