package gradle_spring_aop_study.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CacheAspect {
	private Map<Long, Object> cache = new HashMap<>();
	
	/*
	 * @Pointcut("execution(public *gradle_spring_aop_study.aop03..*(long ))")
	 * public void cacheTarget() {}
	 */	
	@Around("CommonPointcut.commonTarget()")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
		Long num = (Long) joinPoint.getArgs()[0];
		if(cache.containsKey(num)) {
			System.out.printf("CacheAspect : Cache에서 구함[%d]%n",num);
			return cache.get(num);
		}
		
		Object result = joinPoint.proceed();
		cache.put(num, result);
		System.out.printf("CacheAspect : Cache에서 구함[%d]%n", num);
		return null;
	}
}
