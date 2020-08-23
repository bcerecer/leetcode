/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;
        
        int[] dr = { 0, 0, 1, -1};
        int[] dc = {-1, 1, 0, 0};
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sr, sc));
        while (!q.isEmpty()) {
            Point p = q.poll();
            image[p.x][p.y] = newColor;
            for (int i = 0; i < 4; i++) {
                int x = p.x + dr[i];
                int y = p.y + dc[i];
                if (isValid(image, x, y, oldColor))
                    q.add(new Point(x, y));
            }
        }
        return image;
    }
    
    private boolean isValid(int[][] image, int x, int y, int oldColor) {
        return (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == oldColor);
    }
    
    class Point {
        int x;
        int y;
        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

// @lc code=end

