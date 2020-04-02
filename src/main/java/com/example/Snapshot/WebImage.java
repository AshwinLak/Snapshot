package com.example.Snapshot;

import com.pdfcrowd.Pdfcrowd;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.io.*;
import java.nio.file.Files;

@RestController
@RequestMapping("/")
public class WebImage {

    @Value( "${user}" )
    private String user;

    @Value( "${password}")
    private String password;

    @GetMapping(
            value = "/snapshot",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getImageWithMediaType(@QueryParam("url") String url) throws IOException {

        try {
            //Neither Creating any service for simplicity
            //nor creating Local variable which we usually do
            Pdfcrowd.HtmlToImageClient client = new Pdfcrowd.HtmlToImageClient(user, password);
            client.setOutputFormat("png");
            File file  = File.createTempFile("image", ".png");
            client.convertUrlToFile(url, file.getPath());
            return Files.readAllBytes(file.toPath());
        }catch(Pdfcrowd.Error why) {
            throw why;
        }
    }


}

