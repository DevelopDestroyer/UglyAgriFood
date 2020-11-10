package com.ugly.agri.domain;

import com.google.common.collect.Lists;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.List;

public class FoodPriceExcelReader {

    @SuppressWarnings("resource")
    public List<FoodPriceData> xlsxToExcelDataList() {
        // 반환할 객체를 생성
        List<FoodPriceData> list = Lists.newArrayList();

        FileInputStream fis = null;
        XSSFWorkbook workbook = null;

        try {
            ClassPathResource resource = new ClassPathResource("file/price_data.xlsx");

            // XSSFWorkbook은 엑셀 파일 전체 내용을 담고 있는 객체
            workbook = new XSSFWorkbook(new FileInputStream(resource.getFile()));

            // 탐색에 사용할 Sheet, Row, Cell 객체
            XSSFSheet curSheet;
            XSSFRow curRow;
            XSSFCell curCell;
            FoodPriceData vo;

            // Sheet 탐색 for문
            for(int sheetIndex = 0 ; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
                // 현재 Sheet 반환
                curSheet = workbook.getSheetAt(sheetIndex);
                // row 탐색 for문
                for(int rowIndex=0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
                    // row 0은 헤더정보이기 때문에 무시
                    if(rowIndex != 0) {
                        // 현재 row 반환
                        curRow = curSheet.getRow(rowIndex);
                        vo = new FoodPriceData();
                        String value;

                        // row의 첫번째 cell값이 비어있지 않은 경우 만 cell탐색
                        if(!"".equals(curRow.getCell(0).getStringCellValue())) {

                            // cell 탐색 for 문
                            for(int cellIndex=0;cellIndex<curRow.getPhysicalNumberOfCells(); cellIndex++) {
                                curCell = curRow.getCell(cellIndex);

                                if(true) {
                                    value = "";
                                    // cell 스타일이 다르더라도 String으로 반환 받음
                                    switch (curCell.getCellType()){
                                        case HSSFCell.CELL_TYPE_FORMULA:
                                            value = curCell.getCellFormula();
                                            break;
                                        case HSSFCell.CELL_TYPE_NUMERIC:
                                            value = curCell.getNumericCellValue()+"";
                                            break;
                                        case HSSFCell.CELL_TYPE_STRING:
                                            value = curCell.getStringCellValue()+"";
                                            break;
                                        case HSSFCell.CELL_TYPE_BLANK:
                                            value = curCell.getBooleanCellValue()+"";
                                            break;
                                        case HSSFCell.CELL_TYPE_ERROR:
                                            value = curCell.getErrorCellValue()+"";
                                            break;
                                        default:
                                            value = new String();
                                            break;
                                    }

                                    // 현재 column index에 따라서 vo에 입력
                                    switch (cellIndex) {
                                        case 0: // 가격 등록 일자
                                            vo.setRegDay(value);;
                                            break;

                                        case 1: // 품목코드
                                            vo.setItemCode(value);;
                                            break;

                                        case 2: // 품목명
                                            vo.setItemName(value);
                                            break;

                                        case 3: // 품종코드
                                            vo.setKindCode(value);
                                            break;

                                        case 4: // 품종명
                                            vo.setKindName(value);
                                            break;

                                        case 5: // 평균가격
                                            vo.setAvgPrice(value);
                                            break;

                                        case 6: // 도소매 등 조사구분 : 01 도매, 02 소매
                                            vo.setProductClsCode(value);
                                            break;

                                        case 7: // 조사구분명
                                            vo.setProductClsName(value);
                                            break;

                                        case 8: // 등급코드
                                            vo.setProductRankCode(value);
                                            break;

                                        case 9: // 등급명
                                            vo.setProductRankName(value);
                                            break;

                                        case 10: // 유통단계별 단위
                                            vo.setCircUnit(value);
                                            break;

                                        case 11: // 유통단계별 무게
                                            vo.setCircUnitSize(value);
                                            break;

                                        case 12: // 등록회차
                                            vo.setRcvPhs(value);
                                            break;

                                        case 13: // 금일 최저가
                                            vo.setMinPrice(value);
                                            break;

                                        case 14: // 금일 최대가
                                            vo.setMaxPrice(value);
                                            break;

                                        default:
                                            break;
                                    }
                                }
                            }
                            // cell 탐색 이후 vo 추가
                            list.add(vo);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } finally {
            try {
                // 사용한 자원은 finally에서 해제
                if(workbook!= null) workbook.close();
                if(fis!= null) fis.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }
}
