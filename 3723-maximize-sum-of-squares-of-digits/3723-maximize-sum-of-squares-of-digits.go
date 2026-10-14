package main
import ("strconv" 
        "strings")

func maxSumOfSquares(num int, sum int) string {
    var result strings.Builder
    digit := 0;

    if sum > num * 9{
        return ""
    }

    if sum < 9 {
        result.WriteString(strconv.Itoa(sum))
        digit++;
    } else{
        totalNines := sum / 9

        for i := 0; i < totalNines; i++ {
            result.WriteString("9");
            digit++;
        }

        required := sum - (9*totalNines)

        if totalNines < num && required > 0 {
            result.WriteString(strconv.Itoa(required))
            digit++
        }
    }

    for digit < num {
        result.WriteString("0")
        digit++
    }

    return result.String()
}