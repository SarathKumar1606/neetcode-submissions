class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        vector<vector<pair<int,int>>> adj(n+1);
        for(auto& e: times){
            int u=e[0],v=e[1],wt=e[2];
            adj[u].push_back({v,wt});
        }

        vector<int> dist(n+1, INT_MAX);
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
        int src;
        dist[k]=0;
        pq.push({0,k});
        while(!pq.empty()){
            auto [d,node]=pq.top();
            pq.pop();
            if(d>dist[node]) continue;
            for(auto [nbr,wt]:adj[node]){
                if(dist[node]+wt<dist[nbr]){
                    dist[nbr]=dist[node]+wt;
                    pq.push({dist[nbr],nbr});
                }
            }
        }
        int mintime=INT_MIN;
        for(int i=1; i<n+1; i++){
            int time=dist[i];
            if(time==INT_MAX) return -1;
            mintime=max(mintime,time);

        }
        return mintime;
        
    }
};
