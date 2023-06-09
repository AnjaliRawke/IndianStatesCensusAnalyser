package com.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
	public int loadIndiaCensusData(String csvFilePath) throws StateCensusAnalyserException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVStateCensus.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();
			Iterator<CSVStateCensus> censusCSVIterator = csvToBean.iterator();;
			int namOfEateries = 0;
			while (censusCSVIterator.hasNext()) {
				namOfEateries++;
				CSVStateCensus censusData = censusCSVIterator.next();
			}
			return namOfEateries;
		} catch (IOException e) {
			throw new StateCensusAnalyserException(e.getMessage(),
					StateCensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}
}
