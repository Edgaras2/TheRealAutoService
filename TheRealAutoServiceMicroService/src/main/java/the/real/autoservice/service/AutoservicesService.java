package the.real.autoservice.service;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import the.real.autoservice.entity.AutoServices;

@Service
public class AutoservicesService {

	private Resource serviceResource = new ClassPathResource("/static/AutoServices.json");

	private ObjectMapper mapper;

	public AutoservicesService(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	public List<AutoServices> loadServicesFromJson() throws IOException {
		TypeReference<List<AutoServices>> typeRef = new TypeReference<List<AutoServices>>() {
		};

		return mapper.readValue(serviceResource.getInputStream(), typeRef);
	}
}
