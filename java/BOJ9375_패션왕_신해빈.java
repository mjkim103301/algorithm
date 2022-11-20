package baekjoon.silver;
import java.util.*;
import java.io.*;
public class BOJ9375_패션왕_신해빈 {
    static int N,cnt;
    static Map<String, List<String>> clothes=new HashMap<>();
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());
        for(int i=1;i<=T;i++){
            N=Integer.parseInt(br.readLine());
            clothes=new HashMap<>();
            for(int j=0;j<N;j++){
                st=new StringTokenizer(br.readLine());
                String name=st.nextToken();
                String type=st.nextToken();
                if(!clothes.containsKey(type)){
                    clothes.put(type, new ArrayList<>());
                }
                clothes.get(type).add(name);
            }
            solution();
        }
        System.out.println(sb);
    }

    static void solution(){
        cnt=1;
        for(Map.Entry<String, List<String>> entry:clothes.entrySet()){
            cnt*=(entry.getValue().size()+1);
        }
        sb.append(cnt-1+"\n");
    }
}
