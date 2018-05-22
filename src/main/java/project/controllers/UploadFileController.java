package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import project.model.data.StorageServices;


/**
 * Created by Maksim Kapralov on 5/22/2018.
 */
@RestController
public class UploadFileController {


    private StorageServices storageServices;

    @Autowired
    public void setStorageServices(StorageServices storageServices)
    {
        this.storageServices = storageServices;
    }

    @PostMapping("/image")
    public ResponseEntity<String> handleFileUpload(@RequestParam("image")MultipartFile file, @RequestParam("idCar") Long idCar)
    {
        try
        {
            storageServices.store(file, idCar);
            return ResponseEntity.status(HttpStatus.OK).body("File succesfully uploaded");
        }catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Uploading failed!");
        }
    }

    @GetMapping("/image")
    public ResponseEntity<Resource> getFile(@RequestParam("idCar") Long idCar)
    {
        Resource file = storageServices.load(idCar);
        return ResponseEntity.status(HttpStatus.OK).body(file);
    }
}
