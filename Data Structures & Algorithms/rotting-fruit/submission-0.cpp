class Solution {
public:
    vector<vector<int>> dirs={{-1,0},{0,-1},{1,0},{0,1}};
    bool is_valid(vector<vector<int>>& grid, int x, int y,vector<vector<int>> & dist){
        return (x>=0 && x<grid.size() && y>=0 && y<grid[0].size() && grid[x][y]==1&& dist[x][y]==0);
    }
    int orangesRotting(vector<vector<int>>& grid) {
        int m=grid.size(),n=grid[0].size();
        vector<vector<int>> dist(m, vector<int>(n, 0));
        queue<pair<int,int>> q;
        int fresh=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2) q.push({i,j});
                else if(grid[i][j]==1) fresh++;
                dist[i][j]=0;
            }
        }
        int maxl=0;
        while(!q.empty()){
            auto [x,y]=q.front();
            q.pop();
            for(auto& d : dirs){
                int nr=x+d[0];
                int nc=y+d[1];
                if(is_valid(grid,nr,nc,dist)){
                    grid[nr][nc]=2;
                    dist[nr][nc]=dist[x][y]+1;
                    maxl=max(maxl,dist[nr][nc]);
                    fresh--;
                    q.push({nr,nc});
                }
            }
        }
        
       return fresh==0 ? maxl : -1;
        
    }
};
