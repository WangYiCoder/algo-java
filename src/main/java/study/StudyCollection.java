package study;//package com.wy.study;
//
//import com.google.common.base.Objects;
//import com.google.common.collect.Lists;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * Created by EricWang on 2019/1/3 10:21 AM.
// */
//public class StudyCollection {
//
//    public static void main(String[] args) {
//
//        List<Long> itemIds = Lists.newArrayList(1l,2l,3l);
//
//
//        List<Long> qualifiedIdList = itemIds.stream().filter(id -> Objects.equal(4l, id)).collect(Collectors.toList());
//
//        System.out.println(qualifiedIdList);
//    }
//}
