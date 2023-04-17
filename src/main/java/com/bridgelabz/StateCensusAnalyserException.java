package com.bridgelabz;

public class StateCensusAnalyserException extends Exception {
	enum ExceptionType {
		CENSUS_FILE_PROBLEM
	}
	ExceptionType type;

	public StateCensusAnalyserException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}

	public StateCensusAnalyserException(String message, ExceptionType type, Throwable cause) {
		super(message, cause);
		this.type = type;
	}
}
