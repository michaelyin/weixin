<%@page import="com.dongyuan.weixin.util.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�����ƹ�ҳ</title>
<%
	String reurl= "http://zplsyx.iok.la/weixin3/oa.do";
	String reurls = CommonUtil.urlEncodeUTF8(reurl);
	%>
</head>
<body>
	<P>�ػʵ��˲ſⲻ������������Ƹ����ְ��������������ͨ���ƹ�׬ȡ���롣ͨ�����ķ������������ҵ���������������˲Ż����Ĺ���������Ҳ����һ�����롣�������ϸ�����£�</p><br>
	<P>	һ����ע���ػʵ��˲ſ⡱���ںţ������Ļ�·�����Ҫ�ƹ㡱��ť������ע�ᡣ</P><br>
	<P>����ע����ɺ󼴿ɽ����Ƽ�ҳ�棬������Ͻǡ�...��ת��������������Ȧ���͸����ѣ�����ע����ɺ������Ƽ��ɹ���</P><br>
	<P>����ÿһ��ͨ�����Ƽ��ĺ������ػʵ��˲ſ�������ѣ���������һ�����롣����һ�����ѡ��������ѣ�Aͨ������������ӻ��ά��ע��Ϊ��Ա��AΪ����һ�����ѡ�Bͨ��A��������ӻ��ά��ע��Ϊ��Ա��BΪ���Ķ������ѣ��Ƽ��ĺ������ػʵ��˲ſ���������ѣ���Ҳ����һ�����롣</P><br>
	<P>&nbsp;&nbsp;�磺1�����Ƽ��ĺ���A��Ҫ��Ƹ�����ػʵ��˲ſ⹺��һ��XԪ�ļ�������������һ��X*10%�����롣</P><br>
	<P>&nbsp;&nbsp;&nbsp;2�����Ƽ��ĺ���B��Ҫ��ְ�����ػʵ��˲ſ�ע���������B�ļ�������Ƹ��λ��XԪ�ļ۸�����ô������һ��X*10%�����롣</P><br>
	<P>&nbsp;&nbsp;&nbsp;3��ͨ������һ�����ѷ�������ӻ��ά��ע��Ϊ��Ա�����ػʵ��˲ſ����������XԪ���������X*6%�����롣</P><br>
	<P>&nbsp;&nbsp;&nbsp;4��ͨ�����Ķ������ѷ�������ӻ��ά��ע��Ϊ��Ա�����ػʵ��˲ſ����������XԪ���������X*4%�����롣</P><br>
	<P>�ġ���ϸ�����ս���Ȩ���ػʵ��˲ſ����С�</P><br>
	<%-- <a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx179e17d128a005d0&redirect_uri=<%=reurls %>&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirec">����ҽ����ƹ�</a> --%>
</body>
</html>