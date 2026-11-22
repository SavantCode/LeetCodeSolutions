class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int n = people.length;
        int left = 0;
        int right = n -1;

        int requiredBoats = 0;

        while(left <= right){

            if(left != right && ((people[left] + people[right]) <= limit)){
                left++;
                right--;
                requiredBoats++;
            }
            else{
                right--;
                requiredBoats++;

            }
        }
        return requiredBoats;
    }
}
