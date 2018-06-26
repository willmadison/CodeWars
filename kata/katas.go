package kata

import (
	"bytes"
	"sort"
	"strings"
)

func TwoOldestAges(ages []int) [2]int {
	sort.Slice(ages, func(i, j int) bool {
		return ages[i] < ages[j]
	})
	return [2]int{ages[len(ages)-2], ages[len(ages)-1]}
}

func ValidParentheses(parens string) bool {
	counter := 0
	for _, character := range parens {
		if character == '(' {
			counter++
		} else if character == ')' {
			counter--
		}

		if counter < 0 {
			return false
		}
	}

	return counter == 0
}

func RemoveNb(m uint64) [][2]uint64 {
	var pairs [][2]uint64
	var a, b uint64

	sum := m * (m + 1) / 2

	for a = 1; a <= m; a++ {
		i := float64(sum-a) / float64(a+1)

		if b = uint64(i); float64(b) == i && b != a && b <= m {
			pairs = append(pairs, [2]uint64{a, b})
		}
	}

	return pairs
}

func HasUniqueChar(given string) bool {
	characters := map[rune]struct{}{}

	for _, c := range given {
		if _, seen := characters[c]; seen {
			return false
		}

		characters[c] = struct{}{}
	}

	return true
}

func bandNameGenerator(word string) string {
	if word[0] == word[len(word)-1] {
		return strings.Title(word + string(word[1:]))
	} else {
		return "The " + strings.Title(word)
	}
}

var MORSE_CODE = map[string]string{}

func DecodeMorse(morseCode string) string {
	words := strings.Split(morseCode, "   ")

	var b bytes.Buffer

	for _, word := range words {
		characters := strings.Fields(word)

		for _, c := range characters {
			b.WriteString(MORSE_CODE[c])
		}

		b.WriteString(" ")
	}

	return strings.TrimSpace(b.String())
}
