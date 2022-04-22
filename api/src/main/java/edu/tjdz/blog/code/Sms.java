package edu.tjdz.blog.code;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import com.tencentcloudapi.sms.v20190711.models.SendStatus;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class Sms  {

    @Resource(name = "getRedisTemplate")
private RedisTemplate redisTemplate;


public int sendSms(String phone){

    Object o = redisTemplate.opsForValue().get(phone);
    /*确保验证码过期*/
    if (o == null){
        /*生成验证码*/
        String str="0123456789";
        StringBuffer code = new StringBuffer();
        String[] codeArr =new String[1];
        for(int i = 0; i<6; i++){
          code.append(str.charAt(new Random().nextInt(str.length())));
        }
        String codeStr = code.toString();
        codeArr[0] = codeStr;
        String[] phoneNum = {"+86"+phone};

        Credential credential = new Credential("AKID1qQjkUyB7mAH7gy0lFRM1OUJr87pHSMz", "NUKtBCwPcZFelbBUWHlxsWtzoMdeOr30");
        SmsClient smsClient = new SmsClient(credential, "ap-guangzhou");
        SendSmsRequest req = new SendSmsRequest();
        req.setSmsSdkAppid("1400591056");
        req.setSign("后端技术博客公众号");
        req.setTemplateID("1183912");

        req.setTemplateParamSet(codeArr);
        req.setPhoneNumberSet(phoneNum);

        try {
            SendSmsResponse reps = smsClient.SendSms(req);
            SendStatus[] sendStatusSet = reps.getSendStatusSet();
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(sendStatusSet[0]);
            Map map = objectMapper.readValue(s, Map.class);
            System.out.println(map);
            if(map.get("code") != null&&"Ok".equalsIgnoreCase((String) map.get("code"))){
                ValueOperations value = redisTemplate.opsForValue();
                value.set(phone,codeStr,60, TimeUnit.SECONDS);
                return 1;
            }
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
            return 0;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return 0;
        }

    }

    return 0;





}





}
