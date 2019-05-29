package common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class SellBarFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File oldFile) {
		File newFile = null;
		do {
			long currentTime = System.currentTimeMillis();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd_HHmmssSSS");
			int rndNum = (int)(Math.random()*1000);
			
			//확장자명 가져오기
			String oldName = oldFile.getName();
			String ext = "";
			int dot = oldName.lastIndexOf(".");
			if(dot > -1) {
				ext = oldName.substring(dot);
			}
<<<<<<< HEAD
			
			
=======
			//확인
>>>>>>> refs/remotes/choose_remote_name/SeUh
			//새로운 파일명
			String newName = sdf.format(new Date(currentTime))
						+ "_"
						+ rndNum
						+ ext;
			newFile = new File(oldFile.getParentFile(), newName);
		}while(!createNewFile(newFile));
		return newFile;
	}

	public boolean createNewFile(File newFile) {
		//파일이 존재하면, false 리턴
		//파일이 존재 하지않으면 파일을 생성하고 true 리턴
		try {
			return newFile.createNewFile();
		} catch(IOException e) {
			return false;
		}
	}
}
