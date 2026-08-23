class Solution {
    boolean[][][] oceans;
    int[][] heights;
    int[][] vis;
    int[] di = {-1, 0, 1, 0};
    int[] dj = {0, -1, 0, 1};

    boolean isValid(int i, int j, int n, int m) {
        return !(
            i < 0 || i >= n || j < 0 || j >= m
        );
    }

    private void waterFlows(int i, int j, char ocean, int n, int m) {
        vis[i][j] = 1;
        if(ocean == 'P')
            oceans[i][j][0] = true;
        else
            oceans[i][j][1] = true;
        
        for(int k=0;k<4;k++) {
            int ni = i + di[k];
            int nj = j + dj[k];

            if(!isValid(ni, nj, n, m) || vis[ni][nj] == 1)
                continue;
            
            if(heights[ni][nj] < heights[i][j])
                continue;
            
            waterFlows(ni, nj, ocean, n, m);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        this.heights = heights;

        vis = new int[n][m];
        oceans = new boolean[n][m][2];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                oceans[i][j][0] = false;
                oceans[i][j][1] = false;
            }
        }

        // flow from pacific:
        for(int j=0;j<m;j++) {
            if(vis[0][j] == 1)
                continue;
            
            waterFlows(0, j, 'P', n, m);
        }

        for(int i=0;i<n;i++) {
            if(vis[i][0] == 1)
                continue;
            
            waterFlows(i, 0, 'P', n, m);
        }

        // mark all unvisited:
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                vis[i][j] = 0;
            }
        }

        // flow from atlantic:
        for(int j=0;j<m;j++) {
            if(vis[n-1][j] == 1)
                continue;
            
            waterFlows(n-1, j, 'A', n, m);
        }

        for(int i=0;i<n;i++) {
            if(vis[i][m-1] == 1)
                continue;
            
            waterFlows(i, m-1, 'A', n, m);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(oceans[i][j][0] && oceans[i][j][1])
                    ans.add(new ArrayList<>(Arrays.asList(i, j)));
            }
        }

        return ans;
    }
}
