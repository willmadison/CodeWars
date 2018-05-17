package kata

import "sort"

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
		for b = a + 1; b <= m; b++ {
			product := a * b
			difference := sum - (a + b)

			if product == difference {
				pairs = append(pairs, [2]uint64{a, b}, [2]uint64{b, a})
			}
		}
	}

	return pairs
}
