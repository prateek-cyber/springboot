package com.springrest.springrest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

//import io.micrometer.core.instrument.Counter;
import io.prometheus.client.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
@ManagedResource(objectName = "PMbeans:category=Mbeans,name = testbean")
@RestController
public class MyAspect {
	
	static final Counter count_total = Counter.build()
			.name("Total_requests")
			.help("Totalrequests")
			.register();

	
//	public MyAspect(MeterRegistry registry) {
//		count_total=registry.counter("total_hits"); 
//	}
	@Pointcut("execution(* com.springrest.springrest.controller.*.*(..))")
    public void loggingPointCut() {}
	

	@AfterReturning("loggingPointCut()")
	public void after(JoinPoint joinpoint) {
//		count.increment();
		   count_total.inc();
		System.out.println("Get method called");
		
		
	}
//	@ManagedOperation
//    public String getTotalHits() throws InterruptedException {
//        return "Total Hits = " + count_total.get();
//    }
}
