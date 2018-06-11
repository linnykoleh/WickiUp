package com.linnyk.wickiup.spring.metrics.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.metrics.dropwizard.DropwizardMetricServices;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyLongService {

	@Qualifier("dropwizardMetricServices")
	@Autowired
	private DropwizardMetricServices gauges;

	@Scheduled(fixedDelay = 5000)
	public void doSomeLongRequest(){
		this.gauges.submit("timer.test.value.linnyk", 999);
	}
}
