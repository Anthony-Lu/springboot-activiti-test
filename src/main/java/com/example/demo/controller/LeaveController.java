package com.example.demo.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.LeaveService;
import com.example.demo.service.TestLeaveService;

@RestController
public class LeaveController {

    private static final Logger logger = LoggerFactory.getLogger(LeaveController.class);
    @Autowired
    private LeaveService leaveService;

    /**
     * 发起申请，新增信息
     *
     * @param msg
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/addLeaveInfo")
    public String addLeaveInfo(String msg, HttpServletRequest request, Model model) {
        leaveService.addLeaveAInfo(msg);
        return "新增成功...";
    }

    /**
     * 查询当前用户的任务列表
     *
     * @param userId
     * @param request
     * @return
     */
    @RequestMapping("/getTaskByUserId")
    public Object getTaskByUserId(String userId, HttpServletRequest request) {
        //System.out.println();
        return leaveService.getByUserId(userId);
    }

    /**
     * 处理完成任务
     *
     * @param taskId
     * @param userId
     * @param audit
     * @param request
     * @return
     */
    @RequestMapping("/completeTask")
    public String completeTask(String taskId, String userId, String audit, HttpServletRequest request) {
        leaveService.completeTaskByUser(taskId, userId, audit);
        return "审批完成...";
    }


    @RequestMapping("/showImg")
    public void showImg(String processDefId, HttpServletRequest request, HttpServletResponse response) {

        try {
            InputStream inputStream = TestLeaveService.findProcessPic(processDefId);
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(b, 0, 1024)) != -1) {
                response.getOutputStream().write(b, 0, len);
            }
        } catch (IOException e) {
            logger.error("读取流程图片出错", e);
        }

    }

}
