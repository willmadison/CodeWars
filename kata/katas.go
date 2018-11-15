package kata

import (
	"bytes"
	"math"
	"sort"
	"strconv"
	"strings"
	"unicode"
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

var nucleotideComplements = map[rune]rune{
	'A': 'T',
	'T': 'A',
	'C': 'G',
	'G': 'C',
}

func DNAStrand(sequence string) string {
	var b bytes.Buffer

	for _, n := range sequence {
		b.WriteRune(nucleotideComplements[n])
	}

	return b.String()
}

func FindShort(words string) int {
	minLength := math.MaxInt64

	for _, word := range strings.Fields(words) {
		length := len(word)
		if length < minLength {
			minLength = length
		}
	}

	return minLength
}

func Accum(expression string) string {
	var buf bytes.Buffer

	for i, l := range expression {
		upper, lower := unicode.ToUpper(l), unicode.ToLower(l)

		for j := 0; j < i+1; j++ {
			if j == 0 {
				buf.WriteRune(upper)
				continue
			}

			buf.WriteRune(lower)
		}

		if i < len(expression)-1 {
			buf.WriteRune('-')
		}
	}

	return buf.String()
}

func Potatoes(p0, w0, p1 int) int {
	return w0 * (100.0 - p0) / (100 - p1)
}

func ToNato(words string) string {
	nato := []string{"Alfa", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliett", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "X-ray", "Yankee", "Zulu"}

	runeToNato := mapRunesToNato(nato)

	var buf bytes.Buffer

	for _, c := range words {
		switch {
		case unicode.IsLetter(c):
			buf.WriteString(runeToNato[unicode.ToLower(c)])
		case unicode.IsSpace(c):
			continue
		default:
			buf.WriteRune(c)
		}

		buf.WriteRune(' ')
	}

	return strings.TrimSpace(buf.String())
}

func mapRunesToNato(nato []string) map[rune]string {
	runeToNato := map[rune]string{}

	for i, n := range nato {
		runeToNato[rune('a'+i)] = n
	}

	return runeToNato
}

func ValidateSolution(board [][]int) bool {
	return cellsAreValid(board) &&
		rowsAreValid(board) &&
		columnsAreValid(board)
}

func cellsAreValid(board [][]int) bool {
	for cell := 1; cell < 10; cell++ {
		valid := validateCell(cell, board)

		if !valid {
			return false
		}
	}

	return true
}

func validateCell(cell int, board [][]int) bool {
	rowStart, rowEnd := getRowBounds(cell)
	colStart, colEnd := getColBounds(cell)

	seen := make([]bool, 9)

	for row := rowStart; row <= rowEnd; row++ {
		for col := colStart; col <= colEnd; col++ {
			v := board[row][col]

			if v == 0 || seen[v-1] {
				return false
			}

			seen[v-1] = true

		}
	}

	for _, present := range seen {
		if !present {
			return false
		}
	}

	return true
}

func getRowBounds(cell int) (int, int) {
	switch {
	case 1 <= cell && cell <= 3:
		return 0, 2
	case 4 <= cell && cell <= 6:
		return 3, 5
	case 7 <= cell && cell <= 9:
		return 6, 8
	default:
		return -1, -1
	}
}

func getColBounds(cell int) (int, int) {
	switch {
	case cell == 1 || cell == 4 || cell == 7:
		return 0, 2
	case cell == 2 || cell == 5 || cell == 8:
		return 3, 5
	case cell == 3 || cell == 6 || cell == 9:
		return 6, 8
	default:
		return -1, -1
	}
}

func rowsAreValid(board [][]int) bool {
	for _, row := range board {
		seen := make([]bool, 9)

		for _, v := range row {
			if v == 0 || seen[v-1] {
				return false
			}

			seen[v-1] = true
		}

		for _, present := range seen {
			if !present {
				return false
			}
		}
	}

	return true
}

func columnsAreValid(board [][]int) bool {
	for row := 0; row < len(board); row++ {
		seen := make([]bool, 9)

		for col := 0; col < len(board[row]); col++ {
			v := board[row][col]

			if v == 0 || seen[v-1] {
				return false
			}

			seen[v-1] = true
		}

		for _, present := range seen {
			if !present {
				return false
			}
		}
	}

	return true
}

func Solution(numbers []int) string {
	var buf bytes.Buffer
	var i int

	for i < len(numbers) {
		buf.WriteString(strconv.Itoa(numbers[i]))

		var rangeStart, rangeEnd int

		if i < len(numbers)-1 && numbers[i+1]-numbers[i] == 1 {
			rangeStart = i

			for numbers[i+1]-numbers[i] == 1 {
				i++

				if i == len(numbers)-1 {
					break
				}
			}

			rangeEnd = i
		}

		if rangeEnd-rangeStart >= 2 { // Valid range must be at least three numbers...
			buf.WriteRune('-')
			buf.WriteString(strconv.Itoa(numbers[rangeEnd]))
		} else if rangeEnd != 0 {
			i = rangeStart
		}

		buf.WriteRune(',')
		i++
	}

	return strings.TrimRight(buf.String(), ",")
}
