package nl.scholtens.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class ImageController {

    @RequestMapping(value = "/image/{imageName}", method = RequestMethod.GET)
    public @ResponseBody
    byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {
        File file = new File("/data/temp/images/" + imageName + ".png");
        return Files.readAllBytes(file.toPath());
    }
}
