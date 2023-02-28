package lk.ijse.easyCarRental.controller;

import lk.ijse.easyCarRental.dto.CarDTO;
import lk.ijse.easyCarRental.service.CarService;
import lk.ijse.easyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.URIException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("api/v1/car")
@CrossOrigin
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping
    public ResponseUtil saveCar(@RequestBody CarDTO dto){
        carService.saveCar(dto);
        return new ResponseUtil("200",dto.getCarRegNo()+ " Added...!",null);
    }

/*    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil saveCar(@RequestPart("carImgFiles") MultipartFile[] file, @RequestPart("car") CarDTO dto) {
        for (MultipartFile myFile : file) {
            try {
                String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
                File uploadsDir = new File(projectPath + "/uploads");
                uploadsDir.mkdir();
                myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
                System.out.println(projectPath);
            }  catch (IOException | URISyntaxException e) {
                e.printStackTrace();
                return new ResponseUtil("500", "Registration Failed.Try Again Latter", null);
            }
        }

        carService.saveCar(dto);
        return new ResponseUtil("200", "Registration Successful" , dto);
    }

    @PostMapping(path = "uploadImg/{carRegNo}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE} ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil uploadImage(@RequestPart("fontImage") MultipartFile fontImage, @RequestPart("backImage")
            MultipartFile backImage, @RequestPart("sideImage") MultipartFile sideImage, @RequestPart("interiorImage")
            MultipartFile interiorImage, @PathVariable String carRegNo)
    {
        try {
            String projectPath = String.valueOf(new File("D:\\New folder\\Save_Images"));
            File uploadDir = new File(projectPath + "\\carImage");
            uploadDir.mkdir();

            fontImage.transferTo(new File(uploadDir.getAbsolutePath() + "\\" + fontImage.getOriginalFilename()));
            backImage.transferTo(new File(uploadDir.getAbsolutePath() + "\\" + backImage.getOriginalFilename()));
            sideImage.transferTo(new File(uploadDir.getAbsolutePath() + "\\" + sideImage.getOriginalFilename()));
            interiorImage.transferTo(new File(uploadDir.getAbsolutePath() + "\\" + interiorImage.getOriginalFilename()));

            String img1 = projectPath + "\\carImage" + fontImage.getOriginalFilename();
            String img2 = projectPath + "\\carImage" + backImage.getOriginalFilename();
            String img3 = projectPath + "\\carImage" + sideImage.getOriginalFilename();
            String img4 = projectPath + "\\carImage" + interiorImage.getOriginalFilename();

            carService.uploadCarImg(img1,img2,img3,img4,carRegNo);
            return new ResponseUtil("200", "Uploaded" , null);
        } catch (IOException e) {
            return new ResponseUtil("500", e.getMessage() , null);
        }
    }*/

    @PutMapping
    public ResponseUtil updateCar(@RequestBody CarDTO dto){
        carService.updateCar(dto);
        return new ResponseUtil("200",dto.getCarRegNo()+": Updated.!",null);
    }

    @DeleteMapping(params = {"carRegNo"})
    public ResponseUtil deleteCar(@RequestParam String carRegNo){
        carService.deleteCar(carRegNo);
        return new ResponseUtil("200",carRegNo+" : Deleted.!",null);
    }

    @GetMapping(params = {"carRegNo"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCar(@RequestParam String carRegNo){
        CarDTO dto = carService.searchCar(carRegNo);
        return new ResponseUtil("200","OK",dto);
    }

    @GetMapping
    public ResponseUtil getAllCars(){
        List<CarDTO> cars = carService.getAllCars();
        return new ResponseUtil("200"," Success.!",cars);
    }
}
