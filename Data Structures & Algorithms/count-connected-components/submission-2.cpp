class Solution {
public:
    class DSU{
        public:
        vector<int> parent;
        vector<int> size;
        int comp;
        DSU(int n){
            parent.resize(n);
            size.assign(n,1);
            for(int i=0; i<n; i++) parent[i]=i;
            comp=n;
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
            comp--;
            return true;
        }
    };
    int countComponents(int n, vector<vector<int>>& edges) {
        DSU dsu(n);
        for(auto & e : edges){
            int u=e[0],v=e[1];
            dsu.unite(u,v);
            
        }
        return dsu.comp;



    }
};
