package com.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jason
 */
import com.entity.RecommendationMatrix;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
 
/**
 * KNN又名临近算法
 * 实现步骤：
 * 1. 首先计算出所有的临近距离值
 * 2. 对临近值进行排序
 * 3. 选出临近值最小的K个数
 * 4. 投票选出结果
 */
public class KNN {
    public static List<RecommendationMatrix> matrix;

    public static void loadMatrix(String path){
        matrix = new ArrayList<>();
        try{    
                File directory = new File(".");
                // get the running path to put the comment file
                System.err.println(directory.getCanonicalPath());
                File csv = new File(path);
                BufferedReader br = new BufferedReader(new FileReader(csv));
                String line = ""; 
                while ((line = br.readLine()) != null) { 
                    // 把一行数据分割成多个字段 
                    RecommendationMatrix recommendationMatrix = new RecommendationMatrix();
                    String[] arrays = line.split(",");
                    recommendationMatrix.setReMatrixId(Integer.valueOf(arrays[0]));
                    recommendationMatrix.setUserM(Integer.valueOf(arrays[1]));
                    recommendationMatrix.setISBN(arrays[2]);
                    recommendationMatrix.setRating(Integer.valueOf(arrays[3]));
                    matrix.add(recommendationMatrix);
                } 
            br.close();
        } catch (FileNotFoundException e) { 
            
            e.printStackTrace(); 
        } catch (IOException e) { 
            
            e.printStackTrace(); 
         } 
    } 

    public static List<String> applyKNN(List<RecommendationMatrix> recommendationMatrix,List<RecommendationMatrix> users_preference,int top_num){
        Integer row_cnt=0,col_cnt = 0;
        Map<String,String> column_index = new HashMap<>();  // ISBN->col
        Map<String,String> column_index_reverse = new HashMap<>();  //col->ISBN
        Map<String,String> row_index = new HashMap<>();     //userID->row
        Map<String,String> row_index_reverse = new HashMap<>();  // row->userID
        Map<String,Map<String,String>> row_col_value_index = new HashMap<>(); // row,col->value;
        List<List<Long>> matrix = new ArrayList<>();
        for (RecommendationMatrix re:recommendationMatrix){
            if (!column_index.containsKey(re.getISBN())) {
                column_index.put(re.getISBN(),col_cnt.toString());
                column_index_reverse.put(col_cnt.toString(),re.getISBN());
                col_cnt = col_cnt + 1;
            }
            if (!row_index.containsKey(re.getUserM().toString())){
                row_index.put(re.getUserM().toString(), row_cnt.toString());
                row_index_reverse.put(row_cnt.toString(), re.getUserM().toString());
                row_cnt = row_cnt + 1;
            }
            if ( row_col_value_index.get(row_index.get(re.getUserM().toString())) ==null ){
                row_col_value_index.put(row_index.get(re.getUserM().toString()), new HashMap<>());
                row_col_value_index.get( row_index.get(re.getUserM().toString()) ).put(column_index.get(re.getISBN()), re.getRating().toString());
            }else{
                row_col_value_index.get( row_index.get(re.getUserM().toString()) ).put(column_index.get(re.getISBN()), re.getRating().toString());
            }
        }
        System.err.println(row_cnt);
        System.err.println(col_cnt);
        
        List<Long> target_tuple = new ArrayList<>();
        for (int i = 0 ; i < col_cnt ;i ++ ){
            target_tuple.add(0l);
        }
        for (RecommendationMatrix upMatrix:users_preference){
            if (column_index.containsKey( upMatrix.getISBN() )  ) {
                target_tuple.set( Integer.valueOf( column_index.get( upMatrix.getISBN() ) ) , new Long ( upMatrix.getRating() ) );
            }
        }
        
        Map<String,Double> distanceMap = new HashMap<>();
        List<String> recommendation_distance_index = new ArrayList<>();
        for (int i = 0; i< row_cnt; i++){
            List <Long> set_tuple = new ArrayList<>();
            for (int j = 0 ; j < col_cnt ; j++ ){
                set_tuple.add(0l);
            }
            String row = String.valueOf(i);
            if ( row_col_value_index.containsKey( row ) ) {
                Map<String, String> col_map = row_col_value_index.get(row);
                for (Map.Entry<String,String> entry : col_map.entrySet()){
                    set_tuple.set( Integer.valueOf(entry.getKey()),Long.valueOf(entry.getValue()) );
                }
            }else{
                
            }
            double distance_temp = distance(target_tuple, set_tuple);
            distanceMap.put(row, Double.valueOf( distance_temp ));
            recommendation_distance_index.add(row);
        }
        Collections.sort(recommendation_distance_index, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return distanceMap.get(o2) -distanceMap.get(o1) > 0 ? 1:-1 ;
            }
        } );
        System.err.println( distanceMap.get(recommendation_distance_index.get(0) ) );
        Set<String> IBNSet = new HashSet<>();
        for (int i = 0; i< 10;i++){
            Map<String,String> books = row_col_value_index.get(recommendation_distance_index.get(i));
            for (Map.Entry<String,String> entry : books.entrySet() ){
                if ( Long.valueOf( entry.getValue() ) > 0){
                    IBNSet.add(column_index_reverse.get( entry.getKey() ));
                }
            }
        }
        
        List<String> IBNList = new ArrayList<>(IBNSet);
        return IBNList;
    }
	
        
        public static double distance(List<Long> target_tuple, List<Long> set_tuple){
            double tempDistince = 0;
            double mul_target = 0;
            double mul_set = 0;
            for (int i = 0 ; i< target_tuple.size();i ++){
                mul_target = mul_target + target_tuple.get(i)*target_tuple.get(i);
                mul_set = mul_set+ set_tuple.get(i)*set_tuple.get(i);
                tempDistince = tempDistince + target_tuple.get(i) * set_tuple.get(i);
            }
            
            return tempDistince/Math.sqrt(mul_set * mul_set + 0.001);
        }

}
