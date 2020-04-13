package com.soft1851.springboot.aop.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author ：wanghuanle
 * @date ：2020/4/7
 * @description：TODO
 */
@Data
@Builder
public class User {
    private String userId;
    private String emailFlag;
    private String phoneNumber;
    private String phoneNumberFlag;
    private String fullName;
    private String studentNo;
    private String avatarUrl;
    private Timestamp joinTime;
    private String clazzCourseId;
    private Integer score;
    private String roles;
    private Integer ranking;
}
