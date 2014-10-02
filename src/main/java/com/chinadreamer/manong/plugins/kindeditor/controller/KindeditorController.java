package com.chinadreamer.manong.plugins.kindeditor.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chinadreamer.manong.plugins.utils.FileNameLengthLimitExceededException;
import com.chinadreamer.manong.plugins.utils.FileUploadUtils;
import com.chinadreamer.manong.plugins.utils.InvalidExtensionException;

@Controller
@RequestMapping(value = "kindeditor")
public class KindeditorController {
	
	//图片mime类型
    private static final String[] IMAGE_EXTENSION = FileUploadUtils.IMAGE_EXTENSION;

    //附件mime类型
    private static final String[] ATTACHMENT_EXTENSION = FileUploadUtils.DEFAULT_ALLOWED_EXTENSION;

    //flash mime类型
    private static final String[] FLASH_EXTENSION = FileUploadUtils.FLASH_EXTENSION;

    //swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb
    private static final String[] MEDIA_EXTENSION = FileUploadUtils.MEDIA_EXTENSION;

    //最大上传大小 字节为单位
    private long maxSize = FileUploadUtils.DEFAULT_MAX_SIZE;
    //文件上传下载的父目录
    private String baseDir = FileUploadUtils.getDefaultBaseDir();
    
    @Autowired
    private MessageSource messageSource;

	@RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(
            HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(value = "dir", required = false) String dir,
            @RequestParam(value = "imgFile", required = false) MultipartFile file) {

        response.setContentType("text/html; charset=UTF-8");

        String[] allowedExtension = extractAllowedExtension(dir);

        try {
            String url = FileUploadUtils.upload(request, baseDir, file, allowedExtension, maxSize, true);
            return successResponse(request, file.getOriginalFilename(), url);

        } catch (IOException e) {
            return errorResponse("upload.server.error");
        } catch (InvalidExtensionException.InvalidImageExtensionException e) {
            return errorResponse("upload.not.allow.image.extension");
        } catch (InvalidExtensionException.InvalidFlashExtensionException e) {
            return errorResponse("upload.not.allow.flash.extension");
        } catch (InvalidExtensionException.InvalidMediaExtensionException e) {
            return errorResponse("upload.not.allow.media.extension");
        } catch (InvalidExtensionException e) {
            return errorResponse("upload.not.allow.extension");
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            return errorResponse("upload.exceed.maxSize");
        } catch (FileNameLengthLimitExceededException e) {
            return errorResponse("upload.filename.exceed.length");
        }

    }
    
	private String[] extractAllowedExtension(String dir) {
        if ("image".equals(dir)) {
            return IMAGE_EXTENSION;
        } else if ("flash".equals(dir)) {
            return FLASH_EXTENSION;
        } else if ("media".equals(dir)) {
            return MEDIA_EXTENSION;
        } else {
            return ATTACHMENT_EXTENSION;
        }

    }
	
	private String successResponse(HttpServletRequest request, String filename, String url) {
        return "{\"error\":0, \"url\":\"" + request.getContextPath() + "/" + url + "\", \"title\":\"" + filename + "    \"}";
    }

    private String errorResponse(String errorCode) {
        String message = messageSource.getMessage(errorCode, null, null);
        if (message.contains("<br/>")) {
            message = message.replace("<br/>", "\\n");
        }
        return "{\"error\":1, \"message\":\"" + message + "\"}";
    }
}
