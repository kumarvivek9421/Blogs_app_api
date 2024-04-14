package com.blog_app_apis.services.impl;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfServiceImpl {

    private Logger logger= LoggerFactory.getLogger(PdfServiceImpl.class);

    public ByteArrayInputStream createPdf(){

        logger.info("create pdf started...!!");
        String title= "welcome to learn code...";
        String content= "we are provide technical content...";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document= new Document(); // (import from: com.lowagie.text.Document)
        PdfWriter.getInstance(document, outputStream);
        document.open();

//        Create Pdf for Title

        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 25);
        Paragraph paragraphTitle = new Paragraph(title, fontTitle);
        paragraphTitle.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraphTitle);

//        Create Pdf for Content

        Font fontContent = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
        Paragraph paragraphContent = new Paragraph(content, fontContent);
        paragraphContent.setAlignment(Element.ALIGN_LEFT);
        paragraphContent.add("was this text is good...");
        document.add(paragraphContent);
        document.close();


        return new ByteArrayInputStream(outputStream.toByteArray());
    }
}
