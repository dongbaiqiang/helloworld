package b_myDecoder;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MyEncoder extends MessageToByteEncoder<MyMessage> {
	 
    @Override
    protected void encode(ChannelHandlerContext ctx, MyMessage message, ByteBuf out) throws Exception {
 
        MessageHeader header = message.getHeader();
 
        // 写入Header信息
        out.writeInt(message.getContent().length());
        out.writeInt(header.getMsgId());
        
        // 写入消息主体信息
        out.writeBytes(message.getContent().getBytes());
    }
}
