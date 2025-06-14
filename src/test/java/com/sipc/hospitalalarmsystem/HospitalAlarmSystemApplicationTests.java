package com.sipc.hospitalalarmsystem;

import com.alibaba.excel.EasyExcel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qcloud.cos.http.HttpMethodName;
import com.sipc.hospitalalarmsystem.config.OssConfig;
import com.sipc.hospitalalarmsystem.model.dto.res.Alarm.GetAlarmRes;
import com.sipc.hospitalalarmsystem.model.dto.res.FlaskResponse.updateMonitorAreaRes;
import com.sipc.hospitalalarmsystem.model.po.Alarm.SqlGetAlarm;
import com.sipc.hospitalalarmsystem.service.AlarmService;
import com.sipc.hospitalalarmsystem.service.RecordService;
import com.plexpt.chatgpt.ChatGPT;


import com.sipc.hospitalalarmsystem.util.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.util.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HospitalAlarmSystemApplicationTests {
    @Autowired
    private JwtUtils jwtUtils;
//    @Autowired
//    private OssConfig ossConfig;
//    @Autowired
//    private RecordService recordService;
//    @Autowired
//    AlarmService alarmService;
//    @Autowired
//    private OssUtil ossUtil;
//
//    @Test
//    void contextLoads() throws InterruptedException {
//        System.out.println(ossUtil.getClipLinkByUuid("51987bdb-1ab0-4e61-8fc1-9257de192a7b"));
//    }
//
//    @Test
//    void test1() {
////        Proxy proxy = Proxys.http("127.0.0.1", 1081);
//        //socks5 代理
//        // Proxy proxy = Proxys.socks5("127.0.0.1", 1080);
//
//        ChatGPT chatGPT = ChatGPT.builder()
//                .apiKey("")
//                .apiHost("https://api.openai.com/") //反向代理地址
//                .build()
//                .init();
//
//        String res = chatGPT.chat("写一段七言绝句诗，题目是：火锅！");
//        System.out.println(res);
//
//    }
//
//    @Test
//    void test2() {
//        String token = "sipc115";
//        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(15000)
//                .setConnectionRequestTimeout(15000)
//                .setSocketTimeout(15000)
//                .setRedirectsEnabled(true)
//                .build();
//        String url = "http://192.168.**.**:8000/api/v1/monitor-device/image";
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet get = new HttpGet(url);
//        get.setConfig(requestConfig);
//        get.setHeader("Authorization", token);
//        try (CloseableHttpResponse response = httpClient.execute(get)) {
//            if (response.getStatusLine().getStatusCode() != 200) {
//                throw new RuntimeException("Failed to download file from " + url + ". Status: " + response.getStatusLine());
//            }
//
//            String res = Base64Util.inputStream2Base64(response.getEntity().getContent());
//            System.out.println(res);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to download file from " + url, e);
//        }
//
//    }
//
//    @Test
//   void test3() throws Exception {
//  String token=jwtUtils.signMonitor(1);
//        System.out.println(token);
// }

//
//    @Test
//    void test4() throws Exception {
//        System.out.println(MD5Util.MD5Encode("123456"));
//    }
//
//    @Test
//    void test5() throws Exception {
//        //从本地读图片转IS
//        FileInputStream fis = new FileInputStream(("test.jpg"));
//        int data = fis.read();
//        while (data != -1) {
//            // 处理读取的数据
//            System.out.print((char) data);
//            data = fis.read();
//        }
//        System.out.println(Base64Util.inputStream2Base64(fis));
//        fis.close();
//    }
//
//    @Test
//    void Te() {
//        System.out.println(ossConfig.cosClient().generatePresignedUrl("hospital-alarm-1318141347",
//                "fake.mp4",
//                new Date(System.currentTimeMillis() + (long) 365 * 24 * 60 * 60 * 1000),
//                HttpMethodName.GET).toString());
//    }

}
