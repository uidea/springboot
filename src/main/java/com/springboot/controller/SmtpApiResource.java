package com.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.SmtpApi;
import com.springboot.model.MailRequest;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @ClassName: UserController
 * @Function: TODO
 * @Description: TODO
 * @date:2018年7月10日 下午1:40:43
 * 
 * @author liubin
 * @email aguai_liu@163.com
 * @version
 * @since JDK 1.8
 */

@RestController
public class SmtpApiResource implements SmtpApi {

	@Override
	public ResponseEntity<String> sendSmtp(MailRequest mailRequest) {
		if (mailRequest.getAdress() == null) {

		}
		if (mailRequest.getSubject() == null) {

		}
		if (mailRequest.getContent() == null) {

		}
		sendMail(mailRequest.getAdress(), mailRequest.getSubject(), mailRequest.getContent());
		return null;
	}

	/*
	 * mailAdr 收件人地址 subject 邮件标题 content 邮件文本内容
	 */
	public void sendMail(String mailAdr, String subject, String content) {
		// 配置发送邮件的环境属性
		final Properties props = new Properties();
		// 表示SMTP发送邮件，需要进行身份验证
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.qq.com");
		// smtp登陆的账号、密码 ；需开启smtp登陆
		props.put("mail.user", "xxxxxxx@qq.com");
		// 访问SMTP服务时需要提供的密码,不是邮箱登陆密码，一般都有独立smtp的登陆密码
		props.put("mail.password", "xxxxxxxxx");

		// 构建授权信息，用于进行SMTP进行身份验证
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// 用户名、密码
				String userName = props.getProperty("mail.user");
				String password = props.getProperty("mail.password");
				return new PasswordAuthentication(userName, password);
			}
		};

		// 使用环境属性和授权信息，创建邮件会话
		Session mailSession = Session.getInstance(props, authenticator);
		// 创建邮件消息
		MimeMessage message = new MimeMessage(mailSession);
		// 设置发件人
		try {
			InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
			message.setFrom(form);

			// 设置收件人
			InternetAddress to = new InternetAddress(mailAdr);
			message.setRecipient(RecipientType.TO, to);

			// 设置抄送
			// InternetAddress cc = new InternetAddress("luo_aaaaa@yeah.net");
			// message.setRecipient(RecipientType.CC, cc);

			// 设置密送，其他的收件人不能看到密送的邮件地址
			// InternetAddress bcc = new InternetAddress("aaaaa@163.com");
			// message.setRecipient(RecipientType.CC, bcc);

			// 设置邮件标题
			message.setSubject(subject);
			// 设置邮件的内容体
			message.setContent(content, "text/html;charset=UTF-8");
			// 发送邮件
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
