package common;

import java.io.File;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File oldFile) {
			File newFile=null;
		do {
			long currentTime=System.currentTimeMillis();
			//현재시간을가져오는메서드
			//날짜형식ㅇ으로 미리세컨까지표시
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyMMdd_HHmmssSSS");
			
			//0~99까지 임의이 난수발생
			int randomNum=(int)(Math.random()*1000);

			//확장자명 가져오기
			String oldName=oldFile.getName();
			//알아서 가져오나?
			
			String ext="";
			int dot=oldName.indexOf(".");
			
			if(dot>-1){
				ext=oldName.substring(dot);
			}
			String newName=sdf.format(currentTime)+"_"+randomNum+ext;
			//newFile에서 만들어주기때문에  내려가서 false를 리턴한다. 무조건.
			System.out.println(newFile);

			
		} while (!createFile(newFile)); //동일주소값만보내기때문에 생성은 밑에서한ㄷ.ㅏ
									//처음은거깆이기떄문에 한번돈다 이래서 do~while쓴듯..
		return newFile;
	}

	private boolean createFile(File newFile) {
		try {
			//createNewFile()파일을 생성하는메소드로
			//만약 생성하는곳에 파일이 있으면생성하지않고 
			//중복이 있는지없는지 체크하는것이 여기 null이아닌 파일명이 있는지없는지만 확인
			//newFIle에 경로(getParentFile)와이름을 둘이 체크하고 확인하고 리턴한다. 
			
			boolean flag=newFile.createNewFile();
			return flag;
			
		} catch (Exception e) {
			return false;
		}
	}

}
