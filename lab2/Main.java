//Входная строка может содержать определенное количество слов и чисел.
//Вывести на экран все слова начинающиеся и заканчивающиеся одной буквой.

import java.io.*;


public class Main{
    public static void main(String s[])  {
        try {
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            StreamTokenizer st = new StreamTokenizer(b);
            st.ordinaryChar('/');


            for(int token = st.nextToken();st.ttype != StreamTokenizer.TT_EOF; token = st.nextToken()){
                if (st.ttype == StreamTokenizer.TT_WORD){
                    if (st.sval.charAt(0) == st.sval.charAt(st.sval.length()-1)){
                        System.out.println(st.sval);
                    }
                }
            }

        }catch(Exception e){
            System.out.println("Error "+e.toString());
        }

    }
}
