class Solution {
public:
    class DSU{
        public:
        vector<int> parent;
        vector<int> size;
        int comp;
        DSU(int n){
            parent.resize(n);
            size.resize(n);
            for(int i=0; i<n; i++){
                parent[i]=i;
                size[i]=1;
            }
            comp=0;
        }
        void addLand(){
            comp++;
        }
        int find(int a){
            if(parent[a]==a) return a;
            return parent[a]=find(parent[a]);
        }
        bool unite(int a , int b){
            a=find(a);
            b=find(b);
            if(a==b)return false;
            if(size[a]<size[b]){
                swap(a,b);
            }
            parent[b]=a;
            size[a]+=size[b];
            comp--;
            return true;
        }
    };

    int numIslands(vector<vector<char>>& grid) {
        int m=grid.size(), n=grid[0].size();
        DSU dsu(m*n);
       for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
                if(grid[i][j]=='1')
                    dsu.addLand();
            }
       }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    int curr=i*n+j;
                    if(j+1<n && grid[i][j+1]=='1'){
                        int right=i*n+(j+1);
                        dsu.unite(curr,right);
                    }
                    if(i+1<m && grid[i+1][j]=='1'){
                        int down=(i+1)*n+j;
                        dsu.unite(curr,down);
                    }
                }
            }
        }
        return dsu.comp;
        
    }
};
