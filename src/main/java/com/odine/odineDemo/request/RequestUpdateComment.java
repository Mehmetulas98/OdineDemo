package com.odine.odineDemo.request;

 
 

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateComment extends RequestCreateComment {
	private Long id;
 
}
