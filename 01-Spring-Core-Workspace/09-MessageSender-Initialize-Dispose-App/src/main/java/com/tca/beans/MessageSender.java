package com.tca.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageSender implements InitializingBean,DisposableBean
{
	private String serverIp;
	private int serverPort;
	
	
	
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception 
	{
		System.out.println("Afterproperties : Initializing MessageSender : ServerIP :["+serverIp+"] Port : ["+serverPort+"]");
	}
	
	@Override
	public void destroy() throws Exception 
	{
		System.out.println("Destroy : Destroying MessageSender : ServerIP :["+serverIp+"] Port : ["+serverPort+"]");
		
	}
	
	public void init()
	{
		System.out.println("My Init : Initializing MessageSender : ServerIP :["+serverIp+"] Port : ["+serverPort+"]");
	}
	
	public void myDestroy()
	{
		System.out.println("My Destroy : Destroying MessageSender : ServerIP :["+serverIp+"] Port : ["+serverPort+"]");
	}

}
