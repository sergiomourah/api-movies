package com.api.awards;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class IntervalAwards {

	private List<Awards> min;

	private List<Awards> max;

	public void setMinList(Awards awardsMin) {
		if (this.min == null) {
			this.min = new ArrayList<>();
		}
		this.min.add(awardsMin);
	}

	public void setMaxList(Awards awardsMax) {
		if (this.max == null) {
			this.max = new ArrayList<>();
		}
		this.max.add(awardsMax);
	}
	
}
