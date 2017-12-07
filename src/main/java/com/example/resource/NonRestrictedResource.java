package com.example.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class NonRestrictedResource {
	@GetMapping
	public List<Service> list() {
		return Arrays.asList(new Service("Restricted Content", 786.0),
				new Service("one more Restricted Content", 0.786));
	}

	public static class Service {

		private String name;
		private double value;

		public Service(String name, double value) {
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}

	}
}
