package com.tca.util;

public interface MyAppUtil 
{
	String BASE_URL = "http://localhost:8081";
	String GET_EMP_URL=BASE_URL+"/employee/{id}";
	String ADD_EMP_URL=BASE_URL+"/add";
	String PARTIAL_UPDATE=BASE_URL+"/update/{id}";
}
