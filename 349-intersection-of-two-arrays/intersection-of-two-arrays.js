/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersection = function(nums1, nums2) {
    let set1 = new Set();
    let set2 = new Set();
    let resSet = new Set();

    let res = [];

    for(let num of nums1)set1.add(num);
    for(let num of nums2)set2.add(num);

    if(set1.size > set2.size){
        for(let num of nums1){
            if(set1.has(num) && set2.has(num))resSet.add(num);
        }
    }
    else{
        for(let num of nums2){
            if(set2.has(num) && set1.has(num))resSet.add(num);
        }
    }

   for(let val of resSet.values())res.push(val);

   return res;
};