package java_nio.nioSocket.nioserver.example;




import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import java_nio.nioSocket.nioserver.*;
import java_nio.nioSocket.nioserver.http.HttpMessageReaderFactory;

/**
 * Created by jjenkov on 19-10-2015.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        String httpResponse = "HTTP/1.1 200 OK\r\n" +
                "Content-Length: 38\r\n" +
                "Content-Type: text/html\r\n" +
                "\r\n" +
                "<html><body>Hello World!</body></html>";
        

        byte[] httpResponseBytes = httpResponse.getBytes("UTF-8");
        System.out.println(httpResponseBytes[0]);
        IMessageProcessor messageProcessor = (request, writeProxy) -> {
            System.out.println("Message Received from socket: " + request.socketId);

            Message response = writeProxy.getMessage();
            response.socketId = request.socketId;
            response.writeToMessage(httpResponseBytes);

            writeProxy.enqueue(response);
        };
//
        Server server = new Server(9999, new HttpMessageReaderFactory(), messageProcessor);
//
        server.start();

    }


}
