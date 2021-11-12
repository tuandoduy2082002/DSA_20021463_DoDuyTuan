package Week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class JavaMap {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        while (n-- > 0) {
            String hello = br.readLine();
            int phone = Integer.valueOf(br.readLine());
            map.put(hello, phone);
        }

        String str;
        while ((str = br.readLine()) != null) {
            if (map.containsKey(str)) {
                System.out.println(str + "=" + map.get(str));
            } else {
                System.out.println("Not found");
            }
        }

        br.close();

    }
}
