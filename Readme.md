| 漏洞 URL | http://10.41.1.123:10008/rmps-web/App/app.jsp      |
| -------- | -------------------------------------------------- |
| 缺陷描述 | 权限校验机制不完善，导致低权限用户可进行高权限操作 |



攻击方式：

创建两个账号，登录系统，获取sessionid。

拦截请求报文，替换sessionid。



[TOC]

# JavaWeb

Java Web，是用Java技术来解决相关web互联网领域的技术总和。web包括：web服务器和web客户端两部分。

## JSP&Sevlet

### 理解HTTP

HTTP是基于TCP协议的。TCP负责数据传输，而HTTP只是规范了TCP传输的数据的格式，而这个具体的格式，请见后面给出的资料。

```java
package http;

import java.io.*;
import java.net.Socket;

public class SocketHandler implements Runnable {

    final static String CRLF = "\r\n";   // 1：定义了HTTP头的换行符。

    private Socket clientSocket;

    public SocketHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void handleSocket(Socket clientSocket) throws IOException {

        // 与socket绑定的输入流
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // 与socket绑定的输出流
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())), true);

        String requestHeader = "";
        String s;

        while ((s = in.readLine()) != null) {

            s += CRLF;  // 2 很重要，默认情况下in.readLine的结果中`\r\n`被去掉了
            requestHeader = requestHeader + s;
            if (s.equals(CRLF)) { // 3 此处HTTP请求头我们都得到了；如果从请求头中判断有请求正文，则还需要继续获取数据
                break;
            }
        }

        System.out.println("客户端请求头：");
        System.out.println(requestHeader);

        String responseBody = "客户端的请求头是：\n" + requestHeader;

        String responseHeader = "HTTP/1.0 200 OK\r\n" + "Content-Type: text/plain; charset=UTF-8\r\n" + "Content-Length: " + responseBody.getBytes().length + "\r\n" + "\r\n";
        // 4  Content-Length的值是字节的数量。 问题来了：1、浏览器如何探测编码 2、浏览器受到content-length后会按照什么方式判断？汉字的个数？字节数？

        System.out.println("响应头：");
        System.out.println(responseHeader);

        out.write(responseHeader);
        out.write(responseBody);
        out.flush();

        out.close();
        in.close();
        clientSocket.close();

    }

    @Override
    public void run() {
        try {
            handleSocket(clientSocket);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

public class MyHTTPServer {

    public static void main(String[] args) throws Exception {

        int port = 8000;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("启动服务，绑定端口： " + port);

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(30);  // 5

        while (true) {  // 6
            Socket clientSocket = serverSocket.accept();
            System.out.println("新的连接"
                    + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
            try {
                fixedThreadPool.execute(new SocketHandler(clientSocket));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
```

这是一个实现HTTP 1.0的服务器，对于所有的HTTP请求，会把HTTP请求头响应回去。 **这个程序说明了web服务器处理请求的基本流程，JSP、Servlet、Spring MVC等只是在 这个基础上嫁接了许多方法，以让我们更方面的编写web应用。**

程序解析

> `// 1`：定义了HTTP头的换行符。
>
> `// 2`：in.readLine()的结果默认不带换行符，这里把它加上。（这不是强制的，主要看你的程序逻辑需不需要， 这个程序的目标是把HTTP请求头响应回去）。
>
> `// 3`：此时s是一个空行，根据HTTP协议，整个请求头都得到了。
>
> `// 4`：Content-Length的值是字节的数量。
>
> `// 5`：线程池。
>
> `// 6`：这个循环不停监听socket连接，使用SocketHandler处理连入的socket，而这个处理是放在线程池中的。

-- 线程池工作原理？？

### 从JSP开始



### 理解Servlet

servlet理解为javaweb最核心的部分

**过滤器&监听器**

过滤器是一种设计模式，主要用来封装Servlet中一些通用的代码。在web.xml中配置哪些URL对应哪些过滤器。

当某个事件发生时候，监听器里的方法会被调用。例如Tomcat容器启动时、销毁时，session创建时、销毁时。



### Tomcat的运行机制

Tomcat是一个servlet容器，其运行机制可参考如下：

> 先不去管技术细节，对一个servlet容器，它首先要做以下事情：
>
> 1:实现Servlet api规范。这是最基础的一个实现，servlet api大部分都是接口规范。如request、response、session、cookie。为了我们应用端能正常使用，容器必须有一套完整实现。
>
> 2：启动Socket监听端口，等待http请求。
>
> 3：获取http请求，分发请求给不同的协议处理器，如http和https在处理上是不一样的。
>
> 4：封装请求，构造HttpServletRequest。把socket获取的用户请求字节流转换成java对象httprequest。构造httpResponse。
>
> 5：调用(若未创建，则先加载)servlet，调用init初始化，执行servlet.service()方法。
>
> 6：为httpResponse添加header等头部信息。
>
> 7：socket回写流，返回满足http协议格式的数据给浏览器。
>
> 8：实现JSP语法分析器，JSP标记解释器。JSP servlet实现和渲染引擎。
>
> 9：JNDI、JMX等服务实现。容器一般额外提供命名空间服务管理。
>
> 10：线程池管理，创建线程池，并为每个请求分配线程。  





