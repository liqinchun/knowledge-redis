# knowledge-redis

redis版本

# Description

redis基数版本表示为非稳定版本、偶数版本为稳定版本.  
项目中使用的redis版本为4.0

# redis的数据结构和使用场景

String、Set、Hash、ZSet、List

## String

### 命令

INCR：对存储在指定key的数值执行原子的加1操作。 使用场景：计数器、限速器、  
MSET:一次存储多个键值对  
MGET:一次获取多个键值对  
EXISTS:查询键是否存在，返回1表示存在、返回0表示不存在  
DEL：删除键，返回1表示被执行删除的键存在并已经被删除，返回0表示被执行删除的键不存在。  
TYPE：返回key对应的值的存储类型。返回正确类型(string)和none(key不存在)

## List 有序集合,两头弹进弹出

### LPUSH

向左边(头部)添加一个新元素

### RPUSH

向右边(尾部)添加一个新元素

### LRANGE

可以从list中去除一定范围的元素 LIST可以用于实现聊天系统、消息队列  
LIST上的阻塞操作

#### LPOP

#### RPOP

#### BLPOP

当list为空时阻塞，如果超时还没有数据返回null，0表示一直阻塞

#### BRPOP

当list为空时阻塞，如果超时还没有数据返回null，0表示一直阻塞 list的自动创建和删除

## Hash

### HSET

### HGET

### HMSET

### HMGET

### HGETALL

### HINCRBY

## Set无序集合

SADD

## ZSet 唯一不重复的有序集合

### 场景

排序、排名

### Description

排序集合类似与SET与HASH的混合， 偏向SET：元素唯一、不重复 偏向HASH：有序，集合中的元素不是有序的，但是有序集合中的每一个元素都和一个浮点值相关联，称为score(每一个元素都映射到一个值)
。有序也就是用这点关联的浮点数实现的有序） 排序规则： 如果A和B是score不同，如果A.score>B.score那么A>B 如果A和B的score相同，如果A>B那么A>B

### ZADD

### ZRANGE

### ZREVRANGE

默认从大到小排序、这个命令从小到达排序

# 相关命令

##

# Pipelining

# Redis事务

# 主从

# 哨兵

# 集群

## 集群教程

## 集群规范

# 持久化

## RDB

## AOF

## 混合方式

# 客户端

## Jedis

## Lettuce

# Redis问题集

## 缓存雪崩

## 缓存击穿

## 缓存穿透



