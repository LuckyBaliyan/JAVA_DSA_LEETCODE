/**
 * @param {string} s
 * @return {string}
 */
var majorityFrequencyGroup = function(s) {
    const freq = new Map();

    for(let ch of s){
        freq.set(ch, (freq.get(ch) || 0) + 1);
    }

    let groups = new Map();

    for(let [ch, count] of freq){

        if(!groups.has(count)){
            groups.set(count, []);
        }

        groups.get(count).push(ch);
    }

    let maxGroup = 0;
    let bestFreq = 0;

    for(let [count, chars] of groups){
        if(
            chars.length > maxGroup ||
            (chars.length == maxGroup && count > bestFreq)
        ){
            maxGroup = chars.length;
            bestFreq = count;
        }
    }

    return groups.get(bestFreq).join("");
};