# SSL 安全套接层

    SSL 是一个不依赖于平台和运用程序的协议，
    位于TCP/IP协议与各种应用层协议之间，为数据通信提高安全支持。

## SSL 加密知名协议

    HTTP over SSL，简写 https，工作在443端口
    Email over SSL

## SSL 原理详解

    SSL记录协议层（SSL Record Protocol Layer）
        为高层协议提供基本的安全服务。
        它建立在可靠的传输（如TCP）之上，
        封装各种高层协议，
        具体实施压缩解压缩，加密解密，计算和校验MAC（Message Authentication Code）等与安全有关的操作。
    SSL握手协议层（SSL HandShake Protocol Layer）
        SSL握手协议（SSL HandShake Protocol），
            它建立在SSL记录协议之上，用于在实际的数据传输开始之前，通讯双方进行身份认证、协商加密算法、交换加密密钥等。
        SSL密码参数修改协议（SSL Change Cipher Spec Protocol），
        SSL告警协议（SSL Alert Protocol）
            用于SSL管理信息的交换，允许应用协议传送数据之间相互验证，协商加密算法和生成密钥等。

## SSL 建立

    客户端首先发送 ClientHello 消息到服务器端，
    服务器端收到消息后，回应 ServerHello 给客户端。

    ClientHello
        客户端版本，按优先级列出客户端支持的协议版本，首选客户端希望支持的最新协议版本。
        客户端随机数
        会话ID （Session Id）
            如果客户端第一次连接到服务器，那么这个字段就会保持为空。
            如果该字段不为空，说明以前与服务器端有连接的，
                此次期间，服务器将使用 Session Id 映射对称密钥，
                并将 Session Id 存储在客户端浏览器中，为映射设置一个时间限。
            如果浏览器将来连接到同一台服务器（在时间到期之前），它将发送 Session Id，
                服务器将对映射的 Session Id 进行验证，并使用以前用过的对称密钥来恢复 Session，
                这种情况下不需要完全握手，也叫做SSL会话恢复。
        加密套件
            客户端会给服务器发送自己已知的密码套件列表，客户按优先级排列的。
            服务器端会从中选出一种来作为双方共同的加密套件。
        压缩方法
            TLS 1.3开始，禁用了TLS压缩
        扩展包
            其它参数（如服务器名称，填充，支持的签名算法等）可以作为扩展名使用。

    ServerHello
        服务器版本，服务端会选择客户端支持的最新版本
        服务器随机数
        加密套件，服务器会从客户端发送的加密套件列表中选出一个加密套件。
        会话ID（Session Id）
            服务器将约定的Session参数存储在TLS缓存中，并生成与其对应的 Session Id。
            与Server Hello一起发送到客户端。
            客户端可以写入约定的参数到此Session Id，并给定到期时间。
        流量巨大的应用程序，加入Session Tickets扩展
            服务器将创建一个新的会话票证（Session Tickets），并使用只有服务器知道的经过私钥加密的Session 参数。
            它将存储在客户端

    
                
            
            

    
