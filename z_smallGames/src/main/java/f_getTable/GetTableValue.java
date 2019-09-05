package f_getTable;
import java.io.File;

import com.alibaba.fastjson.JSONObject;

import jxl.Sheet;
import jxl.Workbook;


public class GetTableValue {
    public static ConfigTable getConfigTable(String tableName) {
    	ConfigTable tab = new ConfigTable();
    	try {

        	
        	tab.setTableName(tableName);
        	String name = "tables\\" + tableName + ".xls";

        	Workbook bookResource;
            //打开表
        	try{
        		bookResource = Workbook.getWorkbook(new File(name));
            
        	} catch(Exception e){
        		return null;
        	}
            // 获得第一个工作表对象
            Sheet sheet1 = bookResource.getSheet(0);
            
            // 得到第一列第一行的单元格
            //行数    sheet1.getRows();
            //列数    sheet1.getColumns();
            int ng = sheet1.getRows();
            int mg = sheet1.getColumns();

            int n = 0;
            int m = 0;
            boolean end = false;
            for(;;n++){
            	
            	for(;;m++){
            		String c = sheet1.getCell(n, m).getContents();
            		if("start".equals(c)){
            			end = true;
            			break;
            		}
            	}
            	if(end)break;
            }
            

            
            for(int i=m;;i++)
            {
            	
            	String id = sheet1.getCell(n + 1, i).getContents();
            	JSONObject content = new JSONObject();
                for(int j=n + 1; j < sheet1.getColumns();j++)
                {
                	content.put(sheet1.getCell(j, m-1).getContents(), sheet1.getCell(j, i).getContents()); 
                }   
                tab.getIds().add(id);
                tab.getContent().put(id, content);
            	if("end".equals(sheet1.getCell(n, i).getContents()))break;
            }

            bookResource.close();

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
        
		return tab;
    }
}