package com.bxbro.summer.web.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bxbro.summer.web.util.HttpUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 身份证OCR识别
 * @Author dong
 * @Date 2020/12/15
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class IdCardOcr {

    /**
     * 身份证识别接口url: http(s)://dm-51.data.aliyun.com/rest/160601/ocr/ocr_idcard.json
     * 接口文档：https://market.aliyun.com/products/57124001/cmapi010401.html?spm=5176.2020520132.101.2.56f87218zgEQU1#sku=yuncode440100000
     */
    @Test
    public void AliyunTest() {
        String host = "http://dm-51.data.aliyun.com";
        String path = "/rest/160601/ocr/ocr_idcard.json";
        String appcode = "6b0a6c34244e48fd8fa8d776b38d1b2e";
        String imgFile = "E:\\workImges\\1.jpg";// 身份证正面
        String method = "POST";

        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");

        Map<String, String> querys = new HashMap<String, String>();
        // 对图像进行base64编码
        String imgBase64 = img_base64(imgFile);

        //configure配置
        JSONObject configObj = new JSONObject();
        configObj.put("side", "face");

        String config_str = configObj.toString();

        // 拼装请求body的json字符串
        JSONObject requestObj = new JSONObject();
        requestObj.put("image", imgBase64);
        if(configObj.size() > 0) {
            requestObj.put("configure", config_str);
        }
        String bodys = requestObj.toString();

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            int stat = response.getStatusLine().getStatusCode();
            if(stat != 200){
                System.out.println("Http code: " + stat);
                System.out.println("http header error msg: "+ response.getFirstHeader("X-Ca-Error-Message"));
                System.out.println("Http body error msg:" + EntityUtils.toString(response.getEntity()));
                return;
            }

            String res = EntityUtils.toString(response.getEntity());
            JSONObject res_obj = JSON.parseObject(res);

            System.out.println(res_obj.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String img_base64(String path) {
        /**
         *  对path进行判断，如果是本地文件就二进制读取并base64编码，如果是url,则返回
         */
        String imgBase64="";
        if (path.startsWith("http")){
            imgBase64 = path;
        }else {
            try {
                File file = new File(path);
                byte[] content = new byte[(int) file.length()];
                FileInputStream finputstream = new FileInputStream(file);
                finputstream.read(content);
                finputstream.close();
                imgBase64 = new String(Base64.encodeBase64(content));
            } catch (IOException e) {
                e.printStackTrace();
                return imgBase64;
            }
        }

        return imgBase64;
    }

}
