package com.w2m.service.loggin;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NegativeIdLoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(NegativeIdLoggingAspect.class);

	@Pointcut("execution(* com.w2m.service.use_case.SearchSpacecraft.searchSpacecraftById(..)) && args(id)")
	public void negativeIdPointcut(Long id) {
	}

	@AfterThrowing(pointcut = "negativeIdPointcut(id)", throwing = "ex")
	public void logNegativeId(Long id, Exception ex) {
		if ((id != null) && (id < 0)) {
			LOGGER.error("Se intentó buscar una nave con ID negativo: {}", id);
		}
	}
}
