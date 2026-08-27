package com.tca.beans;

public class PdfReportCreator implements ReportCreator 
{
	public PdfReportCreator()
	{
		System.out.println("0-arg Constructor for PdfReportCreator");
	}
	
	@Override
	public void createReport(int p) 
	{
		System.out.println("PdfReportCreator : Generating Reports for no. of pages : "+p);
	}

}
