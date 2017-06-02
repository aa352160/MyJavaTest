package com.jh352160.json;

import java.io.*;

/**
 * Created by pcdalao on 2017/2/16.
 */
public class JsonMain {
    public static void main(String[] args) {
        String JsonString=readToString("C:\\Users\\pcdalao\\Desktop\\lang1.json");
        JsonUtil jsonUtil=new JsonUtil();
        String s = jsonUtil.parseJsonToXml(JsonString, "th_TH");
        System.out.print(s);
        writeToString("C:\\Users\\pcdalao\\Desktop\\lang_th_TH1.xml",s);
    }

    public static String readToString(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }

    public static void writeToString(String filePath,String string){
        /* 写入Txt文件 */
        try {
            File writename = new File(filePath); // 相对路径，如果没有则要建立一个新的文件
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write(string); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
