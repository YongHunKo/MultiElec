package com.multi.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CartDTO;
import com.multi.service.CartService;

@Controller
public class CartController {

	@Autowired
	CartService cart_service;

	
	@RequestMapping("/cart")
	public String cart(Model model, String id) {
		List<CartDTO> list = null;
		try {
			list = cart_service.cartall(id);
			model.addAttribute("mycart",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", "cart");
		return "index";
	
	}
	
	@RequestMapping("/deletecart")
	public String deletecart(Model model, int id, String custid) {
		try {
			cart_service.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:cart?id="+custid;
	}
}




	