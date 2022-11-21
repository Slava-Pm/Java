//Дана строка. Напечатать в алфавитном порядке все слова из данной
//строки, имеющие заданную длину n.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
        int n = 5;
        StreamTokenizer st = new StreamTokenizer(breader);
        st.ordinaryChar('/');
        String a = "";
        String[] array = {};
        int count = 0;
        while(st.ttype != StreamTokenizer.TT_EOF){
            if (st.ttype == StreamTokenizer.TT_WORD){
                if (st.sval.length() == n){
                    a = a.concat(st.sval);
                    a = a.concat(" ");
                }
            }
            st.nextToken();
        }
        String[] out = a.split(" ");
        Arrays.sort(out);
        for (int i = 0;i<out.length;i++) {
            System.out.println(out[i]);
        }

    }


}
//Дана строка, содержащая текст. Найти слово, встречающееся в
//каждом предложении, или сообщить, что такого слова нет.
