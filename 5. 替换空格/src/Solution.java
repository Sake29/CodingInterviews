import org.junit.jupiter.api.Test;

public class Solution {
    public String replaceSpace(String s) {
        if (s == null){return null;};
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                sb.append("%20");
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    @Test
    public void test(){
        String s = "we are happy";
        String res = replaceSpace(s);
        System.out.println(res);
    }
}
