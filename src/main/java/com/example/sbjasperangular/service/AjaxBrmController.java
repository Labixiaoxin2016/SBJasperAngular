package com.example.sbjasperangular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;



@RestController
@RequestMapping("/ajax/brm")
public class AjaxBrmController {
    @Autowired
    private ApiBrmService apiService;

    @Secured({ "ROLE_demo" })
    @RequestMapping(method = RequestMethod.GET)
    public String generateReport() throws JRException {
	apiService.generateReportForGet();
	return "";
    }

}
