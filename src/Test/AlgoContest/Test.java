package Test.AlgoContest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {
    static int N,H,map[][];
    static boolean[][]v;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //맵 사이즈
            H = Integer.parseInt(st.nextToken()); //남은 체력
            map = new int[N][N];	//맵
            v=new boolean[N][N];
            max = Integer.MIN_VALUE;
            for(int i = 0 ; i < N ; i ++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            /* ----end of input------- */
            //체력을 최대한 아끼고 탈출하는 경우의 체력
            //solution(0,0);
            dfs(0,0,H);
            System.out.print("#" + test_case + " ");
            System.out.println(max>=0 ? "true ending": "bad ending");
        }
    }
    public static class Pos{
        int x, y, h;
        public Pos(int x, int y ,int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    //사방 돌릴 배열
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int max=Integer.MIN_VALUE;
    public static void solution(int i, int j) {
        Queue<Pos> q = new LinkedList<>();
        boolean[][]v=new boolean[N][N];
        v[i][j]=true;
        q.offer(new Pos(i,j,H));
        while(!q.isEmpty()) {
            Pos node = q.poll();
            if(node.x==N-1 && node.y ==N-1) {
                max = node.h;
                return;
            }
            //체력 고갈
            if(node.h<=0)continue;
            for(int d = 0 ; d<4 ; d++) {
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];

                if(nx<0||ny<0||nx>=N||ny>=N)continue;//맵 범위
                if(map[nx][ny]==1)continue;//벽
                //else
                if(!v[nx][ny]) {
                    v[nx][ny]=true;
                    if(map[nx][ny]==0) {
                        q.offer(new Pos(nx,ny,node.h-1));
                    }else if(map[nx][ny]==2) {
                        q.offer(new Pos(nx,ny,node.h+1));
                    }
                }


            }
        }

    }
    static void dfs(int x,int y,int h) {
        if(x==N-1&&y==N-1) {
            max=1;
            return;
        }
        if(h==0)return;
        for(int d=0; d<4; d++) {
            int nx=x+dx[d];
            int ny=y+dy[d];
            if(nx<0||ny<0||nx>=N||ny>=N)continue;
            if(!v[nx][ny]) {
                if(map[nx][ny]==0) {
                    v[nx][ny]=true;
                    dfs(nx,ny,h-1);
                    v[nx][ny]=false;
                }
                if(map[nx][ny]==2) {
                    v[nx][ny]=true;
                    dfs(nx,ny,h+1);
                    v[nx][ny]=false;
                }

            }
        }


    }
}