# Hospital_alarm_system_backend
hospital_alarm_system_backend
# 智慧城市安防系统

基于SpringBoot的智能监控与告警平台，为城市安全提供全方位的智能监控解决方案。

## 项目介绍

智慧城市安防系统是一个集成了视频监控、智能分析、实时告警等功能的综合性安防平台。系统通过AI技术实现对异常行为的自动识别和快速响应，为城市安全提供有力保障。

### 核心功能

- 实时视频监控：支持多路视频流接入和实时预览
- 智能行为分析：基于AI的异常行为识别
- 实时告警推送：支持多种告警方式和级别
- 智能对话系统：集成华为云CBS和讯飞星火大模型
- 数据可视化：告警统计和趋势分析
- 用户权限管理：多角色权限控制

## 技术栈

- 后端框架：SpringBoot 3.1.3
- 数据库：MySQL 8.0
- 缓存：Redis
- ORM框架：MyBatis Plus 3.5.3
- 消息推送：个推(GeTui)
- 视频处理：FFmpeg + JavaCV
- 对象存储：腾讯云OSS
- AI对话：华为云CBS + 讯飞星火大模型
- 实时通信：WebSocket
- 安全认证：JWT

## 快速开始

### 环境要求

- JDK 17+
- Maven 3.6+
- MySQL 8.0+
- Redis 6.0+
- FFmpeg 4.0+

### 安装步骤

1. 克隆项目
```bash
git clone https://github.com/LayKJ/City-alarm-system-.git
cd City-alarm-system-
```

2. 配置数据库
```sql
CREATE DATABASE security_system DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

3. 配置环境变量
```bash
# MySQL配置
export MYSQL_PASSWORD=your_mysql_password

# Redis配置
export REDIS_PASSWORD=your_redis_password

# 腾讯云OSS配置
export OSS_ID=your_oss_id
export OSS_PASS=your_oss_pass

# API Keys配置
export API_KEY_1=your_api_key_1
export API_KEY_2=your_api_key_2
```

4. 修改配置文件
- 复制 `src/main/resources/application-dev.yml` 到 `src/main/resources/application.yml`
- 根据实际环境修改配置参数

5. 编译运行
```bash
mvn clean package
java -jar target/hospital-alarm-system-0.0.1-SNAPSHOT.jar
```

## 项目结构

```
src/main/java/com/leikaijie
├── config          // 配置类
├── controller      // 控制器
├── service         // 服务层
├── dao            // 数据访问层
├── model          // 数据模型
│   ├── dto        // 数据传输对象
│   └── po         // 持久化对象
├── util           // 工具类
└── aop            // 切面类
```

## 主要特性

1. 实时告警处理
   - WebSocket实时推送
   - Redis缓存优化
   - 多级告警机制

2. 智能对话系统
   - 华为云CBS集成
   - 讯飞星火大模型
   - API密钥轮换机制

3. 视频处理
   - FFmpeg视频流处理
   - JavaCV帧分析
   - 腾讯云OSS存储

4. 安全认证
   - JWT token认证
   - MD5加盐加密
   - 会话管理

5. 消息推送
   - 个推集成
   - 多级消息分发
   - 历史记录查询

## 性能优化

- Spring Cache缓存
- 分页查询优化
- 定时任务处理
- 线程池管理

## 贡献指南

1. Fork 本仓库
2. 创建新的功能分支
3. 提交代码
4. 创建 Pull Request

## 许可证

[MIT License](LICENSE)

## 联系方式

- 作者：雷凯杰
- GitHub：[LayKJ](https://github.com/LayKJ)
