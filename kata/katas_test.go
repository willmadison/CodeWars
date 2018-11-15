package kata

import (
	"fmt"
	"reflect"
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestTwoOldestAges(t *testing.T) {
	type args struct {
		ages []int
	}
	tests := []struct {
		name string
		args args
		want [2]int
	}{
		{
			"1st",
			args{ages: []int{6, 5, 83, 5, 3, 18}},
			[2]int{18, 83},
		},
		{
			"2nd",
			args{ages: []int{1, 5, 87, 45, 8, 8}},
			[2]int{45, 87},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := TwoOldestAges(tt.args.ages); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("TwoOldestAges() = %v, want %v", got, tt.want)
			}
		})
	}
}

func TestValidParentheses(t *testing.T) {
	type args struct {
		parens string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			"1st",
			args{parens: "()"},
			true,
		},
		{
			"1st",
			args{parens: ")"},
			false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := ValidParentheses(tt.args.parens); got != tt.want {
				t.Errorf("ValidParenthesis() = %v, want %v", got, tt.want)
			}
		})
	}
}

func TestRemoveNb(t *testing.T) {
	tests := []struct {
		m    uint64
		want [][2]uint64
	}{
		{
			26,
			[][2]uint64{{15, 21}, {21, 15}},
		},
		{
			100,
			nil,
		},
		{
			101,
			[][2]uint64{{55, 91}, {91, 55}},
		},
		{
			102,
			[][2]uint64{{70, 73}, {73, 70}},
		},
		{
			110,
			[][2]uint64{{70, 85}, {85, 70}},
		},
	}

	for _, tt := range tests {
		t.Run(fmt.Sprintf("RemoveNb(%v)", tt.m), func(t *testing.T) {
			if got := RemoveNb(tt.m); !assert.Equal(t, tt.want, got) {
				t.Errorf("RemoveNb(%v)= %v, want %v", tt.m, got, tt.want)
			}
		})
	}
}

func TestHasUniqueChar(t *testing.T) {
	tests := []struct {
		given string
		want  bool
	}{
		{
			"  nAa",
			false,
		},
		{
			"abcde",
			true,
		},
		{
			"++-",
			false,
		},
		{
			"AaBbC",
			true,
		},
	}

	for _, tt := range tests {
		t.Run(fmt.Sprintf("HasUniqueChar(%v)", tt.given), func(t *testing.T) {
			if got := HasUniqueChar(tt.given); !assert.Equal(t, tt.want, got) {
				t.Errorf("HasUniqueChar(%v)= %v, want %v", tt.given, got, tt.want)
			}
		})
	}
}

func TestBandNameGenerator(t *testing.T) {
	tests := []struct {
		given string
		want  string
	}{
		{
			"knife",
			"The Knife",
		},
		{
			"tart",
			"Tartart",
		},
		{
			"sandles",
			"Sandlesandles",
		},
		{
			"bed",
			"The Bed",
		},
	}

	for _, tt := range tests {
		t.Run(fmt.Sprintf("bandNameGenerator(%v)", tt.given), func(t *testing.T) {
			if got := bandNameGenerator(tt.given); !assert.Equal(t, tt.want, got) {
				t.Errorf("bandNameGenerator(%v)= %v, want %v", tt.given, got, tt.want)
			}
		})
	}
}

func TestDecodeMorse(t *testing.T) {
	t.Skip("disabling here as the morse code table isn't available locally")
	tests := []struct {
		given string
		want  string
	}{
		{
			".... . -.--   .--- ..- -.. .",
			"HEY JUDE",
		},
	}

	for _, tt := range tests {
		t.Run(fmt.Sprintf("DecodeMorse(%v)", tt.given), func(t *testing.T) {
			if got := DecodeMorse(tt.given); !assert.Equal(t, tt.want, got) {
				t.Errorf("DecodeMorse(%v)= %v, want %v", tt.given, got, tt.want)
			}
		})
	}
}

func TestDNAStrand(t *testing.T) {
	tests := []struct {
		given string
		want  string
	}{
		{
			"AAAA",
			"TTTT",
		},
		{
			"ATTGC",
			"TAACG",
		},
		{
			"GTAT",
			"CATA",
		},
	}

	for _, tt := range tests {
		t.Run(fmt.Sprintf("DNAStrand(%v)", tt.given), func(t *testing.T) {
			if got := DNAStrand(tt.given); !assert.Equal(t, tt.want, got) {
				t.Errorf("DNAStrand(%v)= %v, want %v", tt.given, got, tt.want)
			}
		})
	}
}

func TestFindShort(t *testing.T) {
	tests := []struct {
		given string
		want  int
	}{
		{
			"bitcoin take over the world maybe who knows perhaps",
			3,
		},
		{
			"turns out random test cases are easier than writing out basic ones",
			3,
		},
	}

	for _, tt := range tests {
		t.Run(fmt.Sprintf("FindShort(%v)", tt.given), func(t *testing.T) {
			if got := FindShort(tt.given); !assert.Equal(t, tt.want, got) {
				t.Errorf("FindShort(%v)= %v, want %v", tt.given, got, tt.want)
			}
		})
	}
}

func TestAccum(t *testing.T) {
	tests := []struct {
		given string
		want  string
	}{
		{
			"ZpglnRxqenU",
			"Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu",
		},
		{
			"NyffsGeyylB",
			"N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb",
		},
	}

	for _, tt := range tests {
		t.Run(fmt.Sprintf("Accum(%v)", tt.given), func(t *testing.T) {
			if got := Accum(tt.given); !assert.Equal(t, tt.want, got) {
				t.Errorf("Accum(%v)= %v, want %v", tt.given, got, tt.want)
			}
		})
	}
}

func TestPotatoes(t *testing.T) {
	tests := []struct {
		given struct {
			p0, w0, p1 int
		}
		want int
	}{
		{
			struct {
				p0, w0, p1 int
			}{99, 100, 98},
			50,
		},
		{
			struct {
				p0, w0, p1 int
			}{82, 127, 80},
			114,
		},
	}

	for _, tt := range tests {
		t.Run(fmt.Sprintf("Potatoes(%v)", tt.given), func(t *testing.T) {
			if got := Potatoes(tt.given.p0, tt.given.w0, tt.given.p1); !assert.Equal(t, tt.want, got) {
				t.Errorf("Potatoes(%v)= %v, want %v", tt.given, got, tt.want)
			}
		})
	}
}

func TestToNato(t *testing.T) {
	tests := []struct {
		given string
		want string
	}{
		{
			"If you can read",
			"India Foxtrot Yankee Oscar Uniform Charlie Alfa November Romeo Echo Alfa Delta",
		},
		{
			"Did not see that coming",
			"Delta India Delta November Oscar Tango Sierra Echo Echo Tango Hotel Alfa Tango Charlie Oscar Mike India November Golf",
		},
		{
			"go for it!",
			"Golf Oscar Foxtrot Oscar Romeo India Tango !",
		},
	}

	for _, tt := range tests {
		t.Run(fmt.Sprintf("ToNato(%v)", tt.given), func(t *testing.T) {
			if got := ToNato(tt.given); !assert.Equal(t, tt.want, got) {
				t.Errorf("ToNato(%v)= %v, want %v", tt.given, got, tt.want)
			}
		})
	}
}

func TestValidateSudokuSolution(t *testing.T) {
	tests := []struct {
		given [][]int
		want bool
	}{
		{
			[][]int{
				{5, 3, 4, 6, 7, 8, 9, 1, 2},
				{6, 7, 2, 1, 9, 5, 3, 4, 8},
				{1, 9, 8, 3, 4, 2, 5, 6, 7},
				{8, 5, 9, 7, 6, 1, 4, 2, 3},
				{4, 2, 6, 8, 5, 3, 7, 9, 1},
				{7, 1, 3, 9, 2, 4, 8, 5, 6},
				{9, 6, 1, 5, 3, 7, 2, 8, 4},
				{2, 8, 7, 4, 1, 9, 6, 3, 5},
				{3, 4, 5, 2, 8, 6, 1, 7, 9},
			},
			true,
		},
		{
			[][]int{
				{5, 3, 4, 6, 7, 8, 9, 1, 2},
				{6, 7, 2, 1, 9, 0, 3, 4, 8},
				{1, 0, 0, 3, 4, 2, 5, 6, 0},
				{8, 5, 9, 7, 6, 1, 0, 2, 0},
				{4, 2, 6, 8, 5, 3, 7, 9, 1},
				{7, 1, 3, 9, 2, 4, 8, 5, 6},
				{9, 0, 1, 5, 3, 7, 2, 1, 4},
				{2, 8, 7, 4, 1, 9, 6, 3, 5},
				{3, 0, 0, 4, 8, 1, 1, 7, 9},
			},
			false,
		},
	}

	for _, tt := range tests {
		t.Run(fmt.Sprintf("ValidateSolution(%v)", tt.given), func(t *testing.T) {
			if got := ValidateSolution(tt.given); !assert.Equal(t, tt.want, got) {
				t.Errorf("ValidateSolution(%v)= %v, want %v", tt.given, got, tt.want)
			}
		})
	}
}

func TestSolution(t *testing.T) {
	tests := []struct {
		given []int
		want string
	}{
		{
			[]int{-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18,19,20},
			"-6,-3-1,3-5,7-11,14,15,17-20",
		},
		{
			[]int{78, 79, 81, 82, 86, 87, 93, 97, 104, 110, 111, 112, 119, 124, 125, 129, 130, 131, 138},
			"78,79,81,82,86,87,93,97,104,110-112,119,124,125,129-131,138",
		},
	}

	for _, tt := range tests {
		t.Run(fmt.Sprintf("Solution(%v)", tt.given), func(t *testing.T) {
			if got := Solution(tt.given); !assert.Equal(t, tt.want, got) {
				t.Errorf("Solution(%v)= %v, want %v", tt.given, got, tt.want)
			}
		})
	}
}
