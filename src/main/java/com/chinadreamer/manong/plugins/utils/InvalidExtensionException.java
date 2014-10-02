package com.chinadreamer.manong.plugins.utils;

import org.apache.commons.fileupload.FileUploadException;

import java.util.Arrays;

public class InvalidExtensionException extends FileUploadException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 822600999625837808L;
	private String[] allowedExtension;
    private String extension;
    private String filename;

    public InvalidExtensionException(String[] allowedExtension, String extension, String filename) {
        super("filename : [" + filename + "], extension : [" + extension + "], allowed extension : [" + Arrays.toString(allowedExtension) + "]");
        this.allowedExtension = allowedExtension;
        this.extension = extension;
        this.filename = filename;
    }

    public String[] getAllowedExtension() {
        return allowedExtension;
    }

    public String getExtension() {
        return extension;
    }

    public String getFilename() {
        return filename;
    }

    public static class InvalidImageExtensionException extends InvalidExtensionException {
        /**
		 * 
		 */
		private static final long serialVersionUID = 726698663435754243L;

		public InvalidImageExtensionException(String[] allowedExtension, String extension, String filename) {
            super(allowedExtension, extension, filename);
        }
    }

    public static class InvalidFlashExtensionException extends InvalidExtensionException {
        /**
		 * 
		 */
		private static final long serialVersionUID = -8689130766058790085L;

		public InvalidFlashExtensionException(String[] allowedExtension, String extension, String filename) {
            super(allowedExtension, extension, filename);
        }
    }

    public static class InvalidMediaExtensionException extends InvalidExtensionException {
        /**
		 * 
		 */
		private static final long serialVersionUID = 5529331340802590894L;

		public InvalidMediaExtensionException(String[] allowedExtension, String extension, String filename) {
            super(allowedExtension, extension, filename);
        }
    }

}

