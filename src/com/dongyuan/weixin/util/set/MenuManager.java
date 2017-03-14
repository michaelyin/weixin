package com.dongyuan.weixin.util.set;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dongyuan.weixin.menu.Button;
import com.dongyuan.weixin.menu.ClickButton;
import com.dongyuan.weixin.menu.ComplexButton;
import com.dongyuan.weixin.menu.Menu;
import com.dongyuan.weixin.menu.ViewButton;
import com.dongyuan.weixin.po.Token;
import com.dongyuan.weixin.util.CommonUtil;
import com.dongyuan.weixin.util.MenuUtil;

/**
 * �˵���������
 * 
 * @author qikuo
 * @date 2017-2-28
 */
public class MenuManager {
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);

	/**
	 * ����˵��ṹ
	 * 
	 * @return
	 */
	private static Menu getMenu() {
		//��ť1
		ViewButton btn11 = new ViewButton();
		btn11.setName("��Ƹ�Ǽ�");
		btn11.setType("view");
		btn11.setUrl("https://jinshuju.net/f/tl21JZ");
	
		ViewButton btn12 = new ViewButton();
		btn12.setName("�����˲�");
		btn12.setType("view");
		btn12.setUrl("https://jinshuju.net/f/OAOrtf");
		
		ViewButton btn13 = new ViewButton();
		btn13.setName("��������");
		btn13.setType("view");
		btn13.setUrl("http://shop13308654.ddkwxd.com/tag/231285");
		
		//��ť2
		ViewButton btn21 = new ViewButton();
		btn21.setName("��ְ�Ǽ�");
		btn21.setType("view");
		btn21.setUrl("https://jinshuju.net/f/j3iabB");
		
		ViewButton btn22 = new ViewButton();
		btn22.setName("�����λ");
		btn22.setType("view");
		btn22.setUrl("https://jinshuju.net/f/d4unTY");
		
		ViewButton btn23 = new ViewButton();
		btn23.setName("��Ƹ��Ϣ");
		btn23.setType("view");
		btn23.setUrl("http://shop13308654.ddkwxd.com/tag/231300");
		
		//��ť3
		//String reurl= "http://zplsyx.iok.la/weixin3/oa.do";
		//String reurls = CommonUtil.urlEncodeUTF8(reurl);
		ViewButton btn3 = new ViewButton();
		btn3.setName("�ƹ����");
		btn3.setType("view");
		btn3.setUrl("http://zplsyx.iok.la/weixin3/JSP/tuiguang.jsp");
		//btn11.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx179e17d128a005d0&redirect_uri="+reurls+"&response_type=code&scope=snsapi_userinfo&state=123#wechat_redire");
		///weixin3/WebContent/JSP/tuiguang.jsp
		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("��Ƹ���");
		mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13 });

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("��ְ���");
		mainBtn2.setSub_button(new Button[] { btn21, btn22, btn23 });

		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2, btn3 });
		
		return menu;
	}

	public static void main(String[] args) {
		// �������û�Ψһƾ֤
		String appId = CommonUtil.APPID;
		// �������û�Ψһƾ֤��Կ
		String appSecret = CommonUtil.APPSECRET;

		// ���ýӿڻ�ȡƾ֤
		Token token = CommonUtil.getToken(appId, appSecret);

		if (null != token) {
			// �����˵�
			boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());

			// �жϲ˵��������
			if (result)
				//log.info("�˵������ɹ���");
				System.out.println("�˵������ɹ�");
			else
				//log.info("�˵�����ʧ�ܣ�");
				System.out.println("����ʧ��");
			
		}
	}
}
