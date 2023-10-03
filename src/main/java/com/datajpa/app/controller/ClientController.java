package com.datajpa.app.controller;

import com.datajpa.app.models.dao.IClientDao;
import com.datajpa.app.models.entity.Client;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.Binding;
import java.util.Map;

@Controller
public class ClientController {

    @Autowired
    private IClientDao clientDao;
    @RequestMapping(value = "/listar",method = RequestMethod.GET)
    public String listClients(Model model){
        model.addAttribute("title","List of Clients");
        model.addAttribute("clients", clientDao.findAll());
        return "listar.html";
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String createClient(Map<String, Object> model){

        Client client = new Client();
        model.put("client",client);
        model.put("title","Create client");
        return "form";
    }

    @RequestMapping(value = "/form",method = RequestMethod.POST)
    public String saveClient(@Valid Client client, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("title", "Create client");
            return "form";
        }
       clientDao.save(client);
        return "redirect:listar";
    }

}
