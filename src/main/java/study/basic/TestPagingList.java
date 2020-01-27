package study.basic;//package com.wy.study.basic;
//
//import com.google.common.collect.Lists;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * Created by EricWang on 2019/4/2 5:56 PM.
// */
//public class TestPagingList {
//
//    public static void main(String[] args) {
//        ArrayList<Integer> ids = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        long pageSize = 100000000L;
//
//            Long total = Long.valueOf(ids.size());
//            long pages = total/pageSize;
//
//            for(long i = 0; i<= pages; i++){
//                List<Integer> batchIds = ids.stream().skip(i * pageSize).limit(pageSize)
//                        .collect(Collectors.toList());
//
//                System.out.println(batchIds);
//
//        }
//    }
//}
