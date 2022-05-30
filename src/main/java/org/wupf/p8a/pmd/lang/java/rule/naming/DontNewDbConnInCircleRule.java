/*
 * Copyright 1999-2017 wupingfu .
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wupf.p8a.pmd.lang.java.rule.naming;

import com.alibaba.p3c.pmd.I18nResources;
import com.alibaba.p3c.pmd.lang.AbstractXpathRule;
import com.alibaba.p3c.pmd.lang.java.util.ViolationUtils;

import net.sourceforge.pmd.lang.ast.Node;

/**
 * @author 421722623@qq.com
 * @date 2018/11/13
 */
public class DontNewDbConnInCircleRule extends AbstractXpathRule {

	private static final String MESSAGE_KEY_PREFIX = "java.naming.DontNewDbConnInCircleRule.violation.msg";

	private static final String XPATH = "//ForStatement/Statement/Block/BlockStatement/Statement/StatementExpression/PrimaryExpression"
			+ "[PrimaryPrefix/Name[@Image='ServiceManager.getSession']]"
			+ "[PrimarySuffix[@Image='getConnection'] or PrimarySuffix[@Image='getNewConnection']]"
			+ "|//ForStatement/Statement/Block/BlockStatement/LocalVariableDeclaration/VariableDeclarator/VariableInitializer/Expression/PrimaryExpression"
			+ "[PrimaryPrefix/Name[@Image='ServiceManager.getSession']]" + "[PrimarySuffix[@Image='getConnection']]"
			+ "|//ForStatement/Statement/Block/BlockStatement/LocalVariableDeclaration"
			+ "[Type/ReferenceType/ClassOrInterfaceType[@Image='DBConnection']]"
			+ "[VariableDeclarator/VariableInitializer/Expression/PrimaryExpression/PrimaryPrefix/AllocationExpression/ClassOrInterfaceType[@Image='DBConnection']]"
			+ "|//ForStatement/Statement/Block/BlockStatement/LocalVariableDeclaration"
			+ "/VariableDeclarator/VariableInitializer/Expression/PrimaryExpression/PrimaryPrefix/Name[@Image='DBUtil.getJdbcTemplate']";

	public DontNewDbConnInCircleRule() {
		setXPath(XPATH);
	}

	@Override
	public void addViolation(Object data, Node node, String arg) {

		ViolationUtils.addViolationWithPrecisePosition(this, node, data, I18nResources.getMessage(MESSAGE_KEY_PREFIX));
	}

}
