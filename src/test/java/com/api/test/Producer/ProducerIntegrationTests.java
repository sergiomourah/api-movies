package com.api.test.Producer;

import com.api.awards.Awards;
import com.api.awards.IntervalAwards;
import com.api.producer.service.ProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProducerIntegrationTests {

	@Autowired
	ProducerService producerService;
	
	@Test
	void validateReturnMaxByPeriodInterval() {
		IntervalAwards intervalsAwards = producerService.getPeriodInterval();
		assertThat(intervalsAwards).isNotNull();

		Awards intervalMax = intervalsAwards.getMax().iterator().next();
		assertThat(intervalMax).isNotNull();
		assertThat(intervalMax.getProducer()).isNotNull();
		assertThat(intervalMax.getInterval() >= 1).isTrue();
	}

	@Test
	void validateReturnMixByPeriodInterval() {
		IntervalAwards intervalsAwards = producerService.getPeriodInterval();
		assertThat(intervalsAwards).isNotNull();
		assertThat(intervalsAwards.getMax()).isNotEmpty();

		Awards intervalMin = intervalsAwards.getMin().iterator().next();
		assertThat(intervalMin).isNotNull();
		assertThat(intervalMin.getProducer()).isNotNull();
		assertThat(intervalMin.getInterval() >= 1).isTrue();
	}
}
