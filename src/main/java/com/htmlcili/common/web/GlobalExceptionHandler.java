package com.htmlcili.common.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.htmlcili.common.vo.JsonResult;
/**
 * 加了ControllerAdvice注解后可处理全局项目的异常
 * @author Administrator
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {	
	
	/**
	 *
	 * @param e
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult doHandleRuntimeException(RuntimeException e) {
		e.printStackTrace();
		return new JsonResult(e);
		
	}
}
