import java.util.*;

class Solution {
    class Point {
        Point(int r, int c, int d) {
            row = r;
            col = c;
            dist = d;
        }
        int row, col, dist;
    }
    int[][] dict = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    boolean bfs(String[] place, int row, int col) {
        boolean[][] visited = new boolean[5][5];
        Queue<Point> q = new LinkedList<>();
        
        visited[row][col] = true;
        q.add(new Point(row, col, 0));
        
        while(!q.isEmpty()) {
            Point curr = q.remove();
            
            if(curr.dist > 2) continue;
            if(curr.dist != 0 && place[curr.row].charAt(curr.col) == 'P')
                return false;
            
            for(int i = 0; i < 4; ++i) {
                int nr = curr.row + dict[i][0];
                int nc = curr.col + dict[i][1];
                
                if(nr < 0 || nr > 4 || nc < 0 || nc > 4) continue;
                if(visited[nr][nc]) continue;
                if(place[nr].charAt(nc) == 'X') continue;
                visited[nr][nc] = true;
                q.add(new Point(nr, nc, curr.dist + 1));
            }
        }
        return true;
    }
    
    boolean check(String[] place) {
        for(int r = 0; r < 5; ++r) {
            for(int c = 0; c < 5; ++c) {
                if(place[r].charAt(c) == 'P') {
                    if(bfs(place, r, c) == false) return false;
                }
            }
        }
        return true;
    }
    
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i =0; i < 5; ++i) {
            if(check(places[i]))
                answer[i] = 1;
            else
                answer[i] = 0;
        }
        return answer;
    }
}