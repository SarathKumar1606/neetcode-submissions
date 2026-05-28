class Solution {
public:
    vector<vector<int>> dirs={{-1,0},{0,-1},{1,0},{0,1}};
    bool is_valid(vector<vector<int>>& grid, int x, int y){
        return (x>=0 && x<grid.size() && y>=0 && y<grid[0].size() && grid[x][y]!=-1);
    }
    void islandsAndTreasure(vector<vector<int>>& grid) {
        int m=grid.size(), n=grid[0].size();
        vector<vector<int>> distances(m,vector<int>(n,2147483647));
        queue<pair<int,int>> q;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==-1){
                    distances[i][j]=-1;
                }else if(grid[i][j]==0){
                    distances[i][j]=0;
                    q.push({i,j});
                }
            }
        }
        while(!q.empty()){
            auto [x,y]=q.front();
            q.pop();
            for(auto&d : dirs){
                int nr=x+d[0],nc=y+d[1];
                if(is_valid(grid,nr,nc) &&
                   distances[nr][nc]==2147483647){
                    distances[nr][nc]=distances[x][y]+1;
                    q.push({nr,nc});
                }
            }
        }
        grid= distances;
        
    }
};
