package com.example.sbjasperangular.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRCsvDataSource;



@Component
public class ApiBrmService {
	final static Logger logger = Logger.getLogger(ApiBrmService.class);

	public void generateReportForGet() throws JRException {
		Map<String, Object> parameters = new HashMap<>();
	    JRCsvDataSource dataSource = new JRCsvDataSource(ApiBrmService.class.getResourceAsStream("data/brm.csv"));
	    dataSource.setUseFirstRowAsHeader(true);
	    try (InputStream template = ApiBrmService.class.getResourceAsStream("static/jasper/brm.jrxml")) {
	      JasperReport report = JasperCompileManager.compileReport(template);
	      JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, dataSource);
	      JasperExportManager.exportReportToPdfFile(jasperPrint, "static/jasper/brm.pdf");
	    } catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {

	}
}
