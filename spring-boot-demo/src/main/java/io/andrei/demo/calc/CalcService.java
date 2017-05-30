package io.andrei.demo.calc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalcService {
	
	public static final String DESCR = "Math expression for evaluation. Supported operations and functions: "
			+ "+, -, :, %, *, ^, abs, acos, asin, atan, cbrt, ceil, cos, cosh, exp, floor, log, log2, log10, sin, sinh, sqrt, tan, tanh, signum. "
			+ "Example: expr=(1+2+3+4)^(sin(pi:12)^2 + cos(pi:12)^2), result=10";
	
	public static List<MathExpression> calc(String expr) {
		double result = 0;
		List<MathExpression> res = new ArrayList<>();
		try {
		Expression e = new ExpressionBuilder(expr.replace(':', '/').replace(',','.')).build();
		result = e.evaluate();
		} catch (Exception e) {
			expr = expr + "- ERROR: " + e;
			// write to log 
		}
		res.add(new MathExpression(expr,result));
		return res;		
	}
}
