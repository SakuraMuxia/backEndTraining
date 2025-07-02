"""
有两个 txt 文件，分别包含：
开关项目的 ICCID 列表（例如 cards_switch.txt）
降温项目的 ICCID 列表（例如 cards_cool.txt）

一个 Excel 文件中也有一列 ICCID，需要
如果某个 ICCID 在“开关 txt 文件”中出现 → Excel 中 Found 列标注为 开关
如果在“降温 txt 文件”中出现 → 标注为 降温
如果两个都出现 → 可按需求标注（比如写成 “开关+降温”）
都不出现 → 留空或标注为 未找到
"""
import os
import pandas as pd

# 当前目录的 data 子目录
base_dir = os.getcwd()
data_dir = os.path.join(base_dir, 'data')

# 文件路径
switch_txt = os.path.join(data_dir, 'cards_switch.txt')
cool_txt = os.path.join(data_dir, 'cards_cool.txt')
excel_file = os.path.join(data_dir, 'data.xlsx')
output_file = os.path.join(data_dir, 'output_labeled.xlsx')
not_found_file = os.path.join(data_dir, 'iccids_not_found.txt')

# 读取两个 txt 文件中的 ICCID（去除空行和空格）
switch_iccids = set(line.strip() for line in open(switch_txt, encoding='utf-8') if line.strip())
cool_iccids = set(line.strip() for line in open(cool_txt, encoding='utf-8') if line.strip())

# 读取 Excel 文件
sheet_name = 'Sheet1'
column_name = 'ICCID'
df = pd.read_excel(excel_file, sheet_name=sheet_name, dtype=str, engine='openpyxl')

# 清洗 ICCID 列
df[column_name] = df[column_name].astype(str).str.strip().str.replace('"', '', regex=False)

# 判断每行 ICCID 属于哪个项目
def label_iccid(iccid):
    in_switch = iccid in switch_iccids
    in_cool = iccid in cool_iccids
    if in_switch and in_cool:
        return '开关+降温'
    elif in_switch:
        return '开关'
    elif in_cool:
        return '降温'
    else:
        return ''

# 添加 Found 列
df['Found'] = df[column_name].apply(label_iccid)

# 找出 Excel 中未在两个 txt 中出现的 ICCID
not_found = set(df[column_name]) - (switch_iccids | cool_iccids)

# 打印
print("以下 ICCID 未在两个 txt 文件中找到：")
for iccid in sorted(not_found):
    print(iccid)

# 保存未找到的 ICCID 到 txt 文件
with open(not_found_file, 'w', encoding='utf-8') as f:
    for iccid in sorted(not_found):
        f.write(iccid + '\n')

print(f"未找到的 ICCID 已保存至：{not_found_file}")

# 保存标注后的 Excel
df.to_excel(output_file, index=False, engine='openpyxl')
print(f'处理完成，结果已保存至 {output_file}')
