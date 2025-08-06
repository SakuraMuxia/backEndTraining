import os
import pandas as pd

# ✅ 配置开关：是否忽略 Excel ICCID 最后一位

# 有两个 txt 文件，分别包含：
# 开关项目的 ICCID 列表（例如 cards_switch.txt）
# 降温项目的 ICCID 列表（例如 cards_cool.txt）
#
# 一个 Excel 文件中也有一列 ICCID，需要
# 如果某个 ICCID 在“开关 txt 文件”中出现 → Excel 中 Found 列标注为 开关
# 如果在“降温 txt 文件”中出现 → 标注为 降温
# 如果两个都出现 → 可按需求标注（比如写成 “开关+降温”）
# 都不出现 → 留空或标注为 未找到

ignore_last_char = True

# 获取当前目录和文件路径
base_dir = os.getcwd()
data_dir = os.path.join(base_dir, 'D:\\devSpace\\product\\cardInfo\\')
txt_file = os.path.join(data_dir, 'data_lt19.txt')
excel_file = os.path.join(data_dir, 'data_lt19.xlsx')
output_file = os.path.join(data_dir, 'output_with_flag.xlsx')

# 读取 txt 文件，保留字母，去空格和引号
with open(txt_file, encoding='utf-8') as f:
    txt_data = set(
        line.strip().replace('"', '').strip()
        for line in f if line.strip()
    )

# 读取 Excel 文件
sheet_name = 'Sheet1'
column_name = 'ICCID'
df = pd.read_excel(excel_file, sheet_name=sheet_name, dtype=str, engine='openpyxl')

# 清洗 Excel ICCID 列（保留字母）
df[column_name] = (
    df[column_name]
    .astype(str)
    .str.strip()
    .str.replace('"', '', regex=False)
)

# 根据开关决定是否截断最后一位
if ignore_last_char:
    df['ICCID_compare'] = df[column_name].apply(lambda x: x[:-1] if len(x) > 1 else x)
else:
    df['ICCID_compare'] = df[column_name]

# 标注是否在 txt 中匹配（以前缀方式）
df['Found'] = df['ICCID_compare'].apply(
    lambda prefix: '找到' if any(txt_iccid.startswith(prefix) for txt_iccid in txt_data) else ''
)

# 输出调试信息
total = len(df)
found = df['Found'].value_counts().get('找到', 0)
print(f"Excel行数: {total}")
print(f"匹配成功数量: {found}")
print(f"未匹配数量: {total - found}")

# 保存结果（不包含中间对比列）
df.drop(columns=['ICCID_compare']).to_excel(output_file, index=False, engine='openpyxl')
print(f'✅ 处理完成，结果保存至：{output_file}')
