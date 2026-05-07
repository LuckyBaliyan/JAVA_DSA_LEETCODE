/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    let map = new Map();

    for(let num of nums){
        map.set(num, (map.get(num) || 0) + 1);
        if(map.get(num) > 1)return true;
    }

    return false;
};