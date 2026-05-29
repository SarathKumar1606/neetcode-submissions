class DSU{
    vector<int> par, sz;
    int comps;
    public:
        DSU(int n):par(n),sz(n,1),comps(n){
            for(int i=0; i<n; i++){
                par[i]=i;
            }
        }
        int find(int x){
            if(par[x]==x) return x;
            return par[x]=find(par[x]);
        }
        bool  unite(int a, int b){
            a=find(a);
            b=find(b);
            if(a==b) return false;
            if(sz[a]<sz[b]) swap(a,b);
            par[b]=a;
            sz[a]+=sz[b];
            comps--;
            return true;
        }
};

class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        int n=points.size();
        vector<vector<int>> graph;
        for(int i=0;i<n;i++){
            for(int j=0; j<n; j++){
                auto e=points[i],f=points[j];
                if(e==f) continue;
                int x1=e[0],y1=e[1],x2=f[0],y2=f[1];
                int w=abs(x1-x2)+abs(y1-y2);
                graph.push_back({i,j,w});
            }
        }
        sort(graph.begin(), graph.end(),[](auto& a, auto& b){
            return a[2]<b[2];
        });
        DSU dsu(n);
        int mst=0;
        for(auto& e : graph){
            int u=e[0],v=e[1],w=e[2];
            if(dsu.unite(u,v)){
                mst+=w;
            }

        }
        return mst;

        
    }
};
