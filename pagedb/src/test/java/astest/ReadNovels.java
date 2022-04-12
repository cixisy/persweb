package astest;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: readnovels
 * @description: 解析小说文件
 * @author: AS
 * @create: 2022-04-02 17:10
 */
public class ReadNovels {

    public static void novelFormat(String filepath,String filepath1){
        String encoding = "gbk";//txt一般默认编码为gbk
        File file = new File(filepath);
        File file2 = new File(filepath1);
        String expression = ".+?章\\s";
        Pattern p = Pattern.compile(expression); // 正则表达式
        int i = 0;
        if(file.exists() && file.isFile()){
            try {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
                OutputStreamWriter w1 = new OutputStreamWriter(new FileOutputStream(file2),encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                BufferedWriter writer = new BufferedWriter(w1);

                String txtLine = "";
                while((txtLine = bufferedReader.readLine()) != null){
                    if(p.matcher(txtLine).find()){
                        i+=1;
                        if(i>10000){
                            break;
                        }
                    }
                    System.out.println(txtLine);
                    if (!txtLine.isEmpty()){
                        writer.write(txtLine+"\n");
                    }

                }
                read.close();
                writer.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    @Test
    public void test(){
        String filepath = ".\\src\\test\\testfile\\novel.txt";
        String filepath1 = ".\\src\\test\\testfile\\novel1.txt";
        novelFormat(filepath,filepath1);

    }
    @Test
    public void test1(){
        String s1 = "第四百五十章 盛世文章";
        String s2 = "第四百四十九章 诗心";
        System.out.println(Pattern.matches("第.+?章",s1));

        boolean str = s2.matches("第.+?章");
        System.out.println(str);

        String expression = "第.+?章";
        Pattern p = Pattern.compile(expression); // 正则表达式
        Matcher m = p.matcher(s2); // 操作的字符串
        boolean b = m.find (); //返回是否匹配的结果
        System.out.println(b);
    }

}
