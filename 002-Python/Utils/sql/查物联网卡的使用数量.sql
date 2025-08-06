-- 使用数据库
use intell_switch;

-- 查询卡号

-- 方式1
-- 您的 SQL 查询的目的是查询一组指定的卡号（在这里是 '112222402976683' 和 '112222402978218'），并返回那些在 DEV_CFG 表中不存在的卡号
SELECT snn 
FROM (
    SELECT '112222402976683' AS snn
    UNION ALL 
    SELECT '112222402978218'
) AS v
WHERE NOT EXISTS (SELECT 1 FROM DEV_CFG WHERE sn = v.snn);

-- 方式2
-- 查询卡是否在用，并把不存在的返回(在用)
select snn from (
select '112222402976683' AS snn
union all select '112222402978218'
union all select '112222402978213'
) AS v
where v.snn not in (select sn from DEV_CFG);

-- 方式3
-- 直接使用临时表或临时视图

CREATE TEMPORARY TABLE temp_cards (snn VARCHAR(50));

INSERT INTO temp_cards (snn) VALUES 
('112222402976683'),
('112222402978218'),
('112222402979999');  -- 添加更多卡号

SELECT snn 
FROM temp_cards 
WHERE snn NOT IN (SELECT sn FROM DEV_CFG);
-- 临时表的作用域：临时表在会话（session）中创建，只在创建它的会话中有效。会话结束时，临时表会自动删除。因此，如果您不希望在会话结束时手动删除，可以选择不执行 DROP 语句
DROP TEMPORARY TABLE IF EXISTS temp_cards;


-- 查询数据是否存在
SELECT sn AS snn
FROM DEV_CFG
WHERE sn IN (
    '112222402976683',
    '112222402978218',
    '112222402978213'
);
-- 查询卡讯息并把 未删除的返回(在用)
select * from DEV_CFG where sn in (
'112222402976683',
'112222402976542')
AND is_deleted = 0;
-- 
select * from DEV_CFG where sn in (
'112222402976683',
'112222402976542')
AND is_deleted = 0;
--------------------------------------------------------------------------------
-- 查看卡是否在用
SELECT *
from DEV_CFG where sn in (
'112222402976311',
'112222402976960',
'112222402976413',
'112222402976322',
'112222402976354',
'112222402976290',
'112222402976327',
'112222402976424'
)AND is_deleted = 1;

-- 从一个临时表中查，返回不存在的卡号
select snn from (
select '112222402976683' AS snn
union all select '112222402978218'
union all select '112222402978213'
union all select '112222402978213'
union all select '112222402978213'
) AS v
where v.snn not in (select sn from DEV_CFG);

-- 
select * from DEV_CFG where sn in (
'112222402976683',
'112222402976542')
AND is_deleted = 0;

--------------------------------------------------------------------------------
--以上两种方式，现在使用python工具类进行处理，弃用。
--------------------------------------------------------------------------------


-- 查询 sn 字段以 "1122" 开头的数据，且 is_deleted = 0，语法应该改成下面这种形式
SELECT * FROM DEV_CFG
WHERE sn LIKE '1122%' AND is_deleted = 0;

-- 查询 sn 字段以 "1122" 开头的数据，且 is_deleted = 0，语法应该改成下面这种形式
SELECT * FROM DEV_CFG
WHERE sn LIKE '1122%' AND is_deleted = 0;

SELECT * FROM DEV_CFG
WHERE sn LIKE '1122%' AND is_deleted = 0 AND online_st = 1;


--降温项目上 is_deleted = 0 代表正在使用

select concat(" ",sn_real) sn_real,concat(" ",sn) sn from device_info where sn like '06%' order by  sn_real desc;

select sn_real,sn from device_info where sn like '11%' AND is_deleted = 0 order by  sn_real desc;
select * from device_info where sn like '11%' AND is_deleted = 0 order by  sn_real desc;
select sn_real sn from 


--开关项目上 is_deleted = 1 代表正在使用
select concat(" ",id) id,concat(" ",sn) sn from DEV_CFG where sn like '06%' order by  id desc;

select concat(" ",id) id,concat(" ",sn) sn from DEV_CFG where sn like '06%' AND is_deleted = 0 order by  id desc;

-- 联通卡 06开头
-- 电信卡 11开头
select id,sn from DEV_CFG where sn like '06%' AND is_deleted = 0  order by  id desc;
select id,sn from DEV_CFG where sn like '06%' AND is_deleted = 1  order by  id desc;
select * from DEV_CFG where sn like '11%' AND is_deleted = 1  order by  id desc;

select * from device_info where sn like '11%' AND is_deleted = 0  order by  id desc;
-- 筛选出郑州的离线 电信和移动的卡

SELECT * 
FROM device_info 
WHERE sn LIKE '1122%' 
  AND sn_name LIKE '%郑州市%' 
  AND is_deleted = 0 
  AND online_st = 0;

SELECT sn,sn_name
FROM device_info
WHERE sn LIKE '1122%'
  AND sn_name LIKE '%郑州市%'
  AND is_deleted = 0
  AND online_st = 0;