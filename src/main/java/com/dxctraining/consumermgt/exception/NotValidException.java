package com.dxctraining.consumermgt.exception;

public class NotValidException extends RuntimeException{
	public NotValidException(String alert) {
		super(alert);
	}

}
