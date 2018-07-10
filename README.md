# LicenseDemo

#### 项目介绍
在基于Spring的项目中使用 `TrueLicense `生成和验证`License证书`（服务器许可）的示例代码

#### 技术依赖：
* `Spring Boot`：项目基础架构
* `TrueLicense `：基于`Java`实现的生成和验证服务器许可的简单框架

#### 环境依赖：
* `JDK8+`

#### 两个子项目说明： ####

- `ServerDemo`：用于**开发者**给客户生成`License证书`的示例代码
- `ClientDemo`：**模拟需要给客户部署的业务项目**

#### ServerDemo项目： ####

对外发布了两个RESTful接口：

（1）获取服务器硬件信息 ：

请求地址：`http://127.0.0.1:7000/license/getServerInfos`

![获取服务器硬件信息](https://www.zifangsky.cn/wp-content/uploads/2018/07/20180710140711.png)

（2）生成证书 ：

请求地址：`http://127.0.0.1:7000/license/generateLicense`

请求时需要在Header中添加一个 **Content-Type** ，其值为：**application/json;charset=UTF-8**。请求参数如下： 

```json
{
	"subject": "license_demo",
	"privateAlias": "privateKey",
	"keyPass": "private_password1234",
	"storePass": "public_password1234",
	"licensePath": "C:/Users/zifangsky/Desktop/license_demo/license.lic",
	"privateKeysStorePath": "C:/Users/zifangsky/Desktop/license_demo/privateKeys.keystore",
	"issuedTime": "2018-07-10 00:00:01",
	"expiryTime": "2019-12-31 23:59:59",
	"consumerType": "User",
	"consumerAmount": 1,
	"description": "这是证书描述信息",
	"licenseCheckModel": {
		"ipAddress": ["192.168.245.1", "10.0.5.22"],
		"macAddress": ["00-50-56-C0-00-01", "50-7B-9D-F9-18-41"],
		"cpuSerial": "BFEBFBFF000406E3",
		"mainBoardSerial": "L1HF65E00X9"
	}
}
```

![生成证书](https://www.zifangsky.cn/wp-content/uploads/2018/07/20180710141528.png)

#### ClientDemo项目： ####

项目启动时安装证书，通过`cn/zifangsky/license/LicenseCheckListener.java`类实现。用户登录时校验证书的可用性，通过`cn/zifangsky/license/LicenseCheckInterceptor.java`类实现。

#### 特别说明： ####

详细开发思路可以参考我写的这篇文章：[https://www.zifangsky.cn/1277.html](https://www.zifangsky.cn/1277.html)

