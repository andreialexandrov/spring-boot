package io.andrei.demo.calc;

import java.util.ArrayList;
import java.util.List;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiVerb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(name = "Calc Services", description = "Provides Math services")
@RestController
public class CalcController {
	@ApiMethod(path = "/calc", verb = ApiVerb.GET, description = "Default method, returns empty list")
	@RequestMapping("/calc")
	public List<MathExpression> getCalc() {
		return new ArrayList<MathExpression>();
	}
	
	@ApiMethod(path = "/calc/{expr}", verb = ApiVerb.GET, description = "Return result of evaluation of math expression")
	@RequestMapping("/calc/{expr}")
	public List<MathExpression> getCalc(@ApiPathParam(name = "expr", description = CalcService.DESCR) @PathVariable String expr) {
		List<MathExpression> res = CalcService.calc(expr);
		return res;
	}
}
