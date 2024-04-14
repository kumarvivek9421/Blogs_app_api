package com.blog_app_apis.controller;

import com.blog_app_apis.services.impl.PdfServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;


@RestController
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    private PdfServiceImpl pdfService;

    @GetMapping("/create")
    public ResponseEntity<InputStreamResource> createPdf(){
        ByteArrayInputStream pdfCreate = pdfService.createPdf();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("content- Disposition", "inline: file= lcwd.pdf");

        return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(pdfCreate));
    }
}
