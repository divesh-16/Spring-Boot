package com.tca.beans;

public class ReportManager 
{
	private int pages;
	private ReportCreator reportCreator;
	
	public ReportManager()
	{
		System.out.println("0-arg Constructor for ReportManager");
	}
	
	public ReportManager(ReportCreator reportCreator)
	{
		System.out.println("Constructor - Injection for ReportManager");
		this.reportCreator = reportCreator;
	}
	
	public void setReportCreator(ReportCreator reportCreator)
	{
		this.reportCreator = reportCreator;
		System.out.println("### Setter Injection ###");
	}
	
	public void setPages(int pages)
	{
		this.pages = pages;
	}
	
	public void printReport()
	{
		reportCreator.createReport(pages);
	}
}
