在 Java 中，BIO（阻塞 I/O）、NIO（非阻塞 I/O）和 AIO（异步 I/O）是三种不同的网络通信模型。以下是每种模型的简介及其示例代码，展示它们的差异：

### 1. BIO（Blocking I/O）

**简介**：BIO 是传统的同步阻塞模型，每个连接由一个独立的线程处理。当线程读取或写入数据时，会被阻塞，直到操作完成。

**示例代码**：

```java
import java.io.*;
import java.net.*;

public class BIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("BIO Server is running...");

        while (true) {
            Socket clientSocket = serverSocket.accept(); // 阻塞等待客户端连接
            new Thread(() -> handleClient(clientSocket)).start();
        }
    }

    private static void handleClient(Socket socket) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(
                socket.getOutputStream(), true)) {
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                writer.println("Echo: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**说明**：在这个 BIO 示例中，服务器为每个客户端连接创建一个新线程。线程在读取数据时会被阻塞，直到读取操作完成。

### 2. NIO（Non-blocking I/O）

**简介**：NIO 引入了非阻塞模式，允许一个线程管理多个连接。通过 `Selector`，线程可以检查多个通道的事件（如读、写、连接），无需阻塞等待。

**示例代码**：

```java
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class NIOServer {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8080));
        serverChannel.configureBlocking(false);
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("NIO Server is running...");

        while (true) {
            selector.select(); // 阻塞直到有事件发生
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                keyIterator.remove();

                if (key.isAcceptable()) {
                    handleAccept(key, selector);
                } else if (key.isReadable()) {
                    handleRead(key);
                }
            }
        }
    }

    private static void handleAccept(SelectionKey key, Selector selector) throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        SocketChannel clientChannel = serverChannel.accept();
        clientChannel.configureBlocking(false);
        clientChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("Accepted new connection from client");
    }

    private static void handleRead(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = clientChannel.read(buffer);
        if (bytesRead == -1) {
            clientChannel.close();
        } else {
            buffer.flip();
            String message = new String(buffer.array(), 0, bytesRead);
            System.out.println("Received: " + message);
            buffer.clear();
            buffer.put(("Echo: " + message).getBytes());
            buffer.flip();
            clientChannel.write(buffer);
        }
    }
}
```

**说明**：在这个 NIO 示例中，服务器使用一个 `Selector` 来管理多个客户端连接。通过非阻塞通道，服务器可以同时处理多个连接，而无需为每个连接创建一个线程。

### 3. AIO（Asynchronous I/O）

**简介**：AIO 是异步非阻塞模型，操作是异步执行的，完成后通过回调函数通知。这使得线程可以继续执行其他任务，而无需等待 I/O 操作完成。

**示例代码**：

```java
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AIOServer {
    public static void main(String[] args) throws IOException {
        AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8080));
        System.out.println("AIO Server is running...");

        serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(AsynchronousSocketChannel clientChannel, Void attachment) {
                serverChannel.accept(null, this); // 接受下一个连接
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                clientChannel.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        attachment.flip();
                        String message = new String(attachment.array(), 0, result);
                        System.out.println("Received: " + message);
                        clientChannel.write(ByteBuffer.wrap(("Echo: " + message).getBytes()));
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        exc.printStackTrace();
                    }
                });
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
            }
        });

        // 主线程继续运行，防止退出
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

**说明**：在这个 AIO 示例中，服务器使用异步通道来接受连接和读取数据。I/O 操作完成后，通过回调函数处理结果，主线程无需等待操作完成，可以继续执行其他任务。

### 总结

- **BIO**：每个连接一个线程，操作阻塞，适用于低并发场景。
- **NIO**：单线程管理多个连接，非阻塞，适用于高并发场景。 