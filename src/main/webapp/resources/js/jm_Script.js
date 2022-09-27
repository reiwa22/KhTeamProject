/**
 *
 */

function isImage(filename){
	var extName = filename.substring(filename.lastIndexOf(".")+1).toUpperCase();
	if(extName=="JPG"||extName=="PNG"||extName=="GIF"){
		return true;
	}
	return false;
	
}