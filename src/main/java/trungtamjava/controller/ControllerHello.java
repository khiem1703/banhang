package trungtamjava.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller

public class ControllerHello {

	@RequestMapping(value = { "uploadfile" }, method = RequestMethod.GET)
	public String upload(HttpServletRequest request) {
		return "upload";
	}

	@RequestMapping(value = { "upload" }, method = RequestMethod.POST)
	public String upload(HttpServletRequest request, @RequestParam(value = "file") MultipartFile file) {
		try {
			File newFile = new File("C:\\Users\\khiem\\Desktop\\luufile\\" + file.getOriginalFilename());
			FileOutputStream fileOutputStream;

			fileOutputStream = new FileOutputStream(newFile);

			fileOutputStream.write(file.getBytes());
			fileOutputStream.close();
		} catch (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
			request.setAttribute("file", file);
		}
		return "viewFile";
	}

	public static void main(String[] args) {

	}

}