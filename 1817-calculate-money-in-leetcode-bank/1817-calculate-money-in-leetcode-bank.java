//Approach-1 (Simple simulation)
//T.C : O(1) - see the video above to know why
//S.C : O(1)
class Solution {
    public int totalMoney(int n) {
        int result = 0;
        int mondayMoney = 1;

        while (n > 0) {
            int money = mondayMoney;
            for (int day = 1; day <= Math.min(n, 7); day++) {
                result += money;
                money++;
            }

            n -= 7;
            mondayMoney++;
        }

        return result;
    }
}



/* My Appraoch
// Complexity
// Time: O(n) — single loop through all days.
// Space: O(1) — only uses constant variables.

class Solution {
    public int totalMoney(int n) {
        int leetcodeBank = 0;
        int weekCount = 1;
        int i = 0;

        int dayCount = 1;
        int count = 1;
        while (i < n) {

            if (dayCount > 7) {
                dayCount = 1;
                weekCount++;
                count = weekCount;
            }

            leetcodeBank = leetcodeBank + count;
            dayCount++;
            count++;
            i++;

        }
        return leetcodeBank;

    }
}*/


/*

//Approach-2 (Using AP and a for loop)
//T.C : O(1) - see the video above to know why
//S.C : O(1)
class Solution {
    public int totalMoney(int n) {
        int terms = n / 7; // Weeks

        int first = 28;
        int last = 28 + (terms - 1) * 7; // AP formula for n-th term

        int result = terms * (first + last) / 2; // Sum of nth terms in an AP

        // Final week remaining days = n % 7
        int startMoney = 1 + terms;

        for (int day = 1; day <= (n % 7); day++) {
            result += startMoney;
            startMoney++;
        }

        return result;
    }
}



//Approach-3 (Using AP completely)
//T.C : O(1) - see the video above to know why
//S.C : O(1)
class Solution {
    public int totalMoney(int n) {
        int terms = n / 7; // Weeks

        int first = 28;
        int last = 28 + (terms - 1) * 7; // AP formula for n-th term

        int result = terms * (first + last) / 2; // Sum of nth terms in an AP

        // Remaining days (use AP formula)
        int remain = n % 7;
        int firstTerm = 1 + terms;
        int lastTerm = firstTerm + remain - 1;
        result += remain * (firstTerm + lastTerm) / 2;

        return result;
    }
}

 */