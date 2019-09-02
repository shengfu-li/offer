package algorithm_note;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
    static int MAX=1000;
    int [][]graph;
    int dis[]=new int [MAX];
    boolean visit[];
    public static void main(String[] args) {
        Dijkstra dij=new Dijkstra();
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();//表示几个节点
        dij.visit=new boolean[n];

    }
    void dijkstra(int start,int n){
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[start]=0;
        for(int i=0;i<n;i++){
            int min=Integer.MAX_VALUE;
            int u=-1;
            for(int j=0;j<n;j++){
                if(visit[j]==false && dis[j]<min){
                    u=j;
                    min=dis[j];
                }
            }
            if(u==-1) return;//说明没有与start节点相连的节点
            visit[u]=true;
            for(int j=0;j<n;j++){
                if(visit[j]==false && graph[u][j]!=Integer.MAX_VALUE &&dis[u]+graph[u][j]<dis[j]){//
                    dis[j]=dis[u]+graph[u][j];
                }
            }
        }

    }
}
