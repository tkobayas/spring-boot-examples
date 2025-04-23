package com.example.demo.rule.facade;

import java.net.URL;

import com.example.Person;
import com.example.PersonUnit;
import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.drools.ruleunits.api.conf.ClockType;
import org.drools.ruleunits.api.conf.RuleConfig;
import org.kie.api.time.SessionClock;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Component
public class RuleFacade {

	public void executeRule(Person person) {
		PersonUnit unit = new PersonUnit();
		unit.getPersons().add(person);

		URL url = PersonUnit.class.getClassLoader().getResource("com/example/PersonUnit.class");

		System.out.println("URL: " + url);
		System.out.println("URL.getPath(): " + url.getPath());

		try ( RuleUnitInstance<PersonUnit> unitInstance = RuleUnitProvider.get().createRuleUnitInstance(unit) ) {
			unitInstance.fire();
		}
	}
}
