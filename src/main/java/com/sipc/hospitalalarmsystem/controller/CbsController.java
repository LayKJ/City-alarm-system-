package com.sipc.hospitalalarmsystem.controller;

import com.plexpt.chatgpt.entity.chat.Message;
import com.sipc.hospitalalarmsystem.model.dto.CommonResult;
import com.sipc.hospitalalarmsystem.model.dto.param.gpt.ChatParam;
import com.sipc.hospitalalarmsystem.model.dto.res.BlankRes;
import com.sipc.hospitalalarmsystem.service.CbsService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * &#064;date 2023-09-13 20:59
 */

@Validated
@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/api/v1/cbs")

public class CbsController {
    //与gpt共用
    @Autowired
    CbsService cbsService;

    @PostMapping()
    public CommonResult<BlankRes> chat(@Valid  @RequestBody ChatParam param) {


        log.info("正在提问: " + param.getMessage());
        Message message = cbsService.getText(param);
        //text  content为答案
        String text = message.getContent();
        //log.info("答案是"+text);
       //  log.info("问题：" + param.getMessage() + "\n回答：" + text);

        return CommonResult.success(text);
    }

}
