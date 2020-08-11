package algorithm.simulationAndHighPrecision.idea;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter(new File("result.txt")));
        String src=null;
        DecimalFormat df = new DecimalFormat("0.00");
        for(double d=0.3;d<=0.71;d+=0.01){
            src=df.format(d);
            bw.write(src+System.lineSeparator());
            // 获取MD2加密工具
            MessageDigest md = MessageDigest.getInstance("MD2");
            // 加密
            byte[] digest = md.digest(src.getBytes());
            for(int i=0;i<99999999;i++){
                digest = md.digest(digest);
            }
            // 获取二进制十六进制互转工具
            HexBinaryAdapter hexBinaryAdapter = new HexBinaryAdapter();
            // 将二进制数组转换为十六进制字符串
            String marshal = hexBinaryAdapter.marshal(digest);
            marshal=marshal.toLowerCase();
            // 输出结果
            bw.write(marshal+System.lineSeparator());
        }
        bw.close();
    }
}
