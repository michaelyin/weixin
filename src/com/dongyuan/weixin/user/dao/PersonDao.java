package com.dongyuan.weixin.user.dao;

import com.dongyuan.weixin.message.event.QRCodeEvent;
import com.dongyuan.weixin.po.WeixinOauth2Token;

public interface PersonDao {
	public QRCodeEvent insertByopenid(QRCodeEvent qrCodeEvent)throws Exception;
	// ��scene_id��ѯ����ҪΪ����ʹ��
	public WeixinOauth2Token queryByScene_ID(String openID) throws Exception ;
}
