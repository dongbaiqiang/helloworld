package mydecoder;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;


public class MyDecoder extends ByteToMessageDecoder {
	 
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
 
        // 获取消息长度
        int contentLength = in.readInt();
        
        
        // 获取CmdId
        int cmdId = in.readInt();
     
       
        // 组装协议头
        MyHeader header = new MyHeader(contentLength, cmdId);
 
        // 读取消息内容
        byte[] content = in.readBytes(in.readableBytes()).array();
        
        
        MyMessage message = new MyMessage(header, new String(content));
 
        out.add(message);
    }
}

