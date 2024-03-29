package com.api.producer.service;

import com.api.awards.Awards;
import com.api.awards.IntervalAwards;
import com.api.producer.interfaces.ProducerInterface;
import com.api.producer.repository.ProducerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class ProducerService {

	ProducerRepository producerRepository;
	
	public IntervalAwards getPeriodInterval() {

		List<ProducerInterface> producerInterfaces = this.producerRepository.getAllProducersByWinner();

		List<Awards> awardsList = new ArrayList<>();
		producerInterfaces.forEach(producerInterface -> {
			Awards awards = new Awards();
			awards.setProducer(producerInterface.getName());
			awards.setInterval(producerInterface.getNextYear() - producerInterface.getYear());
			awards.setPreviousWin(producerInterface.getYear());
			awards.setFollowingWin(producerInterface.getNextYear());
			awardsList.add(awards);
		});

		Integer intervalMin = awardsList.stream().min(Comparator.comparing(Awards::getInterval)).get().getInterval();

		Integer intervalMax = awardsList.stream().max(Comparator.comparing(Awards::getInterval)).get().getInterval();

		IntervalAwards intervalAwards = new IntervalAwards();
		awardsList.stream().filter(p-> p.getInterval() == intervalMax).forEach(awardsMax-> {
			intervalAwards.setMaxList(awardsMax);
		});

		awardsList.stream().filter(p-> p.getInterval() == intervalMin).forEach(awardsMax-> {
			intervalAwards.setMinList(awardsMax);
		});

		return intervalAwards;
		
	}
}
