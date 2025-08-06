use intell_switch;

select id,MAX(round(ch4/10.0,2)) as ch4
from DEV_REPORT
where create_time between date_sub(current_timestamp,interval 1 hour) and current_timestamp
group by id;

-- 使用别名的方式 a=Dev_report, 选择Dev_report表的id,最大值,
select a.id, round(max(ch4) / 10,2), ch4, b.sitename
from DEV_REPORT a
    left join DEV_CFG b
    on a.id = b.id
where ch4 >= 200
  and a.create_time between date_sub(current_timestamp, interval 1 hour) and current_timestamp
group by id,sitename
order by ch4 desc;

select id,MAX(round(ch4/10.0,2)) as ch4
from DEV_REPORT
where create_time between date_sub(current_timestamp,interval 1 day) and current_timestamp
group by id;

select id,round(MIN(ch4)/10.0,2) minch4,round(MAX(ch4)/10.0,2) maxch4
from DEV_REPORT
group by id;

SELECT DATE_FORMAT(create_time, '%Y-%m') months, count(1) '停电总次数'
FROM DEV_OUTAGE_STATIC
GROUP BY months
order by months

use intell_switch;
SELECT * FROM DEV_CFG WHERE oid > 0;

SELECT * FROM DEV_REPORT
WHERE id = 1122224029764667;

SELECT * FROM DEV_REPORT
WHERE id = 1122224029769385
and create_time BETWEEN '2024-05-13 00:00:00' AND '2024-05-16 23:59:59';

UPDATE DEV_CFG SET sitename = '老代庄中东1' ,location = '老代庄中东1',is_deleted = 1 WHERE id = '1100000000000026';

UPDATE DEV_CFG SET sitename = '葛寨西1' ,location = '葛寨西1',is_deleted = 1 WHERE id = '1100000000000031';

DELETE DEV_REPORT WHERE ID = '1100000000000001' and create_time BETWEEN '2024-02-25 00:00:00' AND '2024-02-28 00:00:00';

-- 停复电次数大于10次的站
select id,count(1) cnt
from DEV_OUTAGE_STATIC
group by id
having cnt>10
order by cnt desc

-- 统计未删除的站
select * from DEV_CFG where is_deleted = 1;

-- 查询卡是否在用
SELECT * FROM DEV_REPORT WHERE ID = '1100000000000001'

-- 查询卡是否在用，并把不存在的返回
select snn from (
select '112222402976683' AS snn
union all select '112222402978218'
) AS v
where v.snn not in (select sn from DEV_CFG);

-- 查询数据是否存在
select * from DEV_CFG where sn in (
'112222402976683',
'112222402976542');


-- 删除
-- delete FROM DEV_REPORT WHERE id = '1100000000000020' and create_time BETWEEN '2024-02-25 00:00:00' AND '2024-02-27 23:59:59';

-- 查询上报表数据
-- select * from DEV_REPORT where id = '1100000000000020';
select * from DEV_REPORT where id = '1100000000000032';


SELECT * FROM DEV_CFG WHERE oid > 5000;


UPDATE DEV_CFG SET sitename = '老代庄中东1' ,location = '老代庄中东1',is_deleted = 1 WHERE id = '1100000000000026';
UPDATE DEV_CFG SET sitename = '郑州市市区王垌村基站1' ,location = '郑州市市区王垌村基站1',is_deleted = 1 WHERE id = '1100000000000027';
UPDATE DEV_CFG SET sitename = '中牟西春岗1	' ,location = '中牟西春岗1	',is_deleted = 1 WHERE id = '1100000000000028';
UPDATE DEV_CFG SET sitename = '郑州市中牟姚家杨庄机房1' ,location = '郑州市中牟姚家杨庄机房1',is_deleted = 1 WHERE id = '1100000000000029';
UPDATE DEV_CFG SET sitename = '郑州市市区老代庄基站1' ,location = '郑州市市区老代庄基站1',is_deleted = 1 WHERE id = '1100000000000030';
UPDATE DEV_CFG SET sitename = '科学大道西三环北1' ,location = '科学大道西三环北1',is_deleted = 1 WHERE id = '1100000000000035';
