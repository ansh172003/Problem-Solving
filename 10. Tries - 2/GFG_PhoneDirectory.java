import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class GFG_PhoneDirectory {
    static ArrayList<ArrayList<String>> displayContacts(int n, String[] contacts, String s){
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for(int i = 1; i <= s.length(); i++){
            String prefix = s.substring(0, i);
            HashSet<String> hashSet = new HashSet<>();
            for(int j = 0; j < n; j++){
                int len = contacts[j].length();
                if(len >= i) {
                    String prefixContact = contacts[j].substring(0, i);
                    if(prefix.equals(prefixContact)) hashSet.add(contacts[j]);
                }
            }
            ArrayList<String> temp;
            if(hashSet.size() == 0){
                temp = new ArrayList<>();
                temp.add("0");
            }else{
                temp = new ArrayList<>(hashSet);
                Collections.sort(temp);
            }
            res.add(temp);
        }
        return res;
    }
}
