package io.andrei.demo.calc;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@ApiObject
public class MathExpression {
	
	@ApiObjectField(description = "Math expression")
	private String expr;
	
	@ApiObjectField(description = "Result of evaluation of math expression")
	private Double result;
	
	public MathExpression(){}
	
	public MathExpression(String expr, Double result) {
		this.expr = expr;
		this.result = result;
	}

	public String getExpr() {
		return expr;
	}

	public void setExpr(String expr) {
		this.expr = expr;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	};
}
