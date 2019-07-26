package org.spring.springboot.dubbo.impl;

import org.spring.springboot.dubbo.BambooDubboService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *客户端接口服务层实现层
 */
@Service
public class BambooDubboServiceImpl implements BambooDubboService {

	@Override
	public String sayBamboo(String cityName) {

		if(StringUtils.isEmpty(cityName))
			cityName = "hello dubbo";
		return "bamboo say : "+cityName;
	}
}