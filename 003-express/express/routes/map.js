const express = require("express");
const router = express.Router();
const provinceData = require("../data/provinceData.json");
const allProvinceData = require("../data/allProvinceData.json");

router.get("/api/core/device/map/province/list", (req, res) => {
  res.status(200).json({
    code: 0,
    message: "成功",
    data: {
      provinceData
    }
  });
});

router.post("/api/core/device/map/oneProvince/list", (req, res) => {
  const { name } = req.query;
  if (!name) {
    return res.status(400).json({ code: 1, message: "缺少省份参数 name" });
  }

  const filteredData = allProvinceData.filter(device => device.snName.includes(name));
  res.json({
    code: 0,
    message: "成功",
    data: {
      list: filteredData
    }
  });
});

module.exports = router;
