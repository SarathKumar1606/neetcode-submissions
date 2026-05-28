class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> graph(numCourses);
        for(auto& edge : prerequisites){
            int u=edge[0],v=edge[1];
            graph[v].push_back(u);
        }
        vector<int> indegree(numCourses);
        for(int node=0; node<numCourses; node++)
            for(auto& nbr : graph[node]) indegree[nbr]++;

        queue<int> zerodegree;
        for(int node=0; node<numCourses; node++)
            if(indegree[node]==0) zerodegree.push(node);
        
        int topo=0;
        while(!zerodegree.empty()){
            auto node=zerodegree.front();
            zerodegree.pop();
            topo++;
            for(auto& nbr : graph[node]){
                indegree[nbr]--;
                if(indegree[nbr]==0) zerodegree.push(nbr);
            }
        }
        return topo==numCourses;
        
    }
};
