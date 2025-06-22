class Solution {
public:
    // Step -1: Copy and paste DSU code
    vector<int> parent;
    vector<int> rank;

    int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    void Union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);

        if (x_parent == y_parent)
            return;

        if (rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        } else if (rank[x_parent] < rank[y_parent]) {
            parent[x_parent] = y_parent;
        } else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }

    long long countPairs(int n, vector<vector<int>>& edges) {
        parent.resize(n);
        rank.resize(n, 0);
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Step -2: Making components
        for (auto &vec : edges) {
            int u = vec[0];
            int v = vec[1];
            Union(u, v);  // You missed this
        }

        // Step -3: Map for storing "parent(component)" ---> size of component
        unordered_map<int, int> mp;
        for (int i = 0; i < n; i++) {
            int papaji = find(i); // parent or representative
            mp[papaji]++;
        }

        // Step -4: Find result from map
        long long result = 0;
        long long remainingNodes = n;

        for (auto &it : mp) {
            long long size = it.second;
            result += size * (remainingNodes - size);
            remainingNodes -= size;
        }

        return result;
    }
};
