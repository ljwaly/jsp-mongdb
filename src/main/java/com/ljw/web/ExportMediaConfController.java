package com.ljw.web;


import com.alibaba.fastjson.JSONObject;
import com.ljw.mongdbconf.Teacher;
import com.ljw.util.StringUtil;
import com.ljw.vo.MediaConf;
import com.ljw.vo.MediaConfEntity;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/export")
public class ExportMediaConfController {


    private int rateType1Low = 0;
    private int rateType1High = 50;
    private int rateType2Low = 51;
    private int rateType2High = 100;
    private int rateType3Low = 105;
    private int rateType3High = 195;
    private int rateType4Low = 200;
    private int rateType4High = 245;
    private int rateType5Low = 250;
    private int rateType5High = 295;
    private int rateType6Low = 300;
    private int rateType6High = 600;
    
    
    public static void main(String[] args) throws Exception {
    	
    	String  uc="96";
    	String  mt="10";
    	ExportMediaConfController ec = new ExportMediaConfController();
    	String input = ec.getSource("/mediaconf.json");
    	List<MediaConf> mediaConfs = JSONObject.parseArray(input, MediaConf.class);
    	for (MediaConf mediaConf : mediaConfs) {
    		if (mt.equals(mediaConf.getMediaType()) && uc.equals(mediaConf.getUsageCode())) {
				System.out.println(mediaConf);
			}
		}
	}
    
    //http://localhost:8075/export/excel
    @RequestMapping("/excel")
    public void getExcel(HttpServletResponse response) throws IOException{
    	String input = getSource("/mediaconf.json");
    	
        if (input != null) {
            List<MediaConfEntity> mediaConfs = JSONObject.parseArray(input, MediaConfEntity.class);
            composeMces(mediaConfs);
            System.out.println(mediaConfs.size());
            
            
            
            
            HSSFWorkbook workbook = new HSSFWorkbook();
    		HSSFSheet sheet = workbook.createSheet("码率表");
    		String fileName = "mediaconf" + ".xls";//设置要导出的文件的名字
    		String[] headers = {
    				"fileid", "mediaType", "usageCode", "codeRate", "container", 
    				"lowestNetType", "isAudio", "isLive", "isDown", "filters",
    				"rateType", "rateTypeDesc", "ves"};
           
    		HSSFRow row = sheet.createRow(0);
    		// 在excel表中添加表头
    		for (int i = 0; i < headers.length; i++) {
    			HSSFCell cell = row.createCell(i);
    			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
    			cell.setCellValue(text);
    		}

    		int rowNum = 1;
    		// 在表中存放查询到的数据放入对应的列
    		for (MediaConfEntity mediaConfEntity : mediaConfs) {
    			HSSFRow row1 = sheet.createRow(rowNum);
    			row1.createCell(0).setCellValue(StringUtil.null2Str(mediaConfEntity.getFileid()));
    			row1.createCell(1).setCellValue(StringUtil.null2Str(mediaConfEntity.getMediaType()));
    			row1.createCell(2).setCellValue(StringUtil.null2Str(mediaConfEntity.getUsageCode()));
    			row1.createCell(3).setCellValue(StringUtil.null2Str(mediaConfEntity.getCodeRate()));
    			row1.createCell(4).setCellValue(StringUtil.null2Str(mediaConfEntity.getContainer()));
    			row1.createCell(5).setCellValue(StringUtil.null2Str(mediaConfEntity.getLowestNetType()));
    			row1.createCell(6).setCellValue(StringUtil.null2Str(mediaConfEntity.getIsAudio()));
    			row1.createCell(7).setCellValue(StringUtil.null2Str(mediaConfEntity.getIsLive()));
    			row1.createCell(8).setCellValue(StringUtil.null2Str(mediaConfEntity.getIsDown()));
    			row1.createCell(9).setCellValue(StringUtil.null2Str(mediaConfEntity.getFilters()));
    			row1.createCell(10).setCellValue(StringUtil.null2Str(mediaConfEntity.getRateType()));
    			row1.createCell(11).setCellValue(StringUtil.null2Str(mediaConfEntity.getRateTypeDesc()));
    			row1.createCell(12).setCellValue(StringUtil.null2Str(mediaConfEntity.getVes()));
    			rowNum++;
    		}

            
            response.setContentType("application/octet-stream");
    		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        }
        
        
       
        
        
    }

	private String getSource(String path) throws IOException {
		URL resource = this.getClass().getResource(path);
        File file = new File(resource.getPath());
        String input = FileUtils.readFileToString(file, "UTF-8");
		return input;
	}

   

    public void composeMces(List<MediaConfEntity> mediaConfs){
        if(mediaConfs != null && mediaConfs.size() > 0){
            for(MediaConfEntity mce:mediaConfs){
                if(mce.getCodeRate() != null) {
                    Integer rateType = calRateTypeByCodeRate(mce.getCodeRate());
                    mce.setRateType(rateType);
                    switch(rateType){
                        case(1):
                            mce.setRateTypeDesc("480P");
                            break;
                        case(2):
                            mce.setRateTypeDesc("540P");
                            break;
                        case(3):
                            mce.setRateTypeDesc("720P");
                            break;
                        case(4):
                            mce.setRateTypeDesc("1080P");
                            break;
                        case(5):
                            mce.setRateTypeDesc("2K");
                            break;
                        case(6):
                            mce.setRateTypeDesc("4K");
                            break;
                        case(7):
                            mce.setRateTypeDesc("4K_hdr");
                            break;
                    }
                }

                String filters = mce.getFilters();
                if(mce.getFilters() != null && filters.contains("is_H265")){
                    mce.setVes("H265");
                } else {
                    mce.setVes("H264");
                }
            }
        }
    }

    public Integer calRateTypeByCodeRate(String codeRate){
        if(!StringUtil.isNumber(codeRate)){
            return new Integer(1);
        }

        Integer cr = Integer.parseInt(codeRate);

        if("220".equals(codeRate)) {
            return 7;
        }else if(rateType1Low <= cr && rateType1High >= cr){
            return 1;
        }else if(rateType2Low <= cr && rateType2High >= cr){
            return 2;
        }else if(rateType3Low <= cr && rateType3High >= cr){
            return 3;
        }else if(rateType4Low <= cr && rateType4High >= cr){
            return 4;
        }else if(rateType5Low <= cr && rateType5High >= cr){
            return 5;
        }else if(rateType6Low <= cr && rateType6High >= cr){
            return 6;
        }
        return new Integer(1);
    }
}
