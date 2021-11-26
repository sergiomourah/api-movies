package com.api.awards;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Awards {

	private String producer;
	private int interval;
	private int previousWin;
	private int followingWin;
}