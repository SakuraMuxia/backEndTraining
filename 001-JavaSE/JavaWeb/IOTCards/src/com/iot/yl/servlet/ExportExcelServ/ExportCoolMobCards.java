package com.iot.yl.servlet.ExportExcelServ;

import com.iot.yl.dao.CoolerDao;
import com.iot.yl.dao.impl.CoolerDaoImpl;
import com.iot.yl.pojo.CoolerCard;
import com.iot.yl.servlet.ExportExcelServlet;
import org.apache.poi.ss.usermodel.Row;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ExportCoolMobCards extends ExportExcelServlet<CoolerCard> {

    @Override
    protected String getFileName() {
        return "降温_移动卡";
    }

    @Override
    protected String getSheetName() {
        return "降温系统物联网卡信息";
    }

    @Override
    protected String[] getHeaders() {
        return new String[]{"SN", "完整SN", "站点名称"};
    }

    // 获取卡数据
    @Override
    protected List<CoolerCard> getDataList(HttpServletRequest req) {
        CoolerDao coolerDao = new CoolerDaoImpl();
        return coolerDao.getCoolMobCards();
    }

    // 填充每一行数据
    @Override
    protected void fillRow(Row row, CoolerCard card) {
        row.createCell(0).setCellValue(card.getSn());
        row.createCell(1).setCellValue(card.getFull_sn());
        row.createCell(2).setCellValue(card.getSn_name());
    }
}
