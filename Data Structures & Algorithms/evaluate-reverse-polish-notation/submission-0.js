class Solution {
    /**
     * @param {string[]} tokens
     * @return {number}
     */
    evalRPN(tokens) {
        const operations =  new Set(['+', '-', '*', '/'])
        const numsStack = [] // Number[]
        
        for (const t of tokens) {
            if (operations.has(t)) {
                const num1 = numsStack.pop()
                const num2 = numsStack.pop()
                let newVal = 0
                switch (t) {
                    case '+':
                        newVal = num2 + num1
                        numsStack.push(newVal)
                        break
                    case '-':
                        newVal = num2 - num1
                        numsStack.push(newVal)
                        break
                    case '*':
                        newVal = num2 * num1
                        numsStack.push(newVal)
                        break
                    case '/':
                        newVal = Math.trunc(num2 / num1)
                        numsStack.push(newVal)
                        break
                }
            } else {
                numsStack.push(parseInt(t))
            }

        }

        return numsStack[0]
    }
}
