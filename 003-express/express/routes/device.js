const express = require("express");
const router = express.Router();
const deviceData = require("../data/deviceData.json");

router.get("system/device/list", (req, res) => {
  res.status(200).json({
    code: 0,
    message: "成功",
    data: {
      deviceData,
    },
  });
});

module.exports = router;
