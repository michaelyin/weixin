package com.dongyuan.weixin.message.event;

/**
 * �Զ���˵��¼�
 * 
 * @author qikuo
 * @date 2017-3-1
 */
public class QRCodeEvent extends BaseEvent {
	// �¼�KEYֵ�����Զ���˵��ӿ���KEYֵ��Ӧ
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String sceneId) {
		EventKey = sceneId;
	}
}
