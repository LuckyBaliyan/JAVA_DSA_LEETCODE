/**
 * @param {string} s
 * @return {character}
 */
var repeatedCharacter = function(s) {
    const set = new Set();

    for(let letter of s){
        if(set.has(letter))return letter;

        set.add(letter);
    }

    return null;
};