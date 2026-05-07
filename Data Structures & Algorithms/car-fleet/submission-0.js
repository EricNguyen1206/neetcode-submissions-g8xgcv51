class Solution {
    /**
     * @param {number} target
     * @param {number[]} position
     * @param {number[]} speed
     * @return {number}
     */
    carFleet(target, position, speed) {
        const cars = position.map((pos, i) => ({
            position: pos,
            time: (target - pos) / speed[i] // t = s/v
        }));

        // Sort by position descending
        cars.sort((a, b) => b.position - a.position);

        let fleets = 0;
        let maxTime = 0;

        for (const car of cars) {
            // Nếu xe này đến chậm hơn tất cả xe trước -> fleet mới
            if (car.time > maxTime) {
            fleets++;
            maxTime = car.time;
            }
        }

        return fleets;
    }
}
