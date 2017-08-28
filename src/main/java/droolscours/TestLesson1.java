package droolscours;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.FactHandle;

import util.KnowledgeSessionHelper;
import util.OutputDisplay;

public class TestLesson1 {
	/**
	 * Kiesession主要适用于与规则引擎进行交互的会话
	 */
	// 无状态的session
	StatelessKieSession sessionStateless = null;
	// 有状态的session
	KieSession sessionStatefull = null;
	// 规则容器
	static KieContainer kieContainer;
	
	// 测试类初始化前先创建规则容器
	@BeforeClass
	public static void beforeClass() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}
	
	// 测试方法执行前调用
	@Before
	public void setUp() throws Exception{
		System.out.println("------------------Before------------------");
	}
	
	// 一个测试类中可以定义多个测试方法执行前方法，先定义的方法先执行
	@Before
	public void beforeFun() throws Exception{
		System.out.println("beforefun");
	}
	
	// 测试方法执行后调用
	@After
	public void tearDown() throws Exception{
		System.out.println("------------------Before-------------------");
	}
	
	@Test
	public void testFirstOne() {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		OutputDisplay outputDisplay = new OutputDisplay();
		sessionStatefull.setGlobal("showResults", outputDisplay);
		Account a = new Account();
		sessionStatefull.insert(a);
		sessionStatefull.fireAllRules();
	}
	
	@Test
	public void testRuleOneFactWithFactAndUsageOfGlobalAndCallBack() {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		sessionStatefull.addEventListener(new RuleRuntimeEventListener() {

			@Override
			public void objectDeleted(ObjectDeletedEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Object retracted \n" + event.getOldObject().toString());
			}

			@Override
			public void objectInserted(ObjectInsertedEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Object inserted \n" + event.getObject().toString());
			}

			@Override
			public void objectUpdated(ObjectUpdatedEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Object was updated \n" + event.getObject().toString());
			}
			
		});
		Account a = new Account();
		a.setAccountno(10);
		FactHandle handlea = sessionStatefull.insert(a);
		a.setBalance(12.0);
		sessionStatefull.update(handlea, a);
		sessionStatefull.delete(handlea);
		sessionStatefull.fireAllRules();
		System.out.println("So you saw something ;)");
	}
	
	/**
	 * @description 测试一下如果连续调用规则测试，内部是如何执行的呢
	 * 我们必须要告诉Drools对象发生了变化，他才会再次执行规则
	 * 
	 * 当规则被执行的时候发生了什么呢
	 * 1、 drools会查看所有的规则，并且放到一个TODO列表当中
	 * 2、 drools会执行放在列表顶端的规则
	 * 3、 一旦规则被执行过了，该规则就是失效了
	 * 4、 你需要告诉drools需要进行规则过滤的对象已经发生了改变，才能避免第三种情况
	 */
	@Test
	public void testFirstOneTwoFireAllRules() {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		OutputDisplay outputDisplay = new OutputDisplay();
		sessionStatefull.setGlobal("showResults", outputDisplay);
		Account a = new Account();
		/**
		 * FactHandle 是象征着你插入WorkingMemory中的对象
		 * 也是当你希望从Working Memory中删除或修改一个对象时所必须的
		 */
		FactHandle handle = sessionStatefull.insert(a);
		System.out.println("First fire all rules");
		sessionStatefull.fireAllRules();
		sessionStatefull.update(handle, a);
		System.out.println("Second fire all rules");
		sessionStatefull.fireAllRules();
	}
	
	@Test
	public void testRuleOneFactThatInsertObject() {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		OutputDisplay display = new OutputDisplay();
		sessionStatefull.setGlobal("showResults", display);
		
		sessionStatefull.addEventListener(new RuleRuntimeEventListener() {

			@Override
			public void objectDeleted(ObjectDeletedEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Object retracted \n" + arg0.getOldObject().toString());
			}

			@Override
			public void objectInserted(ObjectInsertedEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Object inserted \n" + arg0.getObject().toString());
			}

			@Override
			public void objectUpdated(ObjectUpdatedEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Object was updated \n" + arg0.getObject().toString());
			}
			
		});
		CashFlow a = new CashFlow();
		FactHandle handlea = sessionStatefull.insert(a);
		// 注意在将需要规则引擎处理的对象插入后，再开始执行规则引擎
		sessionStatefull.fireAllRules();
	}
	
	@Test
	public void testquery(){
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		/**
		 * 如果在规则文件当中定义了全局变量，那么在此处一定要声明一个全局变量
		 */
		OutputDisplay display = new OutputDisplay();
		sessionStatefull.setGlobal("showResults", display);
		Account a = new Account();
		a.setAccountno(10);
		// a是穿进去的对象 术语为Fact对象 他就是一个普通的Java bean
		FactHandle handle = sessionStatefull.insert(a);
		System.out.println("First fire all rules");
		sessionStatefull.fireAllRules();
		sessionStatefull.dispose();
	}

}
