package study.review;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by EricWang on 2019/5/29 12:55 AM.
 */
public class BuildTddlTopology {


    public static void main(String[] args) {
        Map<String, List<String>> topology = new LinkedHashMap<>();

        for (int i= 0; i < 16; i ++){
            String groupkey = "";
            if (i < 10){
                groupkey = "LAZADA_EVALUATION_" + "SG" + "_000" + i + "_GROUP";
            }else {
                groupkey = "LAZADA_EVALUATION_" + "SG"+ "_00" + i + "_GROUP";
            }


            List<String> tableNames = new ArrayList<>();

            for (int j = 0; j < 64; j++){

                int tableIndex = i * 64 + j;

                String tableName = "";

                if (tableIndex < 10){
                    tableName = "review_statistics_000" + tableIndex;
                }else if (tableIndex < 100){
                    tableName = "review_statistics_00" + tableIndex;
                }else if (tableIndex < 1000){
                    tableName = "review_statistics_0" + tableIndex;
                }else {
                    tableName = "review_statistics_" + tableIndex;
                }

                tableNames.add(tableName);
            }

            topology.put(groupkey,tableNames);

        }

        for (String key : topology.keySet()){
            System.out.println(key);
            System.out.println(topology.get(key));
            System.out.println("===================================================================");
        }



    }
}
