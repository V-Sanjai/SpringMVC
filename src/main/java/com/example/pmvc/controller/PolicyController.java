package com.example.pmvc.controller;

import com.example.pmvc.entity.Coverage;
import com.example.pmvc.entity.Policy;
import com.example.pmvc.service.PolicyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class PolicyController {
    @Autowired
    PolicyServiceImpl policyService;

    @GetMapping("demo")
    public String demo() {
        return "home";
    }


    @GetMapping("insertpolicy")
    public String insert(Model model) {
        model.addAttribute("policy", new Policy());
        model.addAttribute("coverage", policyService.findall());
        return "add-policy";
    }

    @PostMapping("submit")
    public String submit(@ModelAttribute("policy") Policy policy, @RequestParam("coverage") List<Integer> idd) {
        List<Coverage> list = new ArrayList<>();
        for (Integer coverageid : idd) {
            Coverage coverage = policyService.findbyid(coverageid);
            list.add(coverage);
        }
        policy.setCoverages(list);
        policyService.insert(policy);
        return "redirect:/demo";
    }

    @GetMapping("edit")
    public String update(@ModelAttribute("policy") Policy policy, @RequestParam("coverage") List<Integer> idd,Model model) {
        List<Coverage> list = new ArrayList<>();
        for (Integer coverageid : idd) {
            Coverage coverage = policyService.findbyid(coverageid);
            list.add(coverage);
        }
        policy.setCoverages(list);
        policyService.update(policy);
        List<Policy> policies = policyService.findpolicy();
        model.addAttribute("list", policies);
        return "list";
    }





    @GetMapping("list")
    public String list(Model model) {
        List<Policy> policies = policyService.findpolicy();
        model.addAttribute("list", policies);
        return "list";
    }

    @GetMapping("updateby/{id}")
    public String updatebyid(@PathVariable int id,Model model){
       Policy policy= policyService.findid(id);
       model.addAttribute("policy",policy);
       model.addAttribute("coverage",policyService.findall());
       return "update";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        policyService.delete(id);
        List<Policy>list=policyService.findpolicy();
        model.addAttribute("list",list);
        return "list";
    }
}