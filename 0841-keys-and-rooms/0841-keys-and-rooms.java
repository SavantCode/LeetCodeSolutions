// TC: O(V + E)
// SC: O(V)
// Where:

// V = number of rooms
// E = total number of keys/edges across all rooms
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();

        boolean visited[] = new boolean[n];

        dfs(0 ,rooms, visited);

        for(boolean flag : visited){
            if(flag == false){
                return false;
            }
        }
        return true;
    }

    public void dfs(int src, List<List<Integer>> adj, boolean visited[]){

        visited[src] = true;

        for(int neighbour : adj.get(src)){

            if(!visited[neighbour]){
                dfs(neighbour, adj, visited);
            }
        }

    }
}
