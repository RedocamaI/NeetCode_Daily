class CountSquares {
    int[][] points;
    public CountSquares() {
        points = new int[1001][1001];
    }
    
    public void add(int[] point) {
        points[point[0]][point[1]]++;
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int numSquares = 0;

        for(int d=1;d<=1000;d++) {
            // left:
            int left = 0;
            int dx = x - d;
            if(dx >= 0) {
                int upperLeft = points[dx][y];
                int up = y + d;
                if(up <= 1000) {
                    upperLeft *= points[dx][up];
                    upperLeft *= points[x][up];
                }else   upperLeft = 0;

                int lowerLeft = points[dx][y];
                int down = y - d;
                if(down >= 0) {
                    lowerLeft *= points[dx][down];
                    lowerLeft *= points[x][down];
                }else   lowerLeft = 0;

                left = upperLeft + lowerLeft;
            }

            // right:
            int right = 0;
            dx = x + d;
            if(dx <= 1000) {
                int upperRight = points[dx][y];
                int up = y + d;
                if(up <= 1000) {
                    upperRight *= points[dx][up];
                    upperRight *= points[x][up];
                }else   upperRight = 0;

                int lowerRight = points[dx][y];
                int down = y - d;
                if(down >= 0) {
                    lowerRight *= points[dx][down];
                    lowerRight *= points[x][down];
                }else   lowerRight = 0;

                right = upperRight + lowerRight;
            }

            numSquares += (left + right);
        }

        return numSquares;
    }
}
