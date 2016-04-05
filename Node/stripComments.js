var solution = function (input, markers) {
    var lines = input.split('\n');

    var modifiedLines = [];

    lines.forEach(function (line) {
        var markerIndex = -1;

        markers.forEach(function (marker) {
            var foundAt = line.indexOf(marker);

            if (foundAt !== -1) {
                if (foundAt <= markerIndex || markerIndex === -1) {
                    markerIndex = foundAt;
                }
            }
        });

        if (markerIndex !== -1) {
            line = line.substring(0, markerIndex);
        }

        modifiedLines.push(line.trim());
    });

    return modifiedLines.join('\n');
};

console.log(solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"]));