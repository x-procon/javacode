package com.hazer;


import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;



import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-06-23 10:16
 */
public class TestMain {
    public static void main(String[] args) throws Exception {
        String rsaKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIKgYudpaDtJpYfkHht0/2GJDfnVRysOOv3aEh1gsPrBKSA50UiXY77qs6RsmMwVeKqlLWXT8SLrMnfboed1X2mu1pKBvb881ag02hmQRqJeXBrdTh8m7fh3I4a55idKIGaeRkOkygwYfI0VUetcA/vYuhxR3mhuVB4vbpHBCVY7AgMBAAECgYAinxPXtc5UeG6RF9sK9/WACm1T3D1iogDsq1HFy4zcyTl3OxvHG6jqPxah686LuN0kjWb86DGvSZs0vVeqGyfQX9rIXohxA7tgTxuDaYKdI1kWXHZL40EX+33z2JBD5vgoIVjE+IWWFcIHwSbCv5HJb74coCiZ/vkoNBSDCUkMcQJBAMFOM+MBLlKQrOCRUnws5IFNQX0+1G7omlM/3qTHFKV1C+fT9sDsaB8epFcJJt0rW38nehUgwM4GCt+7jkX1JZUCQQCs/hB9LkqkOnzXEoixJhywT1jdtOm4Nnx2ZNSkjOxlAAXjRDHuDmofRXsLl600Wii2myWbuWhviNVdITzfrfiPAkBxMgMuVh2zGacyZcbgkkVI9l14IxewzqK4RzlwUmfjr9PF8JiZRpZ+Sqo/kUthzibpIcvanXBp9J3ff+wDSVe1AkA/4vgd8tmX+w2ds/eNTKDtr/AGuMhTwrOGWch6GJ0406BZBRdXbjVc5SEC7/oESoOcpIFoGDnsbuE1KpA7nxkbAkA+k+6zo1tX/0JfjomEB/vPxsov3rc6AFVjjGPbDZepOBDDdyirM9buGyVuJoWa5++XNN+oM2pC8iwAWHo68zKI";
        String appId = "fd00658c-994c-49e4-994c-59072c982417";
        String version = "v1.0";
        String timeStamp = String.valueOf(System.currentTimeMillis());
        System.out.println(timeStamp);
        String sign = version+appId+timeStamp;
        String signMd5 = DigestUtils.md5Hex(sign);
        System.out.println("MD5:"+signMd5);
        String sign2 = RSAUtil.encryptByPrivateKey(signMd5, rsaKey);
        System.out.println("生成的签名是："+sign2);
    }

    @org.junit.Test
    public void testR(){
         String path = "166.3.100.162/wsxtshare/reviewTest/test//XY1000660048/0/20181030/idcard_back.png";
         String pathWhiteList = "166.3.100.162,/home/AnyChatCloud/html/AnyChatFaceX/";
        //路径白名单校验

        String[] pathArray = pathWhiteList.split(",");
        boolean flag = false;
        for(String pathWhite:pathArray){
            if(path.contains(pathWhite)){
                flag = true;
            }
        }
        if(!flag){
            System.out.println("路径非法");
        }

    }

    @org.junit.Test
    public void testD(){
        AtomicInteger index = new AtomicInteger(0);
        System.out.println("原始值："+index);
        int j;
        for(int i=0;i<18;i++){
            new Thread(()-> {

            },"线程--"+i).start();
            j=    index.getAndIncrement() % 1;
            System.out.println(Thread.currentThread().getName()+":执行后的值："+j);


        }
    }

    @Test
    public void testSplit(){
        String className = "com.bairuitech.anychat.facex.controller.admin.AdminAppConfigController";
        String a [] = className.split("\\.");
        System.out.println(a);
    }
}
