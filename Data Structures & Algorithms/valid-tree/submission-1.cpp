class Solution {
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        if(edges.size()!=n-1) return false;
        if(n==1) return true;
        vector<vector<int>> graph(n);
         vector<int> indegree(n,0);
        for(auto& e : edges){
            int u=e[0],v=e[1];
            graph[u].push_back(v);
            graph[v].push_back(u);
            indegree[u]++;
            indegree[v]++;
        }
       
        vector<int> visited;
        queue<int> leaves;
        for(int i=0;i<n;i++){
            if(indegree[i]==1) leaves.push(i);
        }
        vector<int> topo;
        while(!leaves.empty()){
            auto node=leaves.front();
            leaves.pop();
            topo.push_back(node);
            for(auto nbr : graph[node]){
                indegree[nbr]-=1;
                if(indegree[nbr]==1) leaves.push(nbr);
            }
        }
        return topo.size()==n;

    }
};
