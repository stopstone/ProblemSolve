import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int max=0;
        int idx=0;
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++) {
            list.add(Integer.parseInt(st.nextToken()));
            if(max<list.get(i)) {
                max=list.get(i);
                idx=i;
            }
        }

        int result=0;
        for(int i=idx+1;i<=n-1;i++) {
            result+=max+list.get(i);
        }

        for(int i=idx-1;i>=0;i--) {
            result+=max+list.get(i);
        }

        System.out.println(result);

    }

}