package org.catrobat.catroid;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResourceController {

	private static Path tempPath = HomeController.tempPath;

	@RequestMapping(value = "/image/{path:.+}", method = RequestMethod.GET)
	public void getImage(@PathVariable String path, Model model,
			HttpServletResponse response, HttpSession session) {

		File source = new File(tempPath + File.separator + session.getId()
				+ File.separator + "images" + File.separator + path);
		
		response.setContentType("image/png");
		response.setContentLength((int) source.length());
		copyToResponse(response, source);
	}
	
	@RequestMapping(value = "/sound/{path:.+}", method = RequestMethod.GET)
	public void getSound(@PathVariable String path, Model model,
			HttpServletResponse response, HttpSession session) {

		File source = new File(tempPath + File.separator + session.getId()
				+ File.separator + "sounds" + File.separator + path);
//		return new FileSystemResource(source);
		response.setContentType("sound/mp3");
		response.setContentLength((int) source.length());
		copyToResponse(response, source);
	}

	private void copyToResponse(HttpServletResponse response, File source) {
		FileInputStream in = null;
		ServletOutputStream out = null;
		try {
			in = new FileInputStream(source);
			out = response.getOutputStream();
			IOUtils.copyLarge(in, out);
			out.flush();
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
