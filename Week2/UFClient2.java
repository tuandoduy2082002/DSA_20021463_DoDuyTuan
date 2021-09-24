import edu.princeton.cs.algs4.*;

public class UFClient2 {
    public static boolean connectedAll(UF uf, int N) {
        for (int i =0 ;i<N-1;i++) {
            if(!uf.connected(i,i+1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        int count = 0;
        UF uf = new UF(N);
        while (!StdIn.isEmpty())  {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            count++;
            if (!uf.connected(p,q)) {
                uf.union(p, q);
            }
            if (connectedAll(uf,N)) {
                StdOut.println(count);
                return;
            }
        }
        StdOut.println("FAILED");
    }
}