package com.how2java.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;

// 鍛婅瘔spring mvc杩欐槸涓�涓帶鍒跺櫒绫�
@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping("listCategory")
	public ModelAndView listCategory(){
		ModelAndView mav = new ModelAndView();
		List<Category> cs= categoryService.list();
		
		// 鏀惧叆杞彂鍙傛暟
		mav.addObject("cs", cs);
		// 鏀惧叆jsp璺緞
		mav.setViewName("jsp/listCategory");
		return mav;
	}

	@RequestMapping("form")
	public ModelAndView form(){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("jsp/form");
		return mav;
	}
	
	@RequestMapping("console")
	public ModelAndView console(){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("jsp/console");
		return mav;
	}

	@RequestMapping("layui")
	public ModelAndView layui(){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("jsp/layui");
		return mav;
	}
	
	@RequestMapping("tree")
	public ModelAndView tree(){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("jsp/tree");
		return mav;
	}
}
