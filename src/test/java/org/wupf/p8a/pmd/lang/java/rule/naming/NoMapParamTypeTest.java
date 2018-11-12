/**
 * 
 */
package org.wupf.p8a.pmd.lang.java.rule.naming;

import net.sourceforge.pmd.testframework.SimpleAggregatorTst;

/**
 * @author wupf
 *
 */
public class NoMapParamTypeTest extends SimpleAggregatorTst {
	public static final String RULESET = "java-ali-naming";

	@Override
	public void setUp() {
		// addRule("java-ali-other", "AvoidApacheBeanUtilsCopyRule");
		addRule(RULESET, "NoMapParamType");
	}

}
