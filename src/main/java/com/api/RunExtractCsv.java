package com.api;

import com.api.extract.extractCsv;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class RunExtractCsv {

	private extractCsv extractCsv;
	
	@PostConstruct
	public void run() {
		this.extractCsv.run();
	}
}
