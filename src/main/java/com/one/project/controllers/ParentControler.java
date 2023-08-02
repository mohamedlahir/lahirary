package com.one.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one.project.models.ParentModel;
import com.one.project.service.ParentService;

@RestController
public class ParentControler {

	@Autowired
	ParentService parentService;

	@RequestMapping("/get-parent-controller")
	public List<ParentModel> getParent() {
		return parentService.getParent();
	}

	@RequestMapping("/saveparent")
	public ParentModel save(@RequestBody ParentModel parent) {
		return parentService.save(parent);
	}
}
