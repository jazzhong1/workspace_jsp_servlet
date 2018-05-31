package common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{
	
	@Override
	public File rename(File oldFile) {
		File newFile=null;
		do {
			long currentTime=System.currentTimeMillis();
			//현재시간을 가져오는 메서드.
			//날짜 형식으로 밀리 세컨까지 표시
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			//0~999까지의 임의이 수 난수발생.
			//확장자명 가져오기
			int rndNum=(int)(Math.random()*1000);
			String oldName=oldFile.getName();
			//확장자명
			String ext="";
			int dot=oldName.indexOf("."); 
			
			if(dot>-1){
				ext=oldName.substring(dot);  //포함해서 시작
			}
			String newName=sdf.format(currentTime)+"_"+rndNum+ext;
			newFile=new File(oldFile.getParentFile(),newName);
			//newFile에서 만들어주기때문에  내려가서 false를 리턴한다. 무조건.
			System.out.println(newFile);
		} while (!createFile(newFile)); //중복된것 있나 없나 체크. 중복값이 발생하지않게 무한반복처리를해서 돈다.
		return newFile;
	}

	public boolean createFile(File newFile) {
		try {
			//createNewFile() 파일을 생성하는 메소드로
			//만약에 생성하는곳에 파일이 있으면 생성하지ㅏ않고
			//exception발생/없으면 true리턴
											//중복이 있는지없는지 체크하는것이 여기 null이아닌 파일명이 있는지없는지만 확인
											//newFIle에 경로(getParentFile)와이름을 둘이 체크하고 확인하고 리턴한다. 
			boolean flag=newFile.createNewFile();
			return flag;
		} catch (IOException e) {
			return false;
		}
	}

}
