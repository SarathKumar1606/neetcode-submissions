class Solution {
public:
    void visit(vector<vector<int>>& graph, int node, vector<bool>& visited){
        visited[node]=true;
        for(auto& nbr : graph[node]){
            if(!visited[nbr]) visit(graph,nbr,visited);
        }

    }
    int countComponents(int n, vector<vector<int>>& edges) {
        vector<vector<int>> graph(n);
        for(auto & e : edges){
            int u=e[0],v=e[1];
            graph[u].push_back(v);
            graph[v].push_back(u);
        }
        vector<bool> visited(n,false);
        int count=0;
        for(int node=0; node<n;node++){
            if(!visited[node]){
                visit(graph,node,visited);
                count++;

            }

        }
        return count;



    }
};
