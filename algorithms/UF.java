package algorithms;
import utils.Stopwatch;

import java.io.*;
import java.io.DataInputStream.*;

/**
 * @description: union-find 问题
 * @author: kingsleycheng
 * @date: 2026/8/20 17:49
 * @version: 1.0
 */
public class UF {
    private final int[] id; // 分量id
    private int count; // 分量数量
    private final int method; // 0:quick-find, 1:quick-union, 2:weighted-quick-union
    private int[] sz; // 各个根结点所对应的分量大小
    public UF(int N, int m){
        count = N;
        id = new int[N];
        for (int i=0; i<N; i++){
            id[i] = i;
        }
        sz = new int[N];
        for(int i=0;i<N;i++)
            sz[i]=1;
        method = m;
    }
    // 返回连同分量的数量
    public int count(){
        return count;
    }
    // p，q是否为同一分量
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    // p所在分量的标识
    private int find(int p){
        // quick-find
        if (method == 0)
            return id[p];
        // quick-union/weighted quick-union
        else {
            while (p != id[p]) p = id[p];
            return p;
        }
    };

    // p,q 之间添加一条连接
    public void union(int p,int q){
        // quick-find
        if (method==0){
            int pID = find(p);
            int qID = find(q);
            if (pID==qID) return;
            for (int i=0; i<id.length; i++){
                if (id[i]==pID){
                    id[i]=qID;
                }
            }
            count--;
        }
        // quick-union
        else if (method == 1){
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;
            id[pRoot] =qRoot;
            count --;
        }
        // weighted quick-union
        else{
            int i = find(p);
            int j = find(q);
            if(i==j) return;
            if(sz[i]<sz[j]){
                id[i]=j;
                sz[j]+=sz[i];
            }else{
                id[j]=i;
                sz[i] += sz[j];
            }
            count--;
        }
    };

    public static void main(String[] args) throws IOException {
        String fileName = "./data/largeUF.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            int N = Integer.parseInt(br.readLine());
            Stopwatch timer = new Stopwatch();
            UF uf = new UF(N,2);
            String line;
            while ((line= br.readLine())!=null){
                int p = Integer.parseInt(line.split(" ")[0]);
                int q = Integer.parseInt(line.split(" ")[1]);
                if (uf.connected(p,q)) continue;
                uf.union(p,q);
            }
            System.out.println(uf.count() + "components; Times: "+timer.elapsedTime());

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
