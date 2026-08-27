package com.tca.beans;

public class ExcelReportCreator implements ReportCreator 
{
	public ExcelReportCreator()
	{
		System.out.println("0-arg Constructor for ExcelReportCreator");
	}

	@Override
	public void createReport(int p) 
	{
		System.out.println("ExcelReportCreator : Generating Reports for no. of pages : "+p);
	}

}
