# rabbit
&emsp;&emsp;一堆java常用工具的整理封装。高内聚！低耦合！无其他私有包的依赖！拷来即用。企业开发？接外包？赚外快？还是学习？选rabbit就对了~

## 技术栈
- jdk 1.8
- SpringBoot 2.1.6

## rabbit服务概述
### rabbit-client
&emsp;&emsp;一款集结了httpclient、restTemplate和webClient的http客户端链接工具，仅需使用以下两个关键注解即可发送http请求
- @Remote(url = "http://localhost:8080/api",headers = {@RemoteHeader(name = "token",value = "xxxxx")})
- @RemoteRequestMapping(path = "/xxx/{id}",type = HttpclientTypeEnum.WEB_CLIENT)

