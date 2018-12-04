package examples.boot.springboard;

import org.junit.Test;

import java.io.*;

public class JavaIOTest {
    @Test
    public void copy(){
        InputStream in = null;
        OutputStream out = null;
        try{
            in = new FileInputStream("/DEVEL/ebaykorea3/springboard/src/test/java/examples/boot/springboard/JavaIOTest.java");
            out = new FileOutputStream("/tmp/iofile");

            byte[] buffer = new byte[1024];
            int readCount = 0;

            // 2000 byte
            while((readCount = in.read(buffer)) != -1){
                // buffer배열의 0번째부터 readCount까지 써라.
                out.write(buffer,0, readCount);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } // finally
    } // copy method

    @Test
    public void copy2(){
        // 키보드로부터 한줄씩 입력받아, 파일에 한줄씩 저장하고
        // quit를 입력하면 프로그램은 종료된다.

        BufferedReader br = null;
        try{
            br = new BufferedReader(new InputStreamReader(System.in ));
            String line = null;
            while((line = br.readLine()) != null){
                if("quit".equals(line))
                    break;
                System.out.println(line);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {

        }

    }
}
