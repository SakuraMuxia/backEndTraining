const express = require("express");
const router = express.Router();
const likeData = require("../data/userData.json");

router.get("/likeList", (req, res) => {
  let { pageSize = 6, pageNo = 1 } = req.query;
  pageNo = parseInt(pageNo);
  pageSize = parseInt(pageSize);

  res.json({
    ok: 1,
    msg: "success",
    likeList: likeData.slice((pageNo - 1) * pageSize, pageSize * pageNo),
    pageSum: Math.ceil(likeData.length / pageSize),
  });
});

module.exports = router;
