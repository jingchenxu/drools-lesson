package util;

import org.drools.core.event.AgendaGroupPoppedEvent;
import org.drools.core.event.AgendaGroupPushedEvent;
import org.drools.core.event.RuleFlowGroupActivatedEvent;
import org.drools.core.event.RuleFlowGroupDeactivatedEvent;
import org.kie.api.KieServices;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

public class KnowledgeSessionHelper {
	/**
	 * @description 创建一个填装规则的方法
	 * @return
	 */
	public static KieContainer createRuleBase() {
		
		KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
	    return kieContainer;
	}
	
	/**
	 * @description 创建一个无状态的与规则引擎交互的session
	 * StateFul 和 StateLess 的区别在于 Stateful 是可以完成推理的，即一条规则可以导致另一条规则的触发
	 * 所以也需要显示的调用下FireRules() 而StateLess是不支持规则推理的，所以规则自动触发
	 * @param kieContainer
	 * @param sessionName
	 * @return
	 */
	public static StatelessKieSession getStatelessKnowledgeSession(KieContainer kieContainer, String sessionName) {
		StatelessKieSession kSession = kieContainer.newStatelessKieSession(sessionName);
		
		return kSession;
	}
	
	/**
	 * @description 创建一个有状态的与规则引擎交互的session
	 * @param kieContainer
	 * @param sessionName
	 * @return
	 */
	public static KieSession getStatefulKnowledgeSession(KieContainer kieContainer, String sessionName) {
		KieSession kSession = kieContainer.newKieSession(sessionName);
		
		return kSession;
	}
	
	public static KieSession getStatefulKnowledgeSessionWithCallback(KieContainer kieContainer, String sessionName) {
		KieSession session = getStatefulKnowledgeSession(kieContainer, sessionName);
		session.addEventListener(new RuleRuntimeEventListener() {

			@Override
			public void objectDeleted(ObjectDeletedEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Object retracted \n"
						+ "new Content \n" + arg0.getOldObject().toString());
			}

			@Override
			public void objectInserted(ObjectInsertedEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Object inserted \n"
						+ arg0.getObject().toString());
			}

			@Override
			public void objectUpdated(ObjectUpdatedEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Object was updated \n"
						+ "new Content \n" + arg0.getOldObject().toString());
			}
			
		});
		
        session.addEventListener(new AgendaEventListener() {
            public void matchCreated(MatchCreatedEvent event) {
                System.out.println("The rule "
                        + event.getMatch().getRule().getName()
                        + " can be fired in agenda");
            }
            public void matchCancelled(MatchCancelledEvent event) {
                System.out.println("The rule "
                        + event.getMatch().getRule().getName()
                        + " cannot b in agenda");
            }
            public void beforeMatchFired(BeforeMatchFiredEvent event) {
                System.out.println("The rule "
                        + event.getMatch().getRule().getName()
                        + " will be fired");
            }
            public void afterMatchFired(AfterMatchFiredEvent event) {
                System.out.println("The rule "
                        + event.getMatch().getRule().getName()
                        + " has be fired");
            }
			@Override
			public void afterRuleFlowGroupActivated(org.kie.api.event.rule.RuleFlowGroupActivatedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void afterRuleFlowGroupDeactivated(org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void agendaGroupPopped(org.kie.api.event.rule.AgendaGroupPoppedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void agendaGroupPushed(org.kie.api.event.rule.AgendaGroupPushedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void beforeRuleFlowGroupActivated(org.kie.api.event.rule.RuleFlowGroupActivatedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void beforeRuleFlowGroupDeactivated(org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        });
        
        return session;
	}
	
}
