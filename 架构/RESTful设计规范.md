# RESTful设计规范

## 1.规范的作用

​	API表达的是数据提供者和使用者之间的契约，通过遵循RESTful的最佳实践来定义API的URI，可降低系统问题的成本，并有助于运维对应用的管理和维护。

## 2.核心价值

The easier your API is to consume, the more people that will consume it.

## 3.核心准则

层级主要是用来对API进行分类，且层级不应太多，越靠前的就要越要稳定不变。

## 4.路径组成

/{version}/{servicename}/{resource}/[{resource-id}[/{function}]

## 5.基本规范

**规则1：**正斜杠分隔符（/）必须用来指示层级关系

**规则2：**所有名字必须以英文且全小写字母

**规则3：**应使用连字符（ - ）来提高URI的可读性

**规则4：**不得在URI中使用下划线（_）

**规则5：**查询参数必须采用snake_case 形式

**规则6：**文件扩展名不应包含在URI中

**规则7：**端点名称必须采用复数

**规则8：**URI上中禁止出现动词

**规则9：**结尾不应包含（/）

## 6.方法动词

**GET：**查询资源

**POST：**新增资源

**PUT：**更新资源

**DELETE：**删除资源

**HEAD：**探测元数据或健康状态

## 7.查询参数

**排序：**?sort=key|asc/desc

**过滤：**?filter=key 运算符 value

**分页：**?page=2|per_page=100

**令牌：**?accesstoken={accesstoken}

**搜索：**?search=value

## 8.内容类型

application/json

