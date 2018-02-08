package HomeWork1;

import java.io.*;
import java.util.ArrayList;

public class ReadFromFile {
    public static void read() throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader(
                new File("C:\\Users\\Nightbringer\\IdeaProjects\\HomeWork\\src\\HomeWork1\\FileTxt\\1.txt")));
        ArrayList<String> list=new ArrayList<>();
        String S=null;
       while((S=reader.readLine())!=null){
           for(String a:S.split(";")){
               System.out.println(a);
           }
        }
    }

    public static void main(String[] args) throws IOException {
        read();
    }
}
