class Solution {
public:
    bool is_valid(vector<vector<char>>& grid,vector<vector<bool>>& visited, int x, int y){
        return (x>=0 && x<grid.size() && y>=0 && y<grid[0].size()&&!visited[x][y] && grid[x][y]=='1');
    }
    void visit(vector<vector<char>>& grid,vector<vector<bool>>& visited, int x, int y, vector<vector<int>>& dirs){
        visited[x][y]=true;
        for(auto d : dirs){
            int nr=x+d[0];
            int nc=y+d[1];
            if(is_valid(grid,visited,nr,nc)){
                visit(grid,visited,nr,nc,dirs);
            }
        }
    }

    int numIslands(vector<vector<char>>& grid) {
        vector<vector<int>> dirs={{-1,0},{0,-1},{1,0},{0,1}};
        vector<vector<bool>> visited(grid.size(),vector<bool>(grid[0].size()));
        int count=0;
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid[0].size(); j++){
                if(!visited[i][j]&& grid[i][j]=='1'){
                    visit(grid,visited,i,j,dirs);
                    count++;
                }

            }
        }
        return count;
        
    }
};
