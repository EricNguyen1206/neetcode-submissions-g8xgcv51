class Solution {
    /**
     * @param {number} n - a positive integer
     * @return {number} - a positive integer
     */
    reverseBits(n) {
        let res = 0;
        for (let i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1); // Đẩy res sang trái, lấy bit cuối của n bỏ vào đuôi res
            n >>= 1; // Bỏ bit cuối của n đã xử lý
        }
        return res >>> 0;
    }
}
