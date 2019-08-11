package com.springboot.api;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.model.MailRequest;
import com.springboot.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @ClassName: UserApi
 * @Function: TODO
 * @Description: TODO
 * @date: 2018年7月10日 下午1:31:10
 * 
 * @author liubin
 * @email aguai_liu@163.com
 * @version
 * @since JDK 1.8
 */

@Api(value = "smtp", description = "the smtp API")
@RequestMapping(value = { "/api/v1/" })
public interface SmtpApi {

	@RequestMapping(value = "/smtp", produces = { "application/json", "application/xml" }, method = RequestMethod.GET)
	@ApiOperation(value = "发送邮件", notes = "返回所有用户信息", tags = { "smtp" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation", response = String.class),
			@ApiResponse(code = 400, message = "Invalid ID supplied"), @ApiResponse(code = 404, message = "User not found") })
	ResponseEntity<String> sendSmtp(@ApiParam(required=true) MailRequest mailRequest);



}
