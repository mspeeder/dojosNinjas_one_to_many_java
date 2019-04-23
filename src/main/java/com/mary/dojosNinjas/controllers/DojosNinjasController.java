package com.mary.dojosNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mary.dojosNinjas.models.Dojo;
import com.mary.dojosNinjas.models.Ninja;
import com.mary.dojosNinjas.services.DojoService;
import com.mary.dojosNinjas.services.NinjaService;


@Controller
public class DojosNinjasController {
	private final DojoService dojoService;
	private final NinjaService ninjaServie;
	
	public DojosNinjasController (DojoService dojoService,NinjaService ninjaServie) {
		this.dojoService = dojoService;
		this.ninjaServie = ninjaServie;
				
	}
	
	@RequestMapping("/dojos/new") 
	public String showDojosForm(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojosNinjas/dojos.jsp";
	}
	@RequestMapping(value="/dojos/new", method=RequestMethod.POST) 
	public String getDojoDate(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojosNinjas/dojos.jsp";
		} else {
			dojoService.creatDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	@RequestMapping("/ninjas/new") 
	public String showNinjasForm(Model model,@ModelAttribute("ninja") Ninja ninja) {
		model.addAttribute("dojos", dojoService.allDojo());
		return "/dojosNinjas/ninjas.jsp";
	}
	
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST) 
	public String getDojoDate(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojosNinjas/ninjas.jsp";
		} else {
			ninjaServie.creatDojo(ninja);
			return "redirect:/ninjas/new";
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String showDetail(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		List<Ninja> ninjas = dojo.getNinjas();
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", ninjas);
		return "/dojosNinjas/detail.jsp";
	}

}
