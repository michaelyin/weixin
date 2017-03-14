package com.dongyuan.weixin.service;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dongyuan.weixin.message.event.QRCodeEvent;
import com.dongyuan.weixin.message.req.ReqTextMessage;
import com.dongyuan.weixin.message.resp.RespTextMessage;
import com.dongyuan.weixin.po.WeixinUserInfo;
import com.dongyuan.weixin.user.dao.DaoFactory;
import com.dongyuan.weixin.util.AdvancedUtil;
import com.dongyuan.weixin.util.CommonUtil;
import com.dongyuan.weixin.util.MessageUtil;
/**
 * ���ķ�����
 * 
 * @author qikuo
 * @date 2017-2-28
 */
public class CoreService {
	/**
	 * ����΢�ŷ���������
	 * 
	 * @param request
	 * @return xml
	 * 
	 * �����ݿ��в�ѯ�Ƿ��л�ȡ����ע�û�openid��û�еĻ��������ݿ��У����򲻽����κβ���
	 */
	public static String processRequest(HttpServletRequest request) {
		// xml��ʽ����Ϣ����
		String respXml = null;
		try {
			// ����parseXml��������������Ϣ
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// ���ͷ��ʺ�
			String fromUserName = requestMap.get("FromUserName");
			// ������΢�ź�
			String toUserName = requestMap.get("ToUserName");
			// ��Ϣ����
			String msgType = requestMap.get("MsgType");
			//������Ϣ����
			String content = requestMap.get("Content");
			//����keyֵ
			String eventKey = requestMap.get("EventKey");
			//�¼�����
			String event = requestMap.get("Event");
			//ɨ���¼�
			String scan = requestMap.get("scan");
			QRCodeEvent baseEvent = new QRCodeEvent();
			RespTextMessage textMessage = new RespTextMessage();
			ReqTextMessage textMessage2 = new ReqTextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setMsgType(msgType);
			baseEvent.setFromUserName(fromUserName);
			baseEvent.setEvent(event);
			baseEvent.setEventKey(eventKey);
			baseEvent.setMsgType(msgType);
			baseEvent.setToUserName(toUserName);
			textMessage2.setContent(content);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
			// �¼�����
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// �¼�����
				String eventType = requestMap.get("Event");
				// ����
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					
					textMessage.setContent("��ӭ��ע�ػʵ��˲ſ⣬Ϊ���ṩ7����������Ƹ����ְ��Ϣ\n<a href = 'https://jinshuju.net/f/tl21JZ\'>���ҽ�����Ƹ�Ǽ�</a>\n<a href = 'http://shop13308654.ddkwxd.com/tag/231285\'>���ҽ����������ѡ�������˲�</a>������ÿ�������ǧ�Ƶ���ְ����Ϊ��ɸѡ���¡������ʵ���ְ��Ϣ��Ͷ�ŵ��������ѡ��\n<a href = 'https://jinshuju.net/f/j3iabB\'>���ҽ�����ְ�Ǽ�</a>\n<a href = 'http://shop13308654.ddkwxd.com/tag/231300\'>���ҽ�����Ƹ��Ϣѡ��������ҵ</a>������ÿ����ڶ���Ƹ��ҵ��Ϊ��ɸѡ���¡��������ʵ���ְ��Ϣ��Ͷ�ŵ��������ѡ��\n<a href = 'http://zplsyx.iok.la/weixin3/JSP/tuiguang.jsp\'>�ƹ����</a>�������԰���������Ҫ�����ѿ����ҵ������˲š����⹤������������׬ȡ���롣�ظ������ظ��鿴����Ҫ��Ϣ");
					// ����Ϣ����ת����xml
					respXml = MessageUtil.messageToXml(textMessage);
//					Article article = new Article();
//					article.setTitle("�ػʵ��˲ſ����");
//					article.setDescription("�ػʵ��˲ſ���Ϊ�ػʵ���Ϣ���˲�Ƶ����΢�ŷ��񴰿ڣ������ڶ�ʱ������Ƹ�����ʵ��˲š��ҵ�����Ĺ���Ϊ��ּ����Ϊ���ṩ�������ʡ���ݡ���Ч�ķ���Ϊ��һҪ�������ˣ������ṩ��Ƹ��Ϣ�����и�λ�������ṩ��ְ��Ϣ������������ô�򵥡�");
//					article.setPicUrl("http://zplsyx.iok.la/weixin3/img/home.jpeg");
//					//article.setUrl("http://www.baidu.com");
//					Article article1 = new Article();
//					article1.setTitle("��Ƹ����");
//					article1.setPicUrl("weixin3/img/home.png");
//					String reurl= "http://zplsyx.iok.la/weixin3/oa.do";
//					String reurls = CommonUtil.urlEncodeUTF8(reurl);
//					article1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx179e17d128a005d0&redirect_uri="+reurls+"&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirec");
//					List<Article> articleList = new ArrayList<Article>();
//					articleList.add(article);
//					articleList.add(article1);
////					// ����ͼ����Ϣ
//					NewsMessage newsMessage = new NewsMessage();
//					newsMessage.setToUserName(fromUserName);
//					newsMessage.setFromUserName(toUserName);
//					newsMessage.setCreateTime(new Date().getTime());
//					newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
//					newsMessage.setArticleCount(articleList.size());
//					newsMessage.setArticles(articleList);
//					respXml = MessageUtil.messageToXml(newsMessage);
					
					String openid = baseEvent.getFromUserName();
					HttpSession session = request.getSession();
					session.setAttribute("openID", openid);
					//request.getRequestDispatcher("/insertServlet").forward(request, null);
					//System.out.println(session.getAttribute("openID"));
					System.out.println(openid);
					//System.out.println("eventKey"+eventKey);
					System.out.println(eventKey.substring(eventKey.length()-1));
					//��ȡ�û�openid�������Ϣд�����ݿ�
					QRCodeEvent qrCodeEvent = DaoFactory.getPersonDaoInstance().insertByopenid(baseEvent);
//					QRCodeEvent qrCodeEvent = DaoFactory.getPersonDaoInstance().selectByopenid(baseEvent);
					String APPID = CommonUtil.APPID;
					String APPSECRET = CommonUtil.APPSECRET;
					String accessToken = CommonUtil.getToken("APPID", "APPSECRET").getAccessToken();
					WeixinUserInfo user = AdvancedUtil.getUserInfo(accessToken, openid);
					//��ȡ�û�openid�������ݿ�����жϣ�������ڲ�ִ�в�������������ڣ����û���Ϣд�����ݿ�
					if (openid != null) {
						//�����û�openid��ѯ��������
						//��ѯopenid
						System.out.println("openid:"+user.getOpenId());
						//��ѯ�ǳ�
						System.out.println("nickname:"+user.getNickname());
						//��ѯ�Ա�
						System.out.println("sex:"+user.getSex());
						//��ѯ����
						System.out.println("language:"+user.getLanguage());
						//��ѯ����
						System.out.println("city:"+user.getCity());
						//��ѯʡ��
						System.out.println("province:"+user.getProvince());
						//��ѯ����
						System.out.println("country:"+user.getCountry());
						//��ѯͷ��
						System.out.println("headimgurl:"+user.getHeadImgUrl());
						//System.out.println(DaoFactory.getPersonDaoInstance().selectByopenid(qrCodeEvent));
						//DaoFactory.getPersonDaoInstance().selectByopenid(fromUserName);
//						if (DaoFactory.getPersonDaoInstance().selectByopenid(openid)) {
//							//��ִ�в���
//							System.out.println("��ִ�в���");
//						}
//						else {
//							System.out.println("�����û��ɹ�");
//							qrCodeEvent = DaoFactory.getPersonDaoInstance().insertByopenid(baseEvent);
//						}
//						if (openid.equals(DaoFactory.getPersonDaoInstance().selectByopenid(openid))) {
//							//�ݲ�������
//						}else{  
//						qrCodeEvent = DaoFactory.getPersonDaoInstance().insertByopenid(baseEvent);
//						}
//						qrCodeEvent = DaoFactory.getPersonDaoInstance().selectByopenid(openid);
						//System.out.println(DaoFactory.getPersonDaoInstance().selectByopenid(fromUserName));
					}
				}
				// ȡ������
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO �ݲ�������
				}
				// �Զ���˵�����¼�
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// �¼�KEYֵ���봴���˵�ʱ��keyֵ��Ӧ
					//String eventKey = requestMap.get("EventKey");
					// ����keyֵ�ж��û�����İ�ť
					if(eventKey.equals("btn3")){
						
					}
				}
			}
			else if(eventKey.equals(MessageUtil.EVENT_TYPE_SCAN)){
				MessageUtil.EVENT_TYPE_SCAN.equals(scan);
				System.out.println("key"+eventKey);
			}
			// ���û�����Ϣʱ
			else{
//				System.out.println("��õ���Ϣ:"+textMessage2.getContent());
//				if ("���".equals(textMessage2.getContent())||"����".equals(textMessage2.getContent())||"��ô".equals(textMessage2.getContent())) {
//					textMessage.setContent("���Եȣ�����Ϊ������ͷ���Ա������");
//					respXml = MessageUtil.messageToXml(textMessage);	
//				}
				if (textMessage.getContent().equals("?")) {
					textMessage.setContent("��ӭ��ע�ػʵ��˲ſ⣬Ϊ���ṩ7����������Ƹ����ְ��Ϣ\n<a href = 'https://jinshuju.net/f/tl21JZ\'>���ҽ�����Ƹ�Ǽ�</a>\n<a href = 'http://shop13308654.ddkwxd.com/tag/231285\'>���ҽ����������ѡ�������˲�</a>������ÿ�������ǧ�Ƶ���ְ����Ϊ��ɸѡ���¡������ʵ���ְ��Ϣ��Ͷ�ŵ��������ѡ��\n<a href = 'https://jinshuju.net/f/j3iabB\'>���ҽ�����ְ�Ǽ�</a>\n<a href = 'http://shop13308654.ddkwxd.com/tag/231300\'>���ҽ�����Ƹ��Ϣѡ��������ҵ</a>������ÿ����ڶ���Ƹ��ҵ��Ϊ��ɸѡ���¡��������ʵ���ְ��Ϣ��Ͷ�ŵ��������ѡ��\n<a href = 'http://zplsyx.iok.la/weixin3/JSP/tuiguang.jsp\'>�ƹ����</a>�������԰���������Ҫ�����ѿ����ҵ������˲š����⹤������������׬ȡ���롣�ظ������ظ��鿴����Ҫ��Ϣ");
					// ����Ϣ����ת����xml
					respXml = MessageUtil.messageToXml(textMessage);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respXml;
	}
}
