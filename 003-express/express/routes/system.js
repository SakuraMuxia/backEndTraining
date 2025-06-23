const express = require("express");
const router = express.Router();

// 示例静态数据
const filteredData = [
  { name: "设备1" },
  { name: "设备2" }
];

router.get("/system/device/list", (req, res) => {
  console.log("请求url:", req.query);
  res.json({
    code: 0,
    message: "成功",
    data: {
      list: filteredData
    }
  });
});

module.exports = router;
