package messagefactory;

/**
 * 接口
 */

import mydecoder.MyMessage;

public interface CreateMessage {
	public void setContent(String content);
	public MyMessage getMessage();
}
