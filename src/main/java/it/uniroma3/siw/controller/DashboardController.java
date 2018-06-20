package it.uniroma3.siw.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.siw.model.Responsabile;

@Controller
public class DashboardController
{
	@RequestMapping("dashboard")
	public String dashboard(HttpSession session)
	{
		Responsabile resp = (Responsabile)session.getAttribute("responsabileCorrente");
		if(resp.getRole().contains("ROLE_USER"))
			return "user/dashboard";
		else if(resp.getRole().contains("ROLE_ADMIN"))
			return "admin/dashboard";
		return "user/dashboard";
	}
}
