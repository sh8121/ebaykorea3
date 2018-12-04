import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IOTest {
    public static void main(String[] args){
        // 키보드로부터 한줄씩 입력, 파일에 한줄씩 쓴다.
        BufferedReader br = null;
        PrintWriter pw = null;
        try{
            br = new BufferedReader(new InputStreamReader(System.in ));
            pw = new PrintWriter(new FileWriter("/tmp/keyboard"));
            String line = null;
            while((line = br.readLine()) != null){
                if("quit".equals(line))
                    break;
                pw.println(line);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            pw.close();
        }
    }
}
