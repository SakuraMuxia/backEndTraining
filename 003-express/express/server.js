const express = require("express");
const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// 导入路由
const likeRoutes = require("./routes/like");
const mapRoutes = require("./routes/map");
const systemRoutes = require("./routes/system");
const deviceRoutes = require("./routes/device");


// 使用路由模块
app.use(likeRoutes);
app.use(mapRoutes);
app.use(systemRoutes);
// 使用 /api/device 作为前缀
app.use(deviceRoutes);

// 启动服务
app.listen(8081, () => {
  console.log("express server is running on http://127.0.0.1:8081");
});
