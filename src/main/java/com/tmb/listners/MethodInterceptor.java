package com.tmb.listners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.tmb.utils.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		List<Map<String, String>> list = null;
		try {
			list = ExcelUtils.getTestDetails("RUNMANAGER");
		} catch (Exception e) {

			e.printStackTrace();
		}

		List<IMethodInstance> result = new ArrayList<>();

		for (int i = 0; i < methods.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				System.out.println(methods.get(i).getMethod().getMethodName());
				if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname"))
						&& list.get(j).get("execute").equalsIgnoreCase("yes")) {

					result.add(methods.get(i));

				}

			}
		}

		return result;
	}

}
