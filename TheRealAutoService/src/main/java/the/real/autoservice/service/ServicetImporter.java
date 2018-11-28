package the.real.autoservice.service;



import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Conditional;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.introspect.AnnotationCollector.TwoAnnotations;

import the.real.autoservice.dao.ServiceJPARepository;
import the.real.autoservice.entity.AutoServices;

@Component
public class ServicetImporter {


	private final RestTemplate restTemplate;
	private ServiceJPARepository rep;

	public ServicetImporter(RestTemplate restTemplate, ServiceJPARepository rep) {
		this.restTemplate = restTemplate;
		this.rep = rep;

	}
	//reikia padaryt kad updatinu o ne pridetu
//	@Scheduled(cron = "0 0 12 * * *")  updating everyday at midnight 
//	@Scheduled(cron = "0 0 23 * * *")  updating everyday at midnight for Quartz configuration
	@Scheduled(cron = "*/10 * * * * *")  
	public void importServices() {
		System.out.println("=================================work?===========================================");
		ParameterizedTypeReference<List<AutoServices>> typeRef = new ParameterizedTypeReference<List<AutoServices>>() {};
		HttpHeaders heads = new HttpHeaders();
		ResponseEntity<List<AutoServices>> result = restTemplate.exchange("http://localhost:8082/services",
				HttpMethod.GET, new HttpEntity(heads), typeRef);
		List<AutoServices> microService = result.getBody();
		System.out.println(rep.findAll());
		System.out.println("============+++++=================");
		
//		List<AutoServices> xxxxx = rep.findAll().stream()
//				.filter( e -> microService.stream().map(AutoServices::getPrice)
//						.anyMatch(p -> p == e.getPrice() ) ).collect(Collectors.toList());
		
		
		if(rep.findAll().equals(microService)) {

			System.out.println("if");
		} else {
			System.out.println("else");
//			xxxxx.forEach(System.out::println);
		}
//		rep.deleteAll();
//		rep.saveAll(microService);
	}


	
}
