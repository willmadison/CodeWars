var pigIt = function (string) {
    var words = string.split(' ');

    var piggedWords = [];

    words.forEach(function (word) {
        var firstCharacter = word.substring(0, 1);
        var suffix = word.substring(1);

        piggedWords.push(suffix + firstCharacter + "ay");
    });

    return piggedWords.join(' ');
};

console.log(pigIt('Pig latin is cool')); //,'igPay atinlay siay oolcay'