package droolscours;

import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.FactHandle;

import util.KnowledgeSessionHelper;

public class DroolsTest1 {
	StatelessKieSession sessionStateless = null;
	KieSession sessionStatefull = null;
	static  KieContainer kieContainer;
	
	@BeforeClass
	public static void beforeClass() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}
	
	/**
	 * 可以看到这边的规则代码只执行了一次
	 */
	@Test
	public void droolstest1() {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-droolstest1");
		Person person = new Person();
		person.setAge(24);
		FactHandle handle = sessionStatefull.insert(person);
		sessionStatefull.fireAllRules();
		System.out.println("看看执行后的结果是什么"+person.getName());
		person.setAge(18);
		FactHandle handle1 = sessionStatefull.insert(person);
		sessionStatefull.fireAllRules();
		System.out.println("看看执行后的结果是什么"+person.getName());
	}
	
	//通过update可以执行2次
	@Test
	public void droolstest2() {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-droolstest1");
		Person person = new Person();
		person.setAge(24);
		FactHandle handle = sessionStatefull.insert(person);
		sessionStatefull.fireAllRules();
		System.out.println("看看执行后的结果是什么"+person.getName());
		person.setAge(18);
		sessionStatefull.update(handle, person);
		sessionStatefull.fireAllRules();
		System.out.println("看看执行后的结果是什么"+person.getName());
	}
	
	
}
