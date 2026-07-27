class Solution {
public:
    class DSU{
        public:
        vector<int> parent;
        vector<int> size;
        DSU(int n){
            parent.resize(n);
            size.assign(n,1);
            for(int i=0; i<n; i++) parent[i]=i;
        }
        int find (int a){
            if(parent[a]==a) return a;
            return parent[a]=find(parent[a]);
        }
        bool unite(int a, int b){
            a=find(a);
            b=find(b);
            if(a==b) return false;
            if(size[b]>size[a]) swap(a,b);
            parent[b]=a;
            size[a]+=size[b];
            return true;
        }
    };
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        int n=edges.size()+1;
        DSU dsu(n);
        for(auto& e : edges){
            int u=e[0],v=e[1];
            if(!dsu.unite(u,v)) return e;
        }
        return {};
        

        
    }
};
