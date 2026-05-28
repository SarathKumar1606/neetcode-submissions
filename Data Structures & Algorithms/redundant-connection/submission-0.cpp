class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        int n=edges.size();
        vector<vector<int>> graph(n+1);
        for(auto& e : edges){
            int u=e[0],v=e[1];
            graph[u].push_back(v);
            graph[v].push_back(u);
        }
        vector<int> indegree(n+1,0);
        for(int i=1; i<=n ; i++)
            for(auto& nbr : graph[i])
                indegree[nbr]++;
        queue<int> onedegree;
        for(int i=1; i<=n; i++)
            if(indegree[i]==1) onedegree.push(i);
        
        while(!onedegree.empty()){
            auto node=onedegree.front();
            onedegree.pop();
            for(auto& nbr : graph[node]){
                indegree[nbr]--;
                if(indegree[nbr]==1) onedegree.push(nbr);
            }
        }
       
        for(int i=n-1; i>=0; i--){
            auto edge=edges[i];
            int u=edge[0],v=edge[1];
            if(indegree[u]==2 && indegree[v]==2)
                return {u,v};
        }
        return {-1,-1};

        
    }
};
