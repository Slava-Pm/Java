//Дана строка, содержащая текст. Собрать статистику: Сколько слов в
//тексте? Сколько цифр в тексте? Сколько чисел в тексте?
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    public static int function2(double number){
        int col = 0;
        int num = (int) number;
        while (num>0){
            num = num / 10;
            col++;
        }
        return col;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(breader);
        st.ordinaryChar('/');
        String a = "";
        int count_num = 0;
        int count_word = 0;
        int count_digit = 0;
        while(st.ttype != StreamTokenizer.TT_EOF){
            if (st.ttype == StreamTokenizer.TT_WORD){
                count_word++;
            }
            if (st.ttype == StreamTokenizer.TT_NUMBER){
                count_num++;
            }
            if (st.ttype == StreamTokenizer.TT_NUMBER){
                count_digit = count_digit + function2(st.nval);
            }
            st.nextToken();
        }
    

    System.out.println(count_digit);
    System.out.println(count_num);
    System.out.println(count_word);
    }
    
}
