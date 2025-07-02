## 工具类

txtBindToExcel.py

```ts
功能：
从Excel文件中的Sheet1表中ICCID列，查找出Txt文件中存在的，并在Excel的Sheet1中新增一个Fount列，找到则标注True，未找到则标注False

安装：pip install openpyxl

运行：python xxx.py
```

twoTxtBindExcle.py

```ts 
功能：
有两个 txt 文件，分别包含：
开关项目的 ICCID 列表（例如 cards_switch.txt）
降温项目的 ICCID 列表（例如 cards_cool.txt）

一个 Excel 文件中也有一列 ICCID，需要：
如果某个 ICCID 在“开关 txt 文件”中出现 → Excel 中 Found 列标注为 “开关”
如果在“降温 txt 文件”中出现 → 标注为 “降温”
如果两个都出现 → 可按需求标注（比如写成 “开关+降温”）
都不出现 → 留空或标注为 “未找到”

安装：pip install openpyxl
```

