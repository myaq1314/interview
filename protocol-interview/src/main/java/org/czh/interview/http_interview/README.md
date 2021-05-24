# HTTP 协议

    超文本传输协议 HyperText Transfer Protocol
    它是基于TCP协议的应用层传输协议，
    简单来说就是客户端和服务端进行数据传输的一种规则。

    HTTP协议属于应用层，
    建立在传输层协议TCP之上。
    客户端通过与服务器建立TCP连接，
    之后发送HTTP请求与接收HTTP响应都是通过访问Socket接口来调用TCP协议实现。

    HTTP 是一种无状态 (stateless) 协议, 
    HTTP协议本身不会对发送过的请求和相应的通信状态进行持久化处理。
    这样做的目的是为了保持HTTP协议的简单性，
    从而能够快速处理大量的事务, 提高效率。

    由于HTTP是无状态协议，所以必须引入一些技术来记录管理状态，例如Cookie。

## HTTP URL

    HTTP URL 包含了用于查找某个资源的详细信息, 格式如下:

    http://host[":"port][abs_path]

### HTTP 请求

HTTP请求由请求行，消息报头，请求正文三部分构成。
GET方法并没有请求正文。

![img.png](img.png)

#### HTTP 请求状态行

    请求行由请求Method, URL字段 和 HTTP Version三部分构成, 
    总的来说请求行就是定义了本次请求的请求方式, 请求的地址, 以及所遵循的HTTP协议版本

    例如：
        GET /example.html HTTP/1.1 (CRLF)

#### HTTP 协议方法

    GET： 请求获取Request-URI所标识的资源 
    POST： 在Request-URI所标识的资源后增加新的数据 
    HEAD： 请求获取由Request-URI所标识的资源的响应消息报头 
    PUT： 请求服务器存储或修改一个资源，并用Request-URI作为其标识 
    DELETE： 请求服务器删除Request-URI所标识的资源 
    TRACE： 请求服务器回送收到的请求信息，主要用于测试或诊断 
    CONNECT： 保留将来使用 
    OPTIONS： 请求查询服务器的性能，或者查询与资源相关的选项和需求

#### HTTP 请求头

消息报头由一系列的键值对组成，

允许客户端向服务器端发送一些附加信息或者客户端自身的信息

|Header|解释|示例|
|:----:|:----:|:----:|
|Accept|指定客户端能够接收的内容类型|Accept:text/plain,text/html|
|Referer|表示这个请求是从哪个URL进来的|从百度搜索淘宝，那这个referer就是www.baidu.com|
|Accept-Charset|指定浏览器可以接受的字符编码集|Accept-charset:iso-8859-5,utf-8|
|Accept-Encoding|指定浏览器可以支持的Web服务器返回内容压缩编码类型|Accept-Encoding:compress,gzip|
|Accept-Language|指定浏览器可以接受的语言|Accept-Language:en,zh|
|Accept-Ranges|可以请求网页实体的一个或者多个子范围字段|Accept-Ranges:bytes|
|Authorization|指定Http授权的授权证书类型|Authorization:Basic QWxhZGRpbjpvcGVuIHNIc2FZQ==|
|Cache-Control|指定请求和响应遵循的缓存机制|Cache-Control:no-cache|
|Connection|表示是否需要持久连接(Http 1.1 默认进行持久连接)|Connection:close|
|Cookie|Http请求发送时，会把保存在该请求域名下的所有cookie值一起发送给Web服务器|Cookie:$Version=1;Skin=new;|
|Content-Length|请求的内容长度|Content-Length:348|
|Content-Type|请求的与实体对应的MIME信息|Content-Type:application/octet-stream|
|Host|指定要请求的资源所在的主机和端口|127.0.0.1:8080|
|user-Agent|||

### HTTP 响应

HTTP响应由状态行、消息报头、响应正文三部分组成。

![img_1.png](img_1.png)

#### HTTP响应状态行

    状态行由三部分组成，包括HTTP协议的版本、状态码，以及对状态码的文本描述。
    例如：HTTP/1.1 200 OK (CRLF)

#### HTTP响应状态码

    状态码有三位数字组成
        第一个数字定义了响应的类别
            1xx 指示信息，表示请求已接收，继续处理
            2xx 成功，表示请求已被成功接收、理解、接受
            3xx 重定向，要完成请求必须进行更进一步的操作
            4xx 客户端错误，请求有语法错误或请求无法实现
            5xx 服务器端错误，服务器未能实现合法的请求
    常见状态码、状态描述
        200 OK，客户端请求成功
        400 Bad Request，客户端请求有语法错误，不能被服务器理解
        401 Unauthorized，请求未经授权，这个状态码必须和 WWW-Authenticate 报头域一起使用
        403 Forbidden，服务器收到请求，但是拒绝提供服务
        404 Not Found，请求资源不存在，输入了错误的URL
        500 Internal Server Error，服务器发生不可预期的错误
        503 Server Unavailable，服务器当前不能处理客户端的请求，一段时间后，可能恢复正常。

### HTTP 五大特点

    1、支持客户/服务模式
    2、简单快速
        客户向服务器请求服务时，只需传送请求方法和路径。
        HTTP服务器的程序规模小，因而通信速度很快。
    3、灵活
        HTTP允许传输任意类型的数据对象。正在传输的类型由Content-Type加以标记。
    4、无连接
        无连接的含义是限制每次连接只处理一个请求。服务器处理完客户的请求，并收到客户的应答后，即断开连接。采用这种方式可以节省传输时间。
        现在可以通过 Connection:Keep-Alive实现长连接。
    5、无状态
        HTTP协议是无状态协议。
        无状态是指协议对于事务处理没有记忆能力。
        缺少状态意味着如果后续处理需要前面的信息，则它必须重传，这样可能导致每次连接传送的数据量增大。
        另一方面，在服务器不需要先前信息时它的应答就较快。

### 非持久连接和持久连接

    客户端发出一系列请求，服务器对每个请求进行响应。
    对于这些请求，响应，如果每次都经过一个单独的TCP连接发送，称为非持久连接。
    如果每次都经过相同的TCP连接进行发送，称为持久连接。

    非持久连接每次请求、响应之后都要断开连接，下次再建立新的TCP连接，这样就造成了大量的通信开销。
    非持久连接给服务器带来了沉重的负担，每台服务器可能同时面对数以百计甚至更多的请求。
    持久连接就是为了解决这些问题，其特点是一直保持TCP连接状态，直到遇到明确的中断要求之后再中断连接。
    持久连接减少了通信开销，节省了通信量。






