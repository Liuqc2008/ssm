package com.how2java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.how2java.pojo.Category;
import com.how2java.pojo.PageData;
import com.how2java.service.CategoryService;

@Controller
@RequestMapping("Common")
public class commoncontroller {
	@Autowired
	CategoryService categoryService;

	@RequestMapping("/CategoryList")
	@ResponseBody
	public Object peopleSelect() {
		PageData pageData = new PageData();
		List<Category> cs= categoryService.list();
		
		pageData.setData(cs);
		pageData.setCount(cs.size());
		
		return pageData;
	}
}
