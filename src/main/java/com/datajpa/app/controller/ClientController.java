package com.datajpa.app.controller;

import com.datajpa.app.models.entity.Client;
import com.datajpa.app.models.service.IClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ClientController {

    @Autowired
    private IClientService clientService;
    @RequestMapping(value = "/listar",method = RequestMethod.GET)
    public String listClients(Model model){
        model.addAttribute("title","List of Clients");
        model.addAttribute("clients", clientService.findAll());
        return "listar.html";
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String createClient(Map<String, Object> model){

        Client client = new Client();
        model.put("client",client);
        model.put("title","Create client");
        model.put("buttonSubmit","Create");
        return "form";
    }

    @RequestMapping(value = "/form",method = RequestMethod.POST)
    public String saveClient(@Valid Client client, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("title", "Create client");
            return "form";
        }
       clientService.save(client);
        return "redirect:listar";
    }

    @RequestMapping(value = "/form/{id}",method = RequestMethod.GET)
    public String editClient(@PathVariable(value = "id") Long id, Map<String, Object> model){

        Client client = null;
        if(id > 0){
            client = clientService.findOne(id);
        }else{
            return "redirect:listar";
        }
        model.put("client", client);
        model.put("title", "Edit Client");
        model.put("buttonSubmit","Edit");
        return "form";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteClient(@PathVariable(value = "id") Long id, Map<String, Object> model){

        if(id > 0) {
            clientService.delete(id);
        }
        return "redirect:/listar";

    }



}
