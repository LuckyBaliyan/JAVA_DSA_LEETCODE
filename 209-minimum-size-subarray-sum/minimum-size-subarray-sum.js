/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function(target, nums) {
    let minLen = Number.MAX_VALUE;
    let n = nums.length;

    let left = 0;
    let sum = 0;

    for(let right = 0; right < n; right++){
        sum += nums[right];

        while(sum >= target){
            let len = right - left + 1;
            minLen = Math.min(minLen, len);

            sum -= nums[left];

            left++;
        }
    }

    return minLen == Number.MAX_VALUE ? 0 : minLen;
};