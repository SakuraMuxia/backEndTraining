package com.iot.yl.servlet.ExportExcelServ;

import com.iot.yl.dao.SwDao;
import com.iot.yl.dao.impl.SwDaoImpl;
import com.iot.yl.pojo.SwCard;
import com.iot.yl.servlet.ExportExcelServlet;
import org.apache.poi.ss.usermodel.Row;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ExportSwMobCards extends ExportExcelServlet<SwCard> {

    @Override
    protected String getFileName() {
        return "开关_移动卡";
    }

    @Override
    protected String getSheetName() {
        return "开关系统物联网卡信息";
    }

    @Override
    protected String[] getHeaders() {
        return new String[]{"SN", "完整SN", "站点名称"};
    }

    // 获取卡数据
    @Override
    protected List<SwCard> getDataList(HttpServletRequest req) {
        SwDao swDao = new SwDaoImpl();
        return swDao.getSwMobCards();
    }

    // 填充每一行数据
    @Override
    protected void fillRow(Row row, SwCard card) {
        row.createCell(0).setCellValue(card.getSn());
        row.createCell(1).setCellValue(card.getFull_sn());
        row.createCell(2).setCellValue(card.getLocation());
    }
}
