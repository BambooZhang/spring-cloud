package org.spring.springboot.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.springboot.dubbo.BambooDubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // http://localhost:7071/city/find
public class CityController {
	private Log logger = LogFactory.getLog( CityController.class );

	@Autowired
	BambooDubboService bambooDubboService;

	/**
	 * 根据资源名查找资源
	 */
	@GetMapping( "/" )
	public String find( Model model, String name ) {

		return bambooDubboService.sayBamboo(name);
	}


}