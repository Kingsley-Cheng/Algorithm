package algorithms;

/**
 * @description: TODO
 * @author: kingsleycheng
 * @date: 2026/8/24 17:41
 * @version: 1.0
 */
public class Selection implements Sort{
    @Override
    public void sort(Comparable[] a) {
        int N =a.length;
        for(int i=0; i<N; i++){
            int min=i;
            for(int j=i+1; j<N; j++)
                if(Sort.less(a[j],a[min]))
                    min=j;
            Sort.exch(a,i,min);
        }
    }
}
