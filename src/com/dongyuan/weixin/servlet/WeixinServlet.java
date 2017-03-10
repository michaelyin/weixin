package com.dongyuan.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dongyuan.weixin.service.CoreService;
import com.dongyuan.weixin.util.SignUtil;


/**
 * ������ĺ�����
 * @author qikuo
 * @date 2017-2-28
 */
@WebServlet("/WeixinServlet")
public class WeixinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeixinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ΢�ż���ǩ��
				String signature = request.getParameter("signature");
				// ʱ���
				String timestamp = request.getParameter("timestamp");
				// �����
				String nonce = request.getParameter("nonce");
				// ����ַ���
				String echostr = request.getParameter("echostr");

				PrintWriter out = response.getWriter();
				// ����У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��
				if (SignUtil.checkSignature(signature, timestamp, nonce)) {
					out.print(echostr);
				}
				out.close();
				out = null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");	
		// ���ú���ҵ���������Ϣ��������Ϣ
		String respXml = CoreService.processRequest(request);

		// ��Ӧ��Ϣ
		PrintWriter out = response.getWriter();
		out.print(respXml);
		out.close();
	}

}
