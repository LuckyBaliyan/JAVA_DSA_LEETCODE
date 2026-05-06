/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function(target, nums) {
    const n = nums.length;
    let minLen = Number.MAX_VALUE;
    let left = 0;
    let sum = 0;

    for(let right  = 0; right < n; right++){
        sum += nums[right];

        while(sum >= target){
            minLen = Math.min(minLen, right - left + 1);
            sum -= nums[left++];
        }
        
    }

    return minLen == Number.MAX_VALUE ? 0 : minLen;
};