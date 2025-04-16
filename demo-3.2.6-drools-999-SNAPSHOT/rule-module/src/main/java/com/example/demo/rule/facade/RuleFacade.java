package com.example.demo.rule.facade;

import com.example.Person;
import jakarta.annotation.PostConstruct;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Component
public class RuleFacade {

	private KieContainer kieContainer;

	@PostConstruct
	public void initializeRules() {
		KieServices kieServices = KieServices.Factory.get();
		kieContainer = kieServices.getKieClasspathContainer();
		System.out.println("RuleFacade initialized : " + kieContainer);
	}

	public void executeRule(Person person) {
		KieSession kieSession = kieContainer.newKieSession();
		try {
			kieSession.insert(person);
			kieSession.fireAllRules();
		} finally {
			kieSession.dispose();
		}
	}
}
