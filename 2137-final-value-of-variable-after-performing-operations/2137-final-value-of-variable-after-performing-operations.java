// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int n = operations.length;
        int X = 0;
        for(int i = 0; i < n ; i++) {
            if(operations[i].equals("X++") || operations[i].equals("++X")) {
                X++;
            } else {
                X--;
            }
        }
        return X;
    }
}

// my NOTES
/*
In Java:

== checks if two references point to the same object.

.equals() checks if the content of the strings is the same.

For string comparison, always use .equals() unless you're checking whether two references are the exact same object (which is rare).

*/