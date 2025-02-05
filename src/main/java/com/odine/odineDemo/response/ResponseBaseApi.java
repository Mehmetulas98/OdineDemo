package com.odine.odineDemo.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBaseApi implements Serializable {
	private boolean isSuccess;
	private String errorMessage;

}
