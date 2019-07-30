package java_nio.nioSocket.nioserver.http;

import java_nio.nioSocket.nioserver.IMessageReader;
import java_nio.nioSocket.nioserver.IMessageReaderFactory;
import java_nio.nioSocket.nioserver.MessageBuffer;


/**
 * Created by jjenkov on 18-10-2015.
 */
public class HttpMessageReaderFactory implements IMessageReaderFactory {

    public HttpMessageReaderFactory() {
    }

    @Override
    public IMessageReader createMessageReader() {
        return new HttpMessageReader();
    }
}
