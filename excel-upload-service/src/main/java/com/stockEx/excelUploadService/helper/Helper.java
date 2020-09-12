package com.stockEx.excelUploadService.helper;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.text.ParseException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.stockEx.excelUploadService.entity.StockPrice;
import com.stockEx.excelUploadService.exception.ExcelException;

public class Helper {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//	static String[] HEADERs = { "Id", "Title", "Description", "Published" };

	public static boolean hasExcelFormat(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<StockPrice> excelToStockPrice(InputStream is) throws ExcelException {
		SimpleDateFormat time_format = new SimpleDateFormat("HH:mm:ss");
		List<StockPrice> stockPriceList = new ArrayList<>();
		try {
			Workbook workbook = new XSSFWorkbook(is);
			Iterator<Sheet> sheets = workbook.sheetIterator();
			while (sheets.hasNext()) {
				Sheet sheet = sheets.next();
				Iterator<Row> rows = sheet.rowIterator();
				int rownum = 0;

				while (rows.hasNext()) {
					Row row = rows.next();
					if (rownum == 0) {
						rownum++;
						continue;
					}
					try {
						if (row.getCell(0) == null && row.getCell(1) == null && row.getCell(2) == null
								&& row.getCell(3) == null && row.getCell(4) == null) {

							break;
						}
						if (row.getCell(0) == null || row.getCell(1) == null || row.getCell(2) == null
								|| row.getCell(3) == null || row.getCell(4) == null) {
							throw new ExcelException("Error Excel Data Format in Row" + rownum);
						}

						String companyCode = row.getCell(0).getStringCellValue().replace('\u00A0', ' ').trim();
						if (companyCode == "") {
							break;
						}
//				long company_id = Long.parseLong(companyCode);
						String stock_exchange = row.getCell(1).getStringCellValue();
						Double current_price = row.getCell(2).getNumericCellValue();
						Date date = row.getCell(3).getDateCellValue();
						Date time = time_format.parse(row.getCell(4).getStringCellValue());
						StockPrice stock = new StockPrice(companyCode, stock_exchange, current_price, date, time);
						stockPriceList.add(stock);

					} catch (IllegalStateException | ParseException | NumberFormatException e) {
						e.printStackTrace();
						workbook.close();
						throw new ExcelException("Format Error on Row number " + rownum);
					}
					rownum++;
				}

			}

			workbook.close();
			return stockPriceList;

		} catch (IOException e) {

			e.printStackTrace();
			throw new ExcelException("Error reading Excel File");
		}
	}
}
