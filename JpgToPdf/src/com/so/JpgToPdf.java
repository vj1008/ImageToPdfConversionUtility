package com.so;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class JpgToPdf
{
	/**
	 * This program will take an image in .JPG format from a particular location and
	 * will convert it to .PDF file on the same location
	 * 
	 * @param arg
	 * @throws Exception
	 */
	public static void main(String arg[]) throws Exception
	{
		String dirPath = "E:\\RentReceipts";
		File dir = new File(dirPath);
		File[] files = dir.listFiles();

		for (File f : files)
		{
			String fileName=f.getName();
			String outputFile = fileName.replace(".jpg", ".pdf");
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(new File(dirPath, outputFile)));
			document.open();
			document.newPage();
			Image image = Image.getInstance(new File(dirPath, fileName).getAbsolutePath());
			image.setAbsolutePosition(0, 550);
			image.setBorderWidth(0);
			image.scaleToFit(595, 842);
			document.add(image);
			document.close();
		}
		System.out.println("Done");
	}
}