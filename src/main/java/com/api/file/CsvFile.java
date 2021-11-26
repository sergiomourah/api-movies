package com.api.file;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CsvFile {

	@CsvBindByPosition(position = 0)
	private int year;
	
	@CsvBindByPosition(position = 1)
	private String title;
	
	@CsvBindByPosition(position = 2)
	private String studios;
	
	@CsvBindByPosition(position = 3)
	private String producers;
	
	@CsvBindByPosition(position = 4)
	private boolean winner;
}