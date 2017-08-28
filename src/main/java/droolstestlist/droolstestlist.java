package droolstestlist;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.FactHandle;

import droolscours.Person;
import util.KnowledgeSessionHelper;

public class droolstestlist {
	StatelessKieSession sessionStateless = null;
	KieSession sessionStatefull = null;
	static  KieContainer kieContainer;
	
	@BeforeClass
	public static void beforeClass() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}
	
	// 静态方法中的方法也必须是静态的
	@Test
	public void droolstestlist1() {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-droolstestlist");
		List<Person> personList = new ArrayList<Person>();
		for(int i=0; i< 100; i++){
			Person _temp = new Person();
			_temp.setAge(i);
			personList.add(_temp);
		}
		FactHandle handle = sessionStatefull.insert(personList);
		sessionStatefull.fireAllRules();
	}
	
}
