/**
 * 
 */
package org.wupf.p8a.pmd.lang.java.rule.naming;

import com.alibaba.p3c.pmd.I18nResources;
import com.alibaba.p3c.pmd.lang.AbstractXpathRule;
import com.alibaba.p3c.pmd.lang.java.util.ViolationUtils;

import net.sourceforge.pmd.lang.ast.Node;

/**
 * @author wupf
 *
 */
public class DontUseSqlCmd extends AbstractXpathRule {

	private static final String MESSAGE_KEY_PREFIX = "java.naming.DontUseSqlCmd.violation.msg";

	private static final String XPATH = "//PrimaryPrefix/Literal[@Image='\"select \"']"
			+ "|//PrimaryPrefix/Literal[@Image='\"update \"']" + "|//PrimaryPrefix/Literal[@Image='\"delete \"']"
			+ "|//PrimaryPrefix/Literal[@Image='\"truncate \"']" + "|//PrimaryPrefix/Literal[@Image='\"drop \"']"
			+ "|//PrimaryPrefix/Literal[@Image='\"alter \"']";

	public DontUseSqlCmd() {
		setXPath(XPATH);
	}

	@Override
	public void addViolation(Object data, Node node, String arg) {

		ViolationUtils.addViolationWithPrecisePosition(this, node, data, I18nResources.getMessage(MESSAGE_KEY_PREFIX));
	}
}
