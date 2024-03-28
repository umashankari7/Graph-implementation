import java.util.*;
import java.util.List;;
public class Graph {
    static int v;
    static int[][]graphUndirected;
   int graphh[][];
   Graph(){

   }
   Graph(int v){
    this.v=v;
    this.graphh=new int[v][v];
   }
   void addEdge(int i,int j,int weight){
    graphh[i][j]=weight;
    graphh[j][i]=weight;
   }
   void removeEdge(int i,int j){
    graphh[i][j]=0;
    graphh[j][i]=0;
   }
   void display(){
    for(int i=0;i<v;i++){
      for(int j=0;j<v;j++){
        System.out.print(graphh[i][j]+" ");
      }
      System.out.println(" ");
    }
   }
   void printneighbours(int i){
    System.out.println(i+"->");
    for(int j=0;j<v;j++){
    if(graphh[i][j]!=0){
      System.out.println(j+" ");
    }
    }
    System.out.println("");
  }

  int[][] addvertex(){
    int arr[][]=new int[v+1][v+1];
    for(int i=0;i<v;i++){
      for(int j=0;j<v;j++){
        arr[i][j]=graphh[i][j];
      }
    }
    v=v+1;
     return arr;
  }
  List<int[]> prim(){
  boolean[]visited=new boolean[v];
  int[]minweight=new int[v];
  int[]parent=new int[v];
  Arrays.fill(minweight,Integer.MAX_VALUE);
  Arrays.fill(parent,-1);
  List<int[]>mst=new ArrayList<>();
  minweight[0]=0;
  int n=v-1;
  while(n-->0){
    int i=mindis(minweight, visited);
    visited[i]=true;
    for(int j=0;j<v;j++){
      if(graphh[i][j]!=0&&!visited[j]&&graphh[i][j]<minweight[j]){
        parent[j]=i;
        minweight[j]=graphh[i][j];
      }
    }
  }
     for(int i=1;i<v;i++){
      mst.add(new int[]{parent[i],i});
     }
    return mst;
  }
  void traversalBfs(int start,boolean visited[]){
    Queue<Integer>q=new LinkedList<>();
    q.add(start);
    while(!q.isEmpty()){
      int n=q.remove();
      if(!visited[n]){
     visited[n]=true;
     System.out.print(n+" ");
     for(int i=0;i<v;i++){
      //if(graphh)
     }
      }
    }
  }
  int islandCount(){           //island prblm
    int count=0;
    for(int i=0;i<v;i++){
        for(int j=0;j<v;j++){
            if(graphUndirected[i][j]==1){
                count++;
                islandChange(i,j);
            }
        }
    }return count;
}
 void islandChange(int i, int j) {
    if(i<0 || i>=v ||j<0 || j>=v || graphUndirected[i][j]==0){
        return;
    }
    graphUndirected[i][j]=0;
    islandChange(i+1, j);
    islandChange(i-1, j);
    islandChange(i, j+1);
    islandChange(i, j-1);
    islandChange(i+1, j+1);
    islandChange(i+1, j-1);
    islandChange(i-1, j-1);
    islandChange(i-1, j-1);
}
  int []dtra(int source){
    int dist[]=new int[v];
    boolean visited[]=new boolean[v];
    Arrays.fill(dist,Integer.MAX_VALUE);
    dist[source]=0;
    int n=v-1;
    while(n-->0){
     int j=mindis(dist,visited);
     visited[j]=true;
     for(int i=0;i<v;i++){
      if(!visited[i]&&graphh[j][i]!=0&&dist[j]!=Integer.MAX_VALUE&&dist[j]+graphh[j][i]<dist[i]){
        dist[i]=dist[j]+graphh[j][i];
      }
     }
    }
    return dist;
  }
  int []bell(int source){
    int dist[]=new int[v];
    Arrays.fill(dist,Integer.MAX_VALUE);
    dist[source]=0;
    int n=v-1;
    while(n-->0){
     for(int i=0;i<v;i++){
      for(int j=0;j<v;j++){
        if(graphh[i][j]!=0&&dist[i]!=Integer.MAX_VALUE&&dist[i]+graphh[i][j]<dist[j]){
          dist[i]=dist[i]+graphh[i][j];
      }
      }
     }
    }
     for(int i=0;i<v;i++){
      for(int j=0;j<v;j++){
        if(graphh[i][j]!=0&&dist[i]!=Integer.MAX_VALUE&&dist[i]+graphh[j][i]<dist[i]){
          return null;
    }
  }
}
    return dist;
}
  int mindis(int[]dist,boolean[] visited){
    int min=Integer.MAX_VALUE,minindex=-1;
    for(int i=0;i<dist.length;i++){
      if(!visited[i]&&dist[i]<=min){
        min=dist[i];
        minindex=i;
      }
    }
     return minindex;
  }
  public static void main(String[] args) {
    Graph g=new Graph(4);
   // g.addEdge(1, 2,5);
   // g.addEdge(3, 2,4); 
    //g.addEdge(0, 2,10);
    //g.display();
    v=3;
    graphUndirected=new int[][]{
    {1,0,0},
    {0,1,0},
    {0,0,1}
    };
    Graph islandcount=new Graph();
    int count=islandcount.islandCount();
    System.out.println("no of islands"+count);
   // g.removeEdge(1, 2);
   // g.printneighbours(2);
   // System.out.println(" ");
   // System.out.println(Arrays.toString(g.dtra(1)));
   // for(int[] arr:g.prim()){
     // System.out.println(Arrays.toString(arr));
    //}
    //System.out.println(Arrays.toString(g.bell(0)));
  }
}

