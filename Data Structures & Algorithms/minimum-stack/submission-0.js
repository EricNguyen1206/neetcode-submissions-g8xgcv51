class MinStack {
    constructor() {
        this.stack = []
    }

    /**
     * @param {number} val
     * @return {void}
     */
    push(val) {
        if (this.stack.length == 0) {
            this.stack.push([val, val])
            return
        }
        
        let newMin = this.stack[this.stack.length-1][1]
        newMin = Math.min(newMin, val)
        this.stack.push([val, newMin])
    }

    /**
     * @return {void}
     */
    pop() {
        this.stack.pop()
    }

    /**
     * @return {number}
     */
    top() {
        return this.stack[this.stack.length-1][0]
    }

    /**
     * @return {number}
     */
    getMin() {
        return this.stack[this.stack.length-1][1]
    }
}
