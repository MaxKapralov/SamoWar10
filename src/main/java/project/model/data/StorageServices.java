package project.model.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.model.repositories.ImageRepository;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Maksim Kapralov on 5/22/2018.
 */
@Service
public class StorageServices
{
    private final Path rootDirectory = Paths.get("C://Project//images");

    private ImageRepository imageRepository;

    @Autowired
    public void setImageRepository(ImageRepository imageRepository)
    {
        this.imageRepository = imageRepository;
    }

    public void store(MultipartFile file, Long idCar)
    {
        try
        {
            Files.copy(file.getInputStream(), this.rootDirectory.resolve(file.getOriginalFilename()));
            imageRepository.save(new Image(idCar, file.getOriginalFilename()));
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public Resource load(Long idCar)
    {
        try
        {
            Image img = imageRepository.findByIdCar(idCar);
            Path file = rootDirectory.resolve(img.getPath());
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable())
            {
                return resource;
            }
        }catch(MalformedURLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
