package geektime.algo.mianshi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-03-05 19:01
 * @description:
 */
public class StrSplit {

    public static void main(String[] args) {
        String source = ",dt,  , deg det, alb , , det";
        char splitStr = ',';

        String[] strings = splitStr(source, splitStr);

        for (String s : strings) {
           System.out.println(s);
        }

    }

    public static String[] splitStr(String source, char splitStr) {

        List<String> result = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();

        for (int index = 0; index < source.length(); index++) {
            if (splitStr == source.charAt(index) || index == source.length() - 1) {
                String trim = builder.toString().trim();
                if (trim.length() > 0) {
                    result.add(trim);
                }
                builder = new StringBuilder();
                continue;
            } else {
                builder.append(source.charAt(index));
            }
        }

        return result.toArray(new String[result.size()]);
    }
}