//Дана строка, содержащая текст на русском языке и некоторая буква.
//Найти слово, содержащее наибольшее количество указанных букв. 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        System.out.print("Введите букву");
        char c = in.next().charAt(0);
        StreamTokenizer st = new StreamTokenizer(breader);
        st.ordinaryChar('/');
        String a = "";
        int count = 0;
        int t = 0;
        while(st.ttype != StreamTokenizer.TT_EOF){
            t = 0;
            if (st.ttype == StreamTokenizer.TT_WORD){
                
                String tmp = st.sval;
                for (int i = 0;i<tmp.length();i++){
                    if (tmp.charAt(i) == c){
                        t++;
                    }
                }
                if (t > count){
                    a = st.sval;
                    count = t;
                    
                }
            st.nextToken();
        }

    }

    System.out.println(a);
}
    
}
