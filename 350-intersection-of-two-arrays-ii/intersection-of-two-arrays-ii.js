/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function(nums1, nums2) {
    let myMap = new Map();
    let res = [];

    for(let num of nums1){
        myMap.set(num, (myMap.get(num) || 0)+1);
    }

    for(let num of nums2){
        if(myMap.has(num) && myMap.get(num) > 0){
            res.push(num);

            myMap.set(num, myMap.get(num) - 1);
        }
    }

    return res;
};