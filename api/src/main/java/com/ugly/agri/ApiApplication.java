package com.ugly.agri;

import com.ugly.agri.domain.FoodPriceData;
import com.ugly.agri.domain.FoodPriceExcelReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);

        FoodPriceExcelReader excelReader = new FoodPriceExcelReader();

        System.out.println("*****xlsx*****");
        List<FoodPriceData> xlsxList = excelReader.xlsxToExcelDataList();
        printList(xlsxList);
    }

    public static void printList(List<FoodPriceData> list) {
        FoodPriceData vo;

        for (int i = 0; i < list.size(); i++) {
            vo = list.get(i);
            System.out.println(vo.toString());
        }
    }
}