package com.iot.yl.servlet;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public abstract class ExportExcelServlet<T> extends HttpServlet{
    // 子类必须实现：获取文件名
    protected abstract String getFileName();

    // 子类必须实现：获取Sheet名
    protected abstract String getSheetName();

    // 子类必须实现：获取表头
    protected abstract String[] getHeaders();

    // 子类必须实现：获取数据
    protected abstract List<T> getDataList(HttpServletRequest req);

    // 子类必须实现：如何填充一行数据
    protected abstract void fillRow(Row row, T data);

    // 转码，设置文件名
    protected void setDownloadFileName(HttpServletResponse resp, String fileName) throws UnsupportedEncodingException {
        // 自动补全扩展名，如果没有后缀，默认使用 .xlsx
        if (!fileName.contains(".")) {
            fileName += ".xlsx";
        }
        String encodedFileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
        resp.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + encodedFileName);
        resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Workbook workbook = new XSSFWorkbook(); // 可换成 HSSFWorkbook 用 .xls
        Sheet sheet = workbook.createSheet(getSheetName());

        // 1. 创建表头
        Row headerRow = sheet.createRow(0);
        // String类型数组
        String[] headers = getHeaders();
        // 设置表头
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);

            // 样式（加粗）
            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            style.setFont(font);
            cell.setCellStyle(style);
        }

        // 2. 填充数据
        List<T> dataList = getDataList(req);
        int rowNum = 1;
        for (T data : dataList) {
            Row row = sheet.createRow(rowNum++);
            // 填充数据
            fillRow(row, data);
        }

        // 3. 自动调整列宽
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // 4. 设置响应头
        resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        // 调用设置文件名
        setDownloadFileName(resp,getFileName());

        // 5. 输出到浏览器
        try (OutputStream out = resp.getOutputStream()) {
            workbook.write(out);
        } finally {
            workbook.close();
        }
    }

}
